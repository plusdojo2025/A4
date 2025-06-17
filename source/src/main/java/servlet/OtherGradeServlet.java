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

@WebServlet("/A4/OtherGradeServlet")

public class OtherGradeServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("position") == null && session.getAttribute("studentName") == null ||
			session.getAttribute("position") == null && session.getAttribute("parentName") == null) {
			response.sendRedirect("/A4/OtherLoginServlet");
			return;
		}
		String position = (String)session.getAttribute("position");
		
		// 成績ページにフォワードする
		if(position.equals("生徒")) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Sjsp/student_score.jsp");
		dispatcher.forward(request, response);
		}else if(position.equals("保護者")) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Pjsp/parent_score.jsp");
		dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("position") == null && session.getAttribute("studentName") == null ||
			session.getAttribute("position") == null && session.getAttribute("parentName") == null) {
			response.sendRedirect("/A4/OtherLoginServlet");
			return;
		}

			// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String number = request.getParameter("number");
			String test = request.getParameter("testName");
			String term = request.getParameter("term");
			
			// 検索処理を行う
			TestsDAO t = new TestsDAO();
			ArrayList<Tests> list = new ArrayList<Tests>();
			list = t.select(new Tests(number, test, term));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("scoreList", list);

			String position = (String)session.getAttribute("position");
			// 成績ページにフォワードする
			if(position.equals("生徒")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Sjsp/parent_score.jsp");
				dispatcher.forward(request, response);
				}else if(position.equals("保護者")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Pjsp/student_score.jsp");
				dispatcher.forward(request, response);
				}
		}
}
