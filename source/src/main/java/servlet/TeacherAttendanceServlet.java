package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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


@WebServlet("/TeacherAttendanceServlet")
public class TeacherAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession(false); // 既存セッションのみ取得
		if (session == null || session.getAttribute("Tidpw") == null) {
		    response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
		    return;
		}

		// 今日の日付を取得
	    LocalDate today = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	    String formattedDate = today.format(formatter);

	    // 出席DAOを使ってそのクラスの出席情報を取得
	    AttendanceDAO attendanceInfo = new AttendanceDAO();
	    List<Allaccess> attendance = new ArrayList<Allaccess>();
		
		attendance = attendanceInfo.select(formattedDate);

		//リクエスト領域に保存
		request.setAttribute("attendanceList", attendance);
		request.setAttribute("today", formattedDate);
		
		// 出席管理ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_today_attend.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession(false); // 既存セッションのみ取得
		if (session == null || session.getAttribute("Tidpw") == null) {
		    response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
		    return;
		}
		
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String attdate = request.getParameter("attdate");
		int number = Integer.parseInt(request.getParameter("number"));
		String sName = request.getParameter("sName");
		String attendance = request.getParameter("attendance");
		
		// 更新を行う
		AttendanceDAO attDao = new AttendanceDAO();
		attDao.update(new Allaccess(number,sName,attendance,attdate));
		
	    
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_today_attend.jsp");
		dispatcher.forward(request, response);
	}	
}
