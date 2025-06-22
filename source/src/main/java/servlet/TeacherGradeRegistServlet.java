package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SidpwDAO;
import dao.TestsDAO;
import dto.Allaccess;
import dto.Tests;

@WebServlet("/TeacherGradeRegistServlet")
public class TeacherGradeRegistServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // もしもログインしていなかったらログインサーブレットにリダイレクトする
        HttpSession session = request.getSession();
        if (session.getAttribute("tName") == null) {
            response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
            return;  
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Sjsp/teacher_score.jsp");
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
        
        // リクエストパラメータを取得する
        request.setCharacterEncoding("UTF-8");
        String test = request.getParameter("testName");
     	int term = Integer.parseInt(request.getParameter("term"));
     	TestsDAO t = new TestsDAO();
     	
     	String submit = request.getParameter("submit");
     	if(submit.equals("検索")) {
     		// 検索処理を行う
         	ArrayList<Allaccess> list = new ArrayList<Allaccess>();
         	//DAOで結合を使って生徒名とテスト結果を取得
         	list = t.select(term, test);
         	// 検索結果をリクエストスコープに格納する
         	request.setAttribute("scoreList", list);
         	
         	RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Sjsp/teacher_score.jsp");
    		dispatcher.forward(request, response);
     	}
     	else if(submit.equals("登録")) {
     		
     		//それぞれの情報をリクエスト領域から取得
     		request.setCharacterEncoding("UTF-8");
     		String[] studentName = request.getParameterValues("studentName");
     		String[] japanese = request.getParameterValues("japanese");
     		String[] math = request.getParameterValues("math");
     		String[] science = request.getParameterValues("science");
     		String[] social = request.getParameterValues("social");
     		String[] english = request.getParameterValues("english");
     		String[] sum = request.getParameterValues("sum");
     		
     		//生徒名から学籍番号を取得する。また、成績情報をDTOに格納後ArrayListに保存
     		SidpwDAO sIdInfo = new SidpwDAO();
     		int[] studentId = new int[studentName.length];
     		ArrayList<Tests> gradeList = new ArrayList<Tests>();
     		for(int i=0; i<studentName.length;i++) {
     			studentId[i] = sIdInfo.select(studentName[i]);
     			int intJapanese = Integer.parseInt(japanese[i]);
     			int intMath = Integer.parseInt(math[i]);
     			int intScience = Integer.parseInt(science[i]);
     			int intSocial = Integer.parseInt(social[i]);
     			int intEnglish = Integer.parseInt(english[i]);
     			int intSum = Integer.parseInt(sum[i]);
     			gradeList.add(new Tests(0,studentId[i],term,test,intJapanese,intMath,intScience,intSocial,intEnglish,intSum));
     		}
     		//DAOに渡す
     		if(t.insert(gradeList)) {
     			RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Sjsp/teacher_score.jsp");
     			dispatcher.forward(request, response);
     		}
     		else {
     			RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Sjsp/teacher_score_regist.jsp");
     			dispatcher.forward(request, response);
     		}
     	}
        
    }    
}
