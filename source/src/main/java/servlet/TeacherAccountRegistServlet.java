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

import dao.PidpwDAO;
import dao.SidpwDAO;
import dao.TidpwDAO;
import dto.Allaccess;
import dto.Pidpw;
import dto.Sidpw;
import dto.Tidpw;



//TidpwDAO.javaをインポートしよう
//Tidpw.java(dto)をインポートしよう。


//このサーブレットは先生のアカウント登録専用のサーブレット!!
//先生の登録情報をDAOに送信する機能
@WebServlet("/TeacherAccountRegistServlet")
public class TeacherAccountRegistServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession(false); // 既存セッションのみ取得
		if (session == null || session.getAttribute("Tidpw") == null) {
		    response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
		    return;
		}
		//sessionからログインしているユーザーのクラスネームを取得
		Tidpw loginUser =(Tidpw)session.getAttribute("Tidpw");
		int className = loginUser.getClassName();		
		System.out.println(className+"：クラスネーム");
		
		//クラスネームを元に生徒の情報を取得（ＡｒｒａｙＬｉｓｔに格納）
		SidpwDAO sdao = new SidpwDAO();
		ArrayList<Sidpw> list = sdao.select(className);
		System.out.println(list.size()+":リストのサイズ");
		
		//上で取得した生徒の情報をＡｌｌaccessを入れるArrayListに格納しなおす
		ArrayList<Allaccess> allList = new ArrayList<>();
		for(Sidpw s : list) {
			Allaccess all = new Allaccess();
			all.setsName(s.getsName());
			all.setNumber(s.getNumber());
			all.setsPw(s.getsPw());
			allList.add(all);
		}
		System.out.println(allList+":allList.size()");
		
		//上記で使用したallaccessに現在生徒の情報が入っているので、
		//それにプラスして、保護者の情報も追加して入れる
		PidpwDAO pdao = new PidpwDAO();		
		for(int i = 0; i<allList.size(); i++) {
			Pidpw pi = pdao.slectAddParent(allList.get(i).getNumber());
			allList.get(i).setpName(pi.getpName());
			allList.get(i).setpPw(pi.getpPw());			
		}
		
		//セットしてJSPが見れるようにする
		request.setAttribute("Allaccess", allList);
		
		

        //ページのフォワード(jspからjspに移るときがフォワード)をしよう。リンク先の変更を忘れないように！フォワード先はteacher_login.jsp！！

    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_account.jsp");
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
    	
    	
        //リクエスト領域からクラス名、氏名、パスワードを取得！！
        //入力値が一時的に保存される部分はどこ？構文おぼえているかな？
    	request.setCharacterEncoding("UTF-8");
    	int className = Integer.parseInt(request.getParameter("className"));
    	String teacherName = request.getParameter("teacherName");
    	String teacherPw = request.getParameter("teacherPw");
    	

        //TidpwDAO.javaをインスタンス化しよう。
    	TidpwDAO tidpwdao = new TidpwDAO();

        //if文で登録が成功した場合と失敗した場合に分けよう。
        //if文の条件はTidpwDAOのinsertメソッドを呼び出す構文を書く。
        //if文の中身はページのフォワード！
        // 成功したらフォワード先はteacher_login.jsp
        //失敗したらフォワード先はteacher_account.jsp
    	
    	if (tidpwdao.insert(new Tidpw(className, teacherName, teacherPw))) { // 登録成功
    		request.setAttribute("msg", "登録成功しました。");
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_login.jsp");
        	dispatcher.forward(request, response);
		} else { // 登録失敗
			request.setAttribute("errormsg", "登録失敗しました。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_account.jsp");
	    	dispatcher.forward(request, response);
		}
    	

    }
}