package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OtherDisplayAttendanceServlet")
public class OtherDisplayAttendanceServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if(session.getAttribute("Pidpw") == null || session.getAttribute("Sidpw") == null) {
			response.sendRedirect(request.getContextPath() +"/OtherLoginServlet");
			return;
		}
				
		String position = (String) session.getAttribute("position");
		if(position.equals("student")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Sjsp/student_today_atted.jsp");
			dispatcher.forward(request, response);
		}
		else if (position.equals("parent")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/parent_today_attend.jsp");
			dispatcher.forward(request, response);
		}
	}
}
