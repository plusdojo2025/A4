package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TidpwDAO;
import dto.Tidpw;

@WebServlet("/TeacherLoginServlet")
public class TeacherLoginServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException {
		//ログインページにフォワードする
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/teacher_login.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String className = request.getParameter("className"); 
		String teacherName = request.getParameter("tName"); //入力しなかったら""（空文字）がはいる
		String teacherPw = request.getParameter("tPw"); //nullがはいるときは間違っているとき
		
		// ログイン処理を行う
		TidpwDAO tDao = new TidpwDAO();
				
		
				
		if (tDao.isLoginOK(new Tidpw(className,teacherName,teacherPw))){ // ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("Tidpw", new Tidpw(className,teacherName,teacherPw));

			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/A4/MenuServlet");
		} else { // ログイン失敗

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/TeacherLoginServlet");
			dispatcher.forward(request, response);
		}
	}
}
