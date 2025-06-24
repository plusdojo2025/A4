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
import dto.Tests;

@WebServlet("/OtherGradeServlet")
public class OtherGradeServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("position") == null && session.getAttribute("studentName") == null ||
			session.getAttribute("position") == null && session.getAttribute("parentName") == null) {
			response.sendRedirect(request.getContextPath() +"/OtherLoginServlet");
			return;
		}
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
		if (session.getAttribute("position") == null && session.getAttribute("studentName") == null ||
			session.getAttribute("position") == null && session.getAttribute("parentName") == null) {
			response.sendRedirect(request.getContextPath() +"/OtherLoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int number = Integer.parseInt(request.getParameter("number"));
		String test = request.getParameter("testName");
		int term = Integer.parseInt(request.getParameter("term"));
			
		// 検索処理を行う
		TestsDAO t = new TestsDAO();
		ArrayList<Tests> list = new ArrayList<Tests>();
		list = t.select(new Tests(number, term, test));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("scoreList", list);

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
}
