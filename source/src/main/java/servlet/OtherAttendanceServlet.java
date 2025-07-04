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
import dao.SidpwDAO;
import dto.Attendance;
import dto.Pidpw;
import dto.Sidpw;

@WebServlet("/OtherAttendanceServlet")
public class OtherAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
//		if(session.getAttribute("Pidpw") == null || session.getAttribute("Sidpw") == null) {
//			response.sendRedirect(request.getContextPath() +"/OtherLoginServlet");
//			return;
//		}
		// 学籍番号取得
		Sidpw studentInfo1 = new Sidpw();
		studentInfo1 = (Sidpw) session.getAttribute("Sidpw");
		Pidpw studentInfo2 = new Pidpw();
		studentInfo2 = (Pidpw) session.getAttribute("Pidpw");
		int studentId = 99;
		String studentName = "";
		if (studentInfo1 != null) {
			studentId = studentInfo1.getNumber();
			studentName = studentInfo1.getsName();
		} else {
			studentId = studentInfo2.getNumber();
			SidpwDAO sDao = new SidpwDAO();
			studentName = sDao.selectStudentName(studentId);
		}

		// その日の日付を取得
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = today.format(formatter);
		System.out.println(studentId);
		// 出席情報を取得
		AttendanceDAO attendanceInfo = new AttendanceDAO();
		Attendance attendance = new Attendance();
		attendance = attendanceInfo.attendanceSelect(studentId, formattedDate);

		// リクエスト領域に保存
		request.setAttribute("attendance", attendance);
		request.setAttribute("studentName", studentName);
		request.setAttribute("today", formattedDate);

		session.setAttribute("attendanceDate", attendance);
		session.setAttribute("studentName", studentName);
		session.setAttribute("today", formattedDate);

		// ユーザーの種類に応じてJSPを振り分け
		String position = (String) session.getAttribute("position");
		System.out.println(position + "あてんだんすのポジションだよ");
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
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
//		if(session.getAttribute("Pidpw") == null || session.getAttribute("Sidpw") == null) {
//			response.sendRedirect(request.getContextPath() +"/OtherLoginServlet");
//			return;
//		}

		// セッションパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int attendantId = Integer.parseInt(request.getParameter("attid"));
		int number = Integer.parseInt(request.getParameter("number"));
		String attendanceDate = request.getParameter("attdate");

//		//学籍番号取得
//		Sidpw studentInfo1 = new Sidpw();
//		studentInfo1 = (Sidpw)session.getAttribute("Sidpw");
//		Pidpw studentInfo2 = new Pidpw();
//		studentInfo2 = (Pidpw)session.getAttribute("Pidpw");
//		int studentId = 99;
//		if(studentInfo1 != null) {
//			studentId= studentInfo1.getNumber();
//		}else {
//			studentId= studentInfo2.getNumber();
//		}
//		
//		//その日の日付を取得
//		LocalDate today = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String formattedDate = today.format(formatter);
//
//		//出席情報を取得
		AttendanceDAO attendanceInfo = new AttendanceDAO();
//		attendance = attendanceInfo.attendanceSelect(studentId,formattedDate);
//		
//		
//		//リクエスト領域に保存
//		request.setAttribute("attendance", attendance);
//		request.setAttribute("today", formattedDate);
//		
//		session.setAttribute("attendanceDate", attendance);
//		session.setAttribute("today",formattedDate);

		// 出席登録・欠席登録
		String submit = request.getParameter("submit");
		String position = (String) session.getAttribute("position");
		if ("出席登録".equals(submit)) {
			if (position.equals("student")) {
				if (attendanceInfo.insert(new Attendance(attendantId, number, "出席", attendanceDate))) {
					request.setAttribute("msg", "更新しました。");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/WEB-INF/Sjsp/student_today_attend.jsp");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("errormsg", "更新に失敗しました。");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/WEB-INF/Sjsp/student_today_attend.jsp");
					dispatcher.forward(request, response);
				}
			}
		} 
		else if ("欠席登録".equals(submit)) {
			if (position.equals("parent")) {
				if (attendanceInfo.update(new Attendance(attendantId, number, "欠席", attendanceDate))) {
					request.setAttribute("msg", "更新しました。");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/WEB-INF/Pjsp/parent_today_attend.jsp");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("errormsg", "更新に失敗しました。");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/WEB-INF/Pjsp/parent_today_attend.jsp");
					dispatcher.forward(request, response);
				}

			}
		}

	}
}
