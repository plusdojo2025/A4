package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PidpwDAO;
import dao.SidpwDAO;
import dto.Pidpw;
import dto.Sidpw;

@WebServlet("/OtherLoginServlet")
public class OtherLoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/other_login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String position = request.getParameter("position");
		String sName = "";
		String sPw = "";
		String pName = "";
		String pPw = "";
		if(position.equals("生徒")) {
			sName = request.getParameter("studentName");
			sPw = request.getParameter("studentPw");
		}
		else if(position.equals("保護者")) {
			pName = request.getParameter("parentName");
			pPw = request.getParameter("parentPw");
		}

		// ログイン処理を行う
		if(position.equals("生徒")) {
			SidpwDAO sDao = new SidpwDAO();
			sName = request.getParameter("otherName");
			sPw = request.getParameter("otherPw");
			
			if (sDao.isLoginOK(new Sidpw(sName, sPw))!=null) { // ログイン成功
				//学籍番号を取得する。
				int studentId = sDao.studentSelectId(new Sidpw(sName, sPw));
				// セッションスコープにIDを格納する
				HttpSession session = request.getSession();
				session.setAttribute("Sidpw", new Sidpw(sName,studentId,sPw));
				session.setAttribute("position", position);
				// メニューサーブレットにリダイレクトする
				response.sendRedirect(request.getContextPath() + "/A4/OtherMenuServlet");
			}
			else { // ログイン失敗
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/other_login.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if(position.equals("保護者")) {
			PidpwDAO pDao = new PidpwDAO();
			pName = request.getParameter("otherName");
			pPw = request.getParameter("otherPw");
			
			if (pDao.isLoginOK(new Pidpw(pName, pPw))) { // ログイン成功
				// セッションスコープにIDを格納する
				HttpSession session = request.getSession();
				session.setAttribute("Pidpw", new Pidpw(pName,pPw));
				session.setAttribute("position", position);
				// メニューサーブレットにリダイレクトする
				response.sendRedirect(request.getContextPath() + "/A4/OtherMenuServlet");
			}
			else { // ログイン失敗
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/other_login.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
