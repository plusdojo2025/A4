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

import dao.TestsDAO;
import dto.Allaccess;
import dto.Tests;

@WebServlet("/TeacherScoreDisplayServlet")
public class TeacherScoreDisplayServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession(false); // 既存セッションのみ取得
		if (session == null || session.getAttribute("Tidpw") == null) {
			response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
			return;
		}
		
		int number = Integer.parseInt(request.getParameter("number"));
		String sName = request.getParameter("sName");
		ArrayList<Tests> testsResult = new ArrayList<Tests>();
		TestsDAO tesDao = new TestsDAO();
		testsResult = tesDao.select1(number);
		request.setAttribute("testsResult",testsResult);
		request.setAttribute("sName",sName);
		
		 // 成績閲覧・更新・削除ページにフォワードする
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_score_display.jsp");
        dispatcher.forward(request, response);
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
        int testsId = Integer.parseInt(request.getParameter("id"));
        int japanes = Integer.parseInt(request.getParameter("japanese"));
        int math = Integer.parseInt(request.getParameter("math"));
        int science = Integer.parseInt(request.getParameter("science"));
        int social = Integer.parseInt(request.getParameter("social"));
        int english = Integer.parseInt(request.getParameter("english"));
        int sum = Integer.parseInt(request.getParameter("sum"));
        int averageJapanese = Integer.parseInt(request.getParameter("averageJapanese"));
        int averageMath = Integer.parseInt(request.getParameter("averageMath"));
        int averageScience = Integer.parseInt(request.getParameter("averageScience"));
        int averageSocial = Integer.parseInt(request.getParameter("averageSocial"));
        int averageEnglish = Integer.parseInt(request.getParameter("averageEnglish"));
        int averageSum = Integer.parseInt(request.getParameter("averageSum"));
		
		// 更新を行う
		TestsDAO annDao = new TestsDAO();
		if (request.getParameter("update").equals("更新")) {
			if(annDao.update(new Tests(testsId,japanes,math,science,social,
					english,sum,averageJapanese,averageMath,averageScience,
					averageSocial,averageEnglish,averageSum))) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_score.jsp");
				dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("updateErr","レコードを更新できませんでした。");
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_score.jsp");
				dispatcher.forward(request, response);
			}
		} 
		else {
			if(annDao.delete(new Allaccess(testsId,japanes,math,science,social,
					english,sum,averageJapanese,averageMath,averageScience,
					averageSocial,averageEnglish,averageSum))) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_score.jsp");
				dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("deleteErr","レコードを削除できませんでした。");
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_score.jsp");
				dispatcher.forward(request, response);
			}
		}
			
	}
	
}
