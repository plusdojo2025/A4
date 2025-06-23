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
		//int className = Integer.parseInt(request.getParameter("className")); 
		String teacherName = request.getParameter("teacherName"); //入力しなかったら""（空文字）がはいる
		String teacherPw = request.getParameter("teacherPw"); //nullがはいるときは間違っているとき
		
		// ログイン処理を行う
		TidpwDAO tDao = new TidpwDAO();		
		Tidpw loginUser = tDao.isLoginOK(new Tidpw(teacherName, teacherPw));
		if (loginUser != null) {
		    HttpSession session = request.getSession();
		    session.setAttribute("Tidpw", loginUser);

			// メニューサーブレットにリダイレクトする
			response.sendRedirect(request.getContextPath() + "/A4/TeacherMenuServlet");
		} else { // ログイン失敗

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
