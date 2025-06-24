package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OtherMenuServlet")
public class OtherMenuServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("position") == null && session.getAttribute("studentName") == null ||
			session.getAttribute("position") == null && session.getAttribute("parentName") == null) {
			response.sendRedirect(request.getContextPath() +"/OtherLoginServlet");
			return;
		}

		
        // ホームページにフォワードする
        if(session.getAttribute("position").equals("student")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Sjsp/student_home.jsp");
		    dispatcher.forward(request, response);
        }
		else if(session.getAttribute("position").equals("parent")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/parent_home.jsp");
		    dispatcher.forward(request, response);
        }
    }

}