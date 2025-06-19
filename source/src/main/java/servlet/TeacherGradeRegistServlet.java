package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TeacherGradeRegistServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // もしもログインしていなかったらログインサーブレットにリダイレクトする
        HttpSession session = request.getSession();
        if (session.getAttribute("tName") == null) {
            response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
            return;  
        }
	}   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // もしもログインしていなかったらログインサーブレットにリダイレクトする
        HttpSession session = request.getSession();
        if (session.getAttribute("tName") == null) {
            response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
            return;
        }
    }    
}
