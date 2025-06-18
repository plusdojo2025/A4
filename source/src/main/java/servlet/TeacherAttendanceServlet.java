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

@WebServlet("/A4/TeacherAttendanceServlet")
public class TeacherAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if(session.getAttribute("teacherName") == null && session.getAttribute("teacherPw") == null){
			response.sendRedirect("A4/TeacherLoginServlet");
			return;
		}
		//学籍番号取得
		Sidpw studentInfo = new Sidpw();
		studentInfo = (Sidpw)session.getAttribute("Sidpw");
		String studentId = studentInfo.getNumber();
		//その日の日付を取得
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formattedDate = today.format(formatter);
		//出席情報を取得
		AttendanceDAO attendanceInfo = new AttendanceDAO();
		Attendance attendance = new Attendance();
		attendance = attendanceInfo.attendanceSelect(studentId, formattedDate);
		
		//リクエスト領域に保存
		request.setAttribute("attendanceStatus", attendance);
		
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Pjsp/other_login.jsp");
		dispatcher.forward(request, response);
	}
}
