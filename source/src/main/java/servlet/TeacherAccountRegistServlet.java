package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//TidpwDAO.javaをインポートしよう
//Tidpw.java(dto)をインポートしよう。


//このサーブレットは先生のアカウント登録専用のサーブレット!!
//先生の登録情報をDAOに送信する機能
//@WebServlet(urlPatterns = "","/TeacherAccountRegistServlet");
public class TeacherAccountRegistServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // もしもログインしていなかったらログインサーブレットにリダイレクトする。(Other側のサーブレットでは、生徒・保護者の名前とポジションをif文の条件にしていたが、今回は先生の名前を条件にする)


        //ページのフォワードをしよう。リンク先の変更を忘れないように！フォワード先はteacher_login.jsp！！
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //もしもログインしていなかったらログインサーブレットにリダイレクトする。doGet()の部分の上記の文のところをコピペ！


        //リクエスト領域からクラス名、氏名、パスワードを取得！！
        //入力値が一時的に保存される部分はどこ？構文おぼえているかな？


        //TidpwDAO.javaをインスタンス化しよう。

        //if文で登録が成功した場合と失敗した場合に分けよう。
        //if文の条件はTidpwDAOのinsertメソッドを呼び出す構文を書く。
        //if文の中身はページのフォワード！
        // 成功したらフォワード先はteacher_login.jsp
        //失敗したらフォワード先はteacher_account.jsp

    }
}