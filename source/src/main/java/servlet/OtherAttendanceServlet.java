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
//		if(session.getAttribute("Pidpw") == null || session.getAttribute("Sidpw") == null) {
//			response.sendRedirect(request.getContextPath() +"/OtherLoginServlet");
//			return;
//		}
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
		attendance = attendanceInfo.attendanceSelect(studentId);
		
		
		//リクエスト領域に保存
		request.setAttribute("attendance", attendance);
		request.setAttribute("today", formattedDate);
		
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
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
//		if(session.getAttribute("Pidpw") == null || session.getAttribute("Sidpw") == null) {
//			response.sendRedirect(request.getContextPath() +"/OtherLoginServlet");
//			return;
//		}
		
		// セッションパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int attendantId = Integer.parseInt(request.getParameter("attid"));
		int number = Integer.parseInt(request.getParameter("number"));
		String status = request.getParameter("status");
		String attendanceDate = request.getParameter("attdate");
		
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
		attendance = attendanceInfo.attendanceSelect(studentId);
		
		
		//リクエスト領域に保存
		request.setAttribute("attendance", attendance);
		request.setAttribute("today", formattedDate);
		
		session.setAttribute("attendanceDate", attendance);
		session.setAttribute("today",formattedDate);
		
		
		//出席登録・欠席登録
		String submit = request.getParameter("submit");
		String position = (String) session.getAttribute("position");
		if ("欠席登録".equals(submit)) {
			if(position.equals("student")) {
				if(attendanceInfo.update(new Attendance(attendantId, number, "出席", attendanceDate))) {
					request.setAttribute("msg", "更新しました。");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Sjsp/student_today_attend.jsp");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("errormsg", "更新に失敗しました。");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Sjsp/student_today_attend.jsp");
					dispatcher.forward(request, response);
				}  
			}
		else {
			if(position.equals("parent")) {
				if(attendanceInfo.update(new Attendance(attendantId, number, "欠席", attendanceDate))) {
					request.setAttribute("msg", "更新しました。");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/parent_today_attend.jsp");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("errormsg", "更新に失敗しました。");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/parent_today_attend.jsp");
					dispatcher.forward(request, response);
				}
			
			}
		}
		}
		
	}
}
