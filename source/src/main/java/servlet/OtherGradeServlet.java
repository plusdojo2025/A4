package servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TestsDAO;
import dto.Pidpw;
import dto.Sidpw;
import dto.Tests;

@WebServlet("/OtherGradeServlet")
public class OtherGradeServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
//		if(session.getAttribute("Pidpw") == null || session.getAttribute("Sidpw") == null) {
//			response.sendRedirect(request.getContextPath() +"/OtherLoginServlet");
//			return;
//		}
		String position = (String)session.getAttribute("position");
		
		// 成績ページにフォワードする
		if(position.equals("student")) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Sjsp/student_score.jsp");
		dispatcher.forward(request, response);
		}
		else if(position.equals("parent")) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/parent_score.jsp");
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
		request.setCharacterEncoding("UTF-8");
		String position = (String)session.getAttribute("position");
		int studentId=0;
		// リクエストパラメータを取得する
		if(position.equals("student")) {
			Sidpw studentInfo = new Sidpw();
			studentInfo = (Sidpw)session.getAttribute("Sidpw");
			studentId = studentInfo.getNumber();
//			System.out.println(studentId);
		}
		else if(position.equals("parent")) {
			Pidpw parentInfo = new Pidpw();
			parentInfo = (Pidpw)session.getAttribute("Pidpw");
			studentId = parentInfo.getNumber();
//			System.out.println(studentId);
		}
		String testName = request.getParameter("testName");
		int term = Integer.parseInt(request.getParameter("term"));
			
		// 検索処理を行う
		TestsDAO t = new TestsDAO();
		ArrayList<Tests> list = new ArrayList<Tests>();
//		System.out.println(studentId+", "+term+", "+testName);
		list = t.select(new Tests(studentId, term, testName));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("scoreList", list);

		
		// 成績ページにフォワードする
		if(position.equals("student")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Sjsp/student_score.jsp");
			dispatcher.forward(request, response);
		}
		else if(position.equals("parent")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/parent_score.jsp");
			dispatcher.forward(request, response);
		}
	}
}
