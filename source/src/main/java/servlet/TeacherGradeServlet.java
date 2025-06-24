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

import dao.SidpwDAO;
import dao.TestsDAO;
import dto.Allaccess;
import dto.Sidpw;
import dto.Tests;
import dto.Tidpw;

@WebServlet("/TeacherGradeServlet")
public class TeacherGradeServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession(false); // 既存セッションのみ取得
		if (session == null || session.getAttribute("Tidpw") == null) {
		    response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
		    return;
		}
        //インスタンス化
        SidpwDAO studentInfo = new SidpwDAO();
        TestsDAO testsinfo = new TestsDAO();
        Tidpw loginUser = (Tidpw) session.getAttribute("Tidpw");
        ArrayList<Sidpw> studentList = new ArrayList<Sidpw>();
        ArrayList<Tests> testsList = new ArrayList<Tests>();
        Sidpw tDto = new Sidpw();
        Tests testsDto = new Tests();
        //生徒情報をDAOを経由してデータベースから取得
        int className = loginUser.getClassName();
        //クラス内の生徒の情報が欲しいので、引数はなし。DAOの方で生徒の情報をDTOにまとめてArrayList<Sidpw>で戻り値として返す。
        studentList = (ArrayList<Sidpw>)studentInfo.select(className);
        //テスト情報をDAOを経由してデータベースから取得
        int Tid = testsDto.getTestsId();
        testsList = (ArrayList<Tests>)testsinfo.select(Tid);
        //そのデータをrequest領域に保存する。
        request.setAttribute("studentList",studentList);
        request.setAttribute("selectedStudent",null);
        request.setAttribute("score",testsList);
        // 成績登録・閲覧・更新・削除ページにフォワードする
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_score.jsp");
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
        int japanes = Integer.parseInt(request.getParameter("jap"));
        int math = Integer.parseInt(request.getParameter("mat"));
        int science = Integer.parseInt(request.getParameter("sci"));
        int social = Integer.parseInt(request.getParameter("soc"));
        int english = Integer.parseInt(request.getParameter("eng"));
        int sum = Integer.parseInt(request.getParameter("sum"));
        int averageJapanese = Integer.parseInt(request.getParameter("ajap"));
        int averageMath = Integer.parseInt(request.getParameter("amat"));
        int averageScience = Integer.parseInt(request.getParameter("asci"));
        int averageSocial = Integer.parseInt(request.getParameter("asoc"));
        int averageEnglish = Integer.parseInt(request.getParameter("aeng"));
        int averageSum = Integer.parseInt(request.getParameter("asum"));
		
		// 更新を行う
		TestsDAO annDao = new TestsDAO();
		if (request.getParameter("update").equals("更新")) {
			annDao.update(new Allaccess(testsId,japanes,math,science,social,
					english,sum,averageJapanese,averageMath,averageScience,
					averageSocial,averageEnglish,averageSum));
		} else if(request.getParameter("delete").equals("削除")){
			annDao.delete(new Allaccess(testsId,japanes,math,science,social,
					english,sum,averageJapanese,averageMath,averageScience,
					averageSocial,averageEnglish,averageSum));
		}
		
	    
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_score.jsp");
		dispatcher.forward(request, response);
			
	}
}
