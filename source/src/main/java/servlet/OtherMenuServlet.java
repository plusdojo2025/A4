package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OtherMenuServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("position") == null && session.getAttribute("studentName") == null ||
			session.getAttribute("position") == null && session.getAttribute("parentName") == null) {
			response.sendRedirect("/A4/OtherLoginServlet");
			return;
		}

        // ホームページにフォワードする
        if(session.getAttribute("position").equals("生徒")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Sjsp/student_home.jsp");
		    dispatcher.forward(request, response);
        }
		else if(session.getAttribute("position").equals("保護者")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/parent_home.jsp");
		    dispatcher.forward(request, response);
        }
    }

}