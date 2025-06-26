package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AttendanceDAO;
import dto.Allaccess;
import dto.Attendance;


@WebServlet("/TeacherAttendanceServlet")
public class TeacherAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession(false); // 既存セッションのみ取得
		if (session.getAttribute("Tidpw") == null) {
		    response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
		    return;
		}

		// 今日の日付を取得
	    String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

	    // 出席DAOを使ってそのクラスの生徒の出席情報を取得
	    AttendanceDAO dao = new AttendanceDAO();
	    List<Allaccess> attendanceList = dao.select(today);

		//リクエスト領域に保存
		request.setAttribute("attendanceList", attendanceList);
		request.setAttribute("today", today); // 日付も渡す
		
		// 出席管理ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_today_attend.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession(false); // 既存セッションのみ取得
		if (session.getAttribute("Tidpw") == null) {
		    response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
		    return;
		}
		
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int attendantId = Integer.parseInt(request.getParameter("attid"));
		int number = Integer.parseInt(request.getParameter("number"));
		String status = request.getParameter("attendance");
		String attendanceDate = request.getParameter("attdate");
		
		// 更新を行う
		AttendanceDAO attDao = new AttendanceDAO();
		if(request.getParameter("submit").equals("更新")) {
			if(attDao.update(new Attendance(attendantId,number,status,attendanceDate))){
				request.setAttribute("msg","レコードを更新しました。");
				// 今日の日付を取得
			    String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

			    // 出席DAOを使ってそのクラスの生徒の出席情報を取得
			    AttendanceDAO dao = new AttendanceDAO();
			    List<Allaccess> attendanceList = dao.select(today);

				//リクエスト領域に保存
				request.setAttribute("attendanceList", attendanceList);
				request.setAttribute("today", today); // 日付も渡す
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_today_attend.jsp");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("errormsg","レコードを更新できませんでした。");
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_today_attend.jsp");
				dispatcher.forward(request, response);
			}
			
		}
	    
		
	}	
}
