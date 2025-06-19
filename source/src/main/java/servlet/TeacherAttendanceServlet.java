package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AttendanceDAO;
import dto.Allaccess;

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
		
		// 出席管理ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Pjsp/teacher_today_attend.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if(session.getAttribute("teacherName") == null && session.getAttribute("teacherPw") == null){
			response.sendRedirect("A4/TeacherLoginServlet");
			return;
		}
		
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String attdate = request.getParameter("attdate");
		String number = request.getParameter("number");
		String attup = request.getParameter("attup");
		
		// 更新を行う
		AttendanceDAO attDao = new AttendanceDAO();
		request.getParameter("submit").equals("更新");
		attDao.update(new Allaccess(attdate,number,attup));
		
	    
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Pjsp/teacher_today_attend.jsp");
		dispatcher.forward(request, response);
	}	
}
