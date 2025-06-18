package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/A4/OtherMessageServlet")

public class OtherMessageServlet extends HttpServlet{
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
		
		// お知らせページにフォワードする
		if(position.equals("生徒")) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Sjsp/student_announce.jsp");
		dispatcher.forward(request, response);
		}else if(position.equals("保護者")) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Pjsp/parent_announce.jsp");
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
		
		//
		

			String position = (String)session.getAttribute("position");
			// お知らせページにフォワードする
			if(position.equals("生徒")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Sjsp/parent_annouunce.jsp");
				dispatcher.forward(request, response);
				}else if(position.equals("保護者")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Pjsp/student_annouunce.jsp");
				dispatcher.forward(request, response);
				}
		}
}
