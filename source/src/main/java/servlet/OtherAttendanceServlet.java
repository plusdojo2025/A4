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
		if(session.getAttribute("position") == null && session.getAttribute("studentName") == null ||
			session.getAttribute("position") == null && session.getAttribute("patrentName") == null) {
			response.sendRedirect(request.getContextPath() +"/OtherLoginServlet");
			return;
		}
		//学籍番号取得
		Sidpw studentInfo = new Sidpw();
		studentInfo = (Sidpw)session.getAttribute("Sidpw");
		int studentId = studentInfo.getNumber();
		
		//その日の日付を取得
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formattedDate = today.format(formatter);
		
		//出席情報を取得
		AttendanceDAO attendanceInfo = new AttendanceDAO();
		Attendance attendance = new Attendance();
		attendance = attendanceInfo.attendanceSelect(studentId, formattedDate);
		
		//リクエスト領域に保存
		request.setAttribute("attendanceDate", attendance);
		
		// ユーザーの種類に応じてJSPを振り分け
		String position = (String) session.getAttribute("position");
		if ("student".equals(position)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Sjsp/student_today_attend.jsp");
			dispatcher.forward(request, response);
		} else if ("parent".equals(position)) {
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
        attendance = (Attendance)request.getAttribute("attendanceStatus");
        int attendantId = attendance.getAttendantId();
        int number = attendance.getNumber();
        String status = request.getParameter("status");
        String attendanceDate = attendance.getAttendanceDate();
        
		//出席登録・欠席登録
		if(position.equals("student")) {
			if(attendDao.update(new Attendance(attendantId,number,status,attendanceDate))) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Sjsp/student_month_attend.jsp");
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Sjsp/student_today_attend.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		else if(position.equals("parent")) {
			if(attendDao.update(new Attendance(attendantId,number,status,attendanceDate))) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/parent_month_attend.jsp");
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/parent_today_attend.jsp");
				dispatcher.forward(request, response);
			}
			
		}
	}
}
