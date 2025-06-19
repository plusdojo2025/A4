package servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SidpwDAO;
import dao.TestsDAO;
import dto.Allaccess;
import dto.Sidpw;
import dto.Tests;

public class TeacherGradeServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // もしもログインしていなかったらログインサーブレットにリダイレクトする
        HttpSession session = request.getSession();
        if (session.getAttribute("tName") == null) {
            response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
            return;
        }
        //インスタンス化
        SidpwDAO studentInfo = new SidpwDAO();
        TestsDAO testsinfo = new TestsDAO();
        ArrayList<Sidpw> studentList = new ArrayList<Sidpw>();
        ArrayList<Tests> testsList = new ArrayList<Tests>();
        Sidpw tDto = new Sidpw();
        Tests testsDto = new Tests();
        //生徒情報をDAOを経由してデータベースから取得
        int className = tDto.getClassName();
        //クラス内の生徒の情報が欲しいので、引数はなし。DAOの方で生徒の情報をDTOにまとめてArrayList<Sidpw>で戻り値として返す。
        studentList = (ArrayList<Sidpw>)studentInfo.select(className);
        //テスト情報をDAOを経由してデータベースから取得
        int Tid = testsDto.getTestsId();
        testsList = (ArrayList<Tests>)testsinfo.select(Tid);
        //そのデータをrequest領域に保存する。
        request.setAttribute("studentList",studentList);
        request.setAttribute("selectedStudent;",studentList);
        request.setAttribute("score",testsList);
        // 成績登録・閲覧・更新・削除ページにフォワードする
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_score.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // もしもログインしていなかったらログインサーブレットにリダイレクトする
        HttpSession session = request.getSession();
        if (session.getAttribute("tName") == null) {
            response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
            return;
        }
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        int jap = Integer.parseInt(request.getParameter("jap"));
        int mat = Integer.parseInt(request.getParameter("mat"));
        int sci = Integer.parseInt(request.getParameter("sci"));
        int soc = Integer.parseInt(request.getParameter("soc"));
        int eng = Integer.parseInt(request.getParameter("eng"));
        int sum = Integer.parseInt(request.getParameter("sum"));
        int ajap = Integer.parseInt(request.getParameter("ajap"));
        int amat = Integer.parseInt(request.getParameter("amat"));
        int asci = Integer.parseInt(request.getParameter("aaci"));
        int asoc = Integer.parseInt(request.getParameter("asoc"));
        int aeng = Integer.parseInt(request.getParameter("aeng"));
        int asum = Integer.parseInt(request.getParameter("asum"));
		
		// 更新を行う
		TestsDAO annDao = new TestsDAO();
		if (request.getParameter("update").equals("更新")) {
			annDao.update(new Allaccess(id,jap,mat,sci,soc,eng,sum,ajap,amat,asci,asoc,aeng,asum));
		} else {
			annDao.delete(new Allaccess(id,jap,mat,sci,soc,eng,sum,ajap,amat,asci,asoc,aeng,asum));
		}
		
	    
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Pjsp/teacher_today_attend.jsp");
		dispatcher.forward(request, response);
			
	}
}
