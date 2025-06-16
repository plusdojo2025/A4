package servlet;
import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PidpwDAO;
import dao.SidpwDAO;
import dto.Allaccess;

@WebServlet("/A4/OtherLoginServlet")

public class OtherLoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Pjsp/other_login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String position = request.getParameter("position");
		if(position.equals("student")) {
			String sName = request.getParameter("studentName");
			String sPw = request.getParameter("studentPw");
		}else if(position.equals("parent")) {
			String pName = request.getParameter("parentName");
			String pPw = request.getParameter("parentPw");
		}

		// ログイン処理を行う
		if(position.equals("student")) {
			SidpwDAO sDao = new SidpwDAO();
			//ここから
			String ans=sDao.isLoginOK(new Sidpw));
			if (ans != null) { // ログイン成功
				// セッションスコープにIDを格納する
				HttpSession session = request.getSession();
				session.setAttribute("Sidpw", new SidpW);
				// メニューサーブレットにリダイレクトする
				response.sendRedirect("/A4/OtherMenuServlet");
			} else { // ログイン失敗
				// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
				request.setAttribute("result", new Result("ログイン失敗！", "氏名またはPWに間違いがあります。", "/A4/OtherLoginServlet"));
			}
		}else if(position.equals("parent")) {
			PidpwDAO pDao = new PidpwDAO();
			Allaccess pip=new Allaccess(pName,pPw);
			String ans=pDao.isLoginOK(ip);
			if (ans != null) { // ログイン成功
				// セッションスコープにIDを格納する
				HttpSession session = request.getSession();
				LoginUser u = new LoginUser();
				u.setId(id);
				u.setUser(ans);
				session.setAttribute("id", u);
				// メニューサーブレットにリダイレクトする
				response.sendRedirect("/A4/OtherMenuServlet");
			} else { // ログイン失敗
				// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
				request.setAttribute("result", new Result("ログイン失敗！", "氏名またはPWに間違いがあります。", "/A4/OtherLoginServlet"));
			}
		}
	}
}
