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
import dto.Allaccess;
import dto.Pidpw;
import dto.Sidpw;
import dto.Tidpw;

@WebServlet("/OtherAccountRegistServlet")
public class OtherAccountRegistServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        //もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if(session.getAttribute("Tidpw") == null ){
			response.sendRedirect(request.getContextPath() +"/TeacherLoginServlet");
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_user_list.jsp");
		dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if(session.getAttribute("teacherName") == null && session.getAttribute("teacherPw") == null){
			response.sendRedirect(request.getContextPath() +"/TeacherLoginServlet");
			return;
		}
		Tidpw tDto = new Tidpw();
		tDto = (Tidpw)session.getAttribute("Tidpw");
		//クラス名の取得
		int editCName = tDto.getClassName();
        //リクエスト領域からアカウント編集画面のデータを取得
		request.setCharacterEncoding("UTF-8");
		String editSName = request.getParameter("editStudentName");
        int editSNum = Integer.parseInt(request.getParameter("editStudentNumber"));
        String editSPw = request.getParameter("editStudentPw");
        String editPName = request.getParameter("editParentName");
        String editPPw = request.getParameter("editParentPw");
        //リクエスト領域からアカウント登録画面のデータを取得
        String registSName = request.getParameter("registStudentName");
		int registCName = Integer.parseInt(request.getParameter("registClassName"));
        int registSNum = Integer.parseInt(request.getParameter("registStudentNumber"));
        String registSPw = request.getParameter("registStudentPw");
		String registPName = request.getParameter("registParentName");
        String registPPw = request.getParameter("registParentPw");
        

        //以下で必要なDAOやDTO, ArrayListをインスタンス化
        SidpwDAO sDao = new SidpwDAO();
        PidpwDAO pDao = new PidpwDAO();

        //name属性の"submit"で登録・更新・削除をif文で分けて処理を行う。
        if(request.getParameter("submit").equals("更新")) {
            if (sDao.update(new Sidpw(editCName,editSName,editSNum,editSPw)) && pDao.update(new Pidpw(editPName,editSNum,editPPw))) { // 更新成功
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_user_list.jsp");
				dispatcher.forward(request, response);
			} else { // 更新失敗
				request.setAttribute("updateErr","レコードを更新できませんでした。");
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_user_regist.jsp");
				dispatcher.forward(request, response);
			}
        }
        else if(request.getParameter("submit").equals("削除")) {
            if (sDao.delete(new Sidpw(editCName,editSName,editSNum,editSPw)) && pDao.delete(new Pidpw(editPName,editSNum,editPPw))) { // 削除成功
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_user_list.jsp");
				dispatcher.forward(request, response);
			} else { // 削除失敗
				request.setAttribute("deleteErr","レコードを削除できませんでした。");
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_user_regist.jsp");
				dispatcher.forward(request, response);
			}
        }
        else if(request.getParameter("submit").equals("登録")) {
            if (sDao.insert(new Sidpw(registCName,registSName,registSNum,registSPw)) && pDao.insert(new Pidpw(registPName,registSNum,registPPw))) { // 登録成功
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_user_list.jsp");
				dispatcher.forward(request, response);
			} else { // 登録失敗
				request.setAttribute("updateErr","レコードを登録できませんでした。");
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_user_regist.jsp");
				dispatcher.forward(request, response);
			}
        }


    }
}