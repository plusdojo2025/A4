package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TidpwDAO;
import dto.Tidpw;



//TidpwDAO.javaをインポートしよう
//Tidpw.java(dto)をインポートしよう。


//このサーブレットは先生のアカウント登録専用のサーブレット!!
//先生の登録情報をDAOに送信する機能
@WebServlet("/TeacherAccountRegistServlet")
public class TeacherAccountRegistServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        

        //ページのフォワード(jspからjspに移るときがフォワード)をしよう。リンク先の変更を忘れないように！フォワード先はteacher_login.jsp！！
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_login.jsp");
    	dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //もしもログインしていなかったらログインサーブレットにリダイレクトする。doGet()の部分の上記の文のところをコピペ！
    	
    	
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