package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnnouncementsDAO;
import dao.SidpwDAO;
import dto.Announcemnts;
import dto.Pidpw;
import dto.Sidpw;

@WebServlet("/OtherMessageServlet")
public class OtherMessageServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if(session.getAttribute("Pidpw") == null || session.getAttribute("Sidpw") == null) {
			response.sendRedirect(request.getContextPath() +"/OtherLoginServlet");
			return;
		}
		
		String position = (String)session.getAttribute("position");
		int className=0;
		int studentId=0;
		AnnouncementsDAO dao = new AnnouncementsDAO();
		if(position.equals("student")) {
			 // 学生情報からクラス取得
	        Sidpw student = (Sidpw) session.getAttribute("Sidpw");
	        className = student.getClassName();
	        
	     // お知らせ取得
	        List<Announcemnts> announcements = dao.selectByClass(className);
	        request.setAttribute("announceList", announcements);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Sjsp/student_announce.jsp");
			dispatcher.forward(request, response);
		} else if(position.equals("parent")) {
			Pidpw parent = (Pidpw)session.getAttribute("Pidpw");
			studentId=parent.getNumber();
			SidpwDAO sDao = new SidpwDAO();
			className=sDao.studentClassName(studentId);
			
			// お知らせ取得
	        List<Announcemnts> announcements = dao.selectByClass(className);
	        request.setAttribute("announceList", announcements);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/parent_announce.jsp");
			dispatcher.forward(request, response);
		}

	}
	
	
}
