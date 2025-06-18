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

@WebServlet("/A4/OtherLoginServlet")

public class OtherLoginServlet extends HttpServlet {
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
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Pjsp/other_login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String position = request.getParameter("position");
		if(position.equals("生徒")) {
			String sName = request.getParameter("studentName");
			String sPw = request.getParameter("studentPw");
		}
		else if(position.equals("保護者")) {
			String pName = request.getParameter("parentName");
			String pPw = request.getParameter("parentPw");
		}

		// ログイン処理を行う
		if(position.equals("生徒")) {
			SidpwDAO sDao = new SidpwDAO();
			String sName = request.getParameter("studentName");
			String sPw = request.getParameter("studentPw");
			
			if (sDao.isLoginOK(new Sidpw(sName, sPw))) { // ログイン成功
				//学籍番号を取得する。
				String studentId = sDao.studentSelectId(new Sidpw(sName, sPw));
				// セッションスコープにIDを格納する
				HttpSession session = request.getSession();
				session.setAttribute("Sidpw", new Sidpw(sName,studentId,sPw));
				session.setAttribute("position", position);
				// メニューサーブレットにリダイレクトする
				response.sendRedirect("/A4/OtherMenuServlet");
			}
			else { // ログイン失敗
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/OtherLoginServlet");
				dispatcher.forward(request, response);
			}
		}
		else if(position.equals("保護者")) {
			PidpwDAO pDao = new PidpwDAO();
			String pName = request.getParameter("parentName");
			String pPw = request.getParameter("parentPw");
			
			if (pDao.isLoginOK(new Pidpw(pName, pPw))) { // ログイン成功
				// セッションスコープにIDを格納する
				HttpSession session = request.getSession();
				session.setAttribute("Pidpw", new PidpW(pName,pPw));
				session.setAttribute("position", position);
				// メニューサーブレットにリダイレクトする
				response.sendRedirect("/A4/OtherMenuServlet");
			}
			else { // ログイン失敗
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/OtherLoginServlet");
				dispatcher.forward(request, response);
			}
		}
	}
}
