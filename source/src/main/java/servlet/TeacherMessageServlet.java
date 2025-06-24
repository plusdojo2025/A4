package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnnouncementsDAO;
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
		
		int className = ((Tidpw) session.getAttribute("Tidpw")).getClassName();

		
		//DAOの情報の格納、AnnouncementsDAO.javaにメソッド追加の必要あり
		announceList = (ArrayList<Announcemnts>) announceDao.selectByClass(className);
		
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
		//その日の日付を取得
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formattedDate = today.format(formatter);
		request.setAttribute("today", formattedDate);
		
		// 更新を行う
		AnnouncementsDAO annDao = new AnnouncementsDAO();
		if(annDao.insert(classname, enter, formattedDate)) {
			response.sendRedirect(request.getContextPath() + "/TeacherMessageServlet");
		}
		else {
			request.setAttribute("updateErr","レコードを更新できませんでした。");
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_announce.jsp");
			dispatcher.forward(request, response);
		}
	
	}
}
