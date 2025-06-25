package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AttendanceDAO;
import dto.Attendance;
import dto.Sidpw;

@WebServlet("/OtherAttendanceServlet")
public class OtherAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if(session.getAttribute("Pidpw") == null || session.getAttribute("Sidpw") == null) {
			response.sendRedirect(request.getContextPath() +"/OtherLoginServlet");
			return;
		}
		//学籍番号取得
		Sidpw studentInfo = new Sidpw();
		studentInfo = (Sidpw)session.getAttribute("Sidpw");
		int studentId = studentInfo.getNumber();
		
		//その日の日付を取得
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = today.format(formatter);

		//出席情報を取得
		AttendanceDAO attendanceInfo = new AttendanceDAO();
		Attendance attendance = new Attendance();
		attendance = attendanceInfo.attendanceSelect(studentId, formattedDate);
		
		//リクエスト領域に保存
		session.setAttribute("attendanceDate", attendance);
		session.setAttribute("today",formattedDate);
		// ユーザーの種類に応じてJSPを振り分け
		String position = (String) session.getAttribute("position");
		if (position.equals("student")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Sjsp/student_today_attend.jsp");
			dispatcher.forward(request, response);
		} else if (position.equals("parent")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/parent_today_attend.jsp");
			dispatcher.forward(request, response);
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// セッションパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String position = (String)session.getAttribute("position");
		//出席情報をリクエスト領域から取得
        AttendanceDAO attendDao = new AttendanceDAO();
        Attendance attendance = new Attendance();
        attendance = (Attendance)session.getAttribute("attendanceDate");
        int attendantId = attendance.getAttendantId();
        int number = attendance.getNumber();
        String status = request.getParameter("status");
        System.out.println(status);
        
        String attendanceDate = (String)session.getAttribute("today");
        
        System.out.println(position);
        System.out.println(attendanceDate);
        System.out.println(attendantId);
		//出席登録・欠席登録
		if(position.equals("student")) {
			if(attendDao.update(new Attendance(attendantId,number,status,attendanceDate))) {
				response.sendRedirect(request.getContextPath() + "/OtherAttendanceServlet");
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Sjsp/student_today_attend.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		else if(position.equals("parent")) {
			if(attendDao.update(new Attendance(attendantId,number,status,attendanceDate))) {
				response.sendRedirect(request.getContextPath() + "/OtherAttendanceServlet");
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/parent_today_attend.jsp");
				dispatcher.forward(request, response);
			}
			
		}
	}
}
