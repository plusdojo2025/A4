package servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnnouncementsDAO;
import dto.Announcemnts;
import dto.Sidpw;

@WebServlet("/OtherMessageServlet")
public class OtherMessageServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("position") == null && session.getAttribute("studentName") == null ||
			session.getAttribute("position") == null && session.getAttribute("parentName") == null) {
			response.sendRedirect(request.getContextPath() +"/A4/OtherLoginServlet");
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
			response.sendRedirect(request.getContextPath() +"/A4/OtherLoginServlet");
			return;
		}
		
		//インスタンス化
		AnnouncementsDAO announceDao = new AnnouncementsDAO();
		List<Announcemnts> announceList = new ArrayList<Announcemnts>();
		Sidpw sDto = new Sidpw();
		//生徒情報の取得
		sDto = (Sidpw)session.getAttribute("Sidpw");
		//クラス名の取得
		int className = sDto.getClassName();
		//DAOの情報の格納
		announceList = announceDao.select(className);
		//リクエストスコープへの保存
		request.setAttribute("announcements", announceList);

		String position = (String)session.getAttribute("position");
		// お知らせページにフォワードする
		if(position.equals("生徒")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Sjsp/student_annouunce.jsp");
			dispatcher.forward(request, response);
			}else if(position.equals("保護者")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/parent_annouunce.jsp");
			dispatcher.forward(request, response);
			}
		}
}
