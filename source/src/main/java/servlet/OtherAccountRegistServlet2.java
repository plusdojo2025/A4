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

@WebServlet("/OtherAccountRegistServlet2")
public class OtherAccountRegistServlet2 extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        //もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if(session.getAttribute("Tidpw") == null ){
			response.sendRedirect(request.getContextPath() +"/TeacherLoginServlet");
			return;
		}
		
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_user_regist.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if(session.getAttribute("Tidpw") == null ){
			response.sendRedirect(request.getContextPath() +"/TeacherLoginServlet");
			return;
		}
		
		//リクエスト領域からアカウント登録画面のデータを取得
		request.setCharacterEncoding("UTF-8");
        String registSName = request.getParameter("studentName");
		int registCName = Integer.parseInt(request.getParameter("className"));
        int registSNum = Integer.parseInt(request.getParameter("studentNumber"));
        String registSPw = request.getParameter("studentPw");
		String registPName = request.getParameter("parentName");
        String registPPw = request.getParameter("parentPw");
        
        
        //以下で必要なDAOやDTO, ArrayListをインスタンス化
        SidpwDAO sDao = new SidpwDAO();
        PidpwDAO pDao = new PidpwDAO();
        if(request.getParameter("submit").equals("登録")) {
	        if (sDao.insert(new Sidpw(registCName,registSName,registSNum,registSPw)) && pDao.insert(new Pidpw(registPName,registSNum,registPPw))) { // 登録成功
	        	request.setAttribute("errormsg","レコードを登録できませんでした。");
	        	// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_user_regist.jsp");
				dispatcher.forward(request, response);
			} else { // 登録失敗
				request.setAttribute("msg","レコードを登録しました。");
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_user_regist.jsp");
				dispatcher.forward(request, response);
			}
        }    
	}
}
