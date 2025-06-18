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
import dao.TidpwDAO;
import dto.Tidpw;

@WebServlet("/A4/OtherMessageServlet")

public class TeacherMessageServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("teacherName") == null && session.getAttribute("teacherPw") == null ) {
			response.sendRedirect("/A4/TeacherLoginServlet");
			return;
		}
		//インスタンス化
		AnnouncementsDAO announceDao = new AnnouncementsDAO();
		ArrayList<announcements> announceList = new ArrayList<announcements>();
		TidpwDAO tDao = new TidpwDAO();
		Tidpw tDto = new Tidpw();
		//先生情報の取得
		tDto = (Tidpw)session.getAttribute("Tidpw");
		//クラス名の取得
		String className = tDto.getClassName();
		//DAOの情報の格納、AnnouncementsDAO.javaにメソッド追加の必要あり
		announceList = announceDao.select(className);
		//リクエストスコープへの保存
		request.setAttribute("announcements", announceList);

		// お知らせページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/jsp/teacher_announce.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("teacherName") == null && session.getAttribute("teacherPw") == null ) {
			response.sendRedirect("/A4/TeacherLoginServlet");
			return;
		}
		
		//入力情報の取得
		String announce = request.getParameter("enter");
		AnnouncementsDAO aDao = new AnnouncementsDAO();
		//その日の日付を取得
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formattedDate = today.format(formatter);
		//先生情報の取得
		Tidpw tDto = new Tidpw();
		tDto = (Tidpw)session.getAttribute("Tidpw");
		//クラス名の取得
		String className = tDto.getClassName();
		//AnnouncementsDAO.javaにメソッド追加の必要あり
		if(aDao.insert(className,announce,formattedDate)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/jsp/teacher_announce.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/jsp/teacher_announce.jsp");
			dispatcher.forward(request, response);
		}
	}
}
