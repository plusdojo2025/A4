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

import dao.AnnouncementsDAO;
import dto.Allaccess;
import dto.Announcemnts;
import dto.Tidpw;

@WebServlet("/TeacherMessageServlet")
public class TeacherMessageServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession(false); // 既存セッションのみ取得
		if (session == null || session.getAttribute("Tidpw") == null) {
		    response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
		    return;
		}
		//インスタンス化
		AnnouncementsDAO announceDao = new AnnouncementsDAO();
		ArrayList<Announcemnts> announceList = new ArrayList<Announcemnts>();
		
		Tidpw tDto = new Tidpw();
		
		//先生情報の取得
		tDto = (Tidpw)session.getAttribute("Tidpw");
		//クラス名の取得
		int className = tDto.getClassName();
		
		//DAOの情報の格納、AnnouncementsDAO.javaにメソッド追加の必要あり
		announceList = (ArrayList<Announcemnts>) announceDao.select(className);
		
		//リクエストスコープへの保存
		request.setAttribute("announceList", announceList);
		

		// お知らせページにフォワードする
		request.getRequestDispatcher("/WEB-INF/jsp/teacher_announce.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession(false); // 既存セッションのみ取得
		if (session == null || session.getAttribute("Tidpw") == null) {
		    response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
		    return;
		}
		
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int classname = Integer.parseInt(request.getParameter("classname"));
		String enter = request.getParameter("enter");
		
		
		// 更新を行う
		AnnouncementsDAO annDao = new AnnouncementsDAO();
		request.getParameter("submit").equals("更新");
		annDao.insert(new Allaccess(classname, enter));
		
	    
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_today_attend.jsp");
		dispatcher.forward(request, response);
			
	}
}
