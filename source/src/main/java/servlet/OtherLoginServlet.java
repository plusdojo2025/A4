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

		// ログイン処理を行う
		if(position.equals("student")) {
			SidpwDAO sDao = new SidpwDAO();
			sName = request.getParameter("otherName");
			sPw = request.getParameter("otherPw");
			Sidpw sloginUser = sDao.isLoginOK(new Sidpw(sName,sPw));
			
			if (sloginUser != null) { // ログイン成功
				//学籍番号を取得する。
		
				// セッションスコープにIDを格納する
				HttpSession session = request.getSession();
				session.setAttribute("Sidpw", sloginUser);
				session.setAttribute("position", position);
				
				// メニューサーブレットにリダイレクトする
				response.sendRedirect(request.getContextPath() + "/OtherMenuServlet");
			}
			else { // ログイン失敗
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/other_login.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if(position.equals("parent")) {
			PidpwDAO pDao = new PidpwDAO();
			pName = request.getParameter("otherName");
			pPw = request.getParameter("otherPw");
			Pidpw ploginUser = pDao.isLoginOK(new Pidpw(pName,pPw));
			
			if (ploginUser != null) { // ログイン成功
				// セッションスコープにIDを格納する
				HttpSession session = request.getSession();
				session.setAttribute("Pidpw", ploginUser);
				session.setAttribute("position", position);
				
				// メニューサーブレットにリダイレクトする
				response.sendRedirect(request.getContextPath() + "/OtherMenuServlet");
			}
			else { // ログイン失敗
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/other_login.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
