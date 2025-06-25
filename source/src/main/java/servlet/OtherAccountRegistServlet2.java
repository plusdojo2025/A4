package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OtherAccountRegistServlet2")
public class OtherAccountRegistServlet2 extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        //もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if(session.getAttribute("Tidpw") == null ){
			response.sendRedirect(request.getContextPath() +"/TeacherLoginServlet");
			return;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if(session.getAttribute("teacherName") == null && session.getAttribute("teacherPw") == null){
			response.sendRedirect(request.getContextPath() +"/TeacherLoginServlet");
			return;
		}
		
	}
}
