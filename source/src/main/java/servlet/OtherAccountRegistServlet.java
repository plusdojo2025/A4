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
import dto.Pidpw;
import dto.Sidpw;
import dto.Tidpw;

@WebServlet("/OtherAccountRegistServlet")
public class OtherAccountRegistServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        //もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if(session.getAttribute("teacherName") == null && session.getAttribute("teacherPw") == null){
			response.sendRedirect(request.getContextPath() +"/TeacherLoginServlet");
			return;
		}
        //先生が持っている共通の情報はクラス名。それをもとに先生の生徒の情報を取得する。
        Tidpw tDto = new Tidpw();
		tDto = (Tidpw)session.getAttribute("Tidpw");
		//クラス名の取得
		int className = tDto.getClassName();
        //生徒の情報を取得
        SidpwDAO sDao = new SidpwDAO();
        ArrayList<Sidpw> studentInfo = new ArrayList<Sidpw>();
        studentInfo = sDao.select(className);
        //生徒の情報から学籍番号だけをリストに格納
        ArrayList<Integer> studentIdInfo = new ArrayList<Integer>();
        for(Sidpw id : studentInfo) {
            studentIdInfo.add(id.getNumber());
        }
        //学籍番号をもとに保護者の情報を取得
        PidpwDAO pDao = new PidpwDAO();
        ArrayList<Pidpw> parentList = new ArrayList<Pidpw>();
        //PidpwDAO.javaにメソッドを追加必要あり。
        parentList = pDao.slect(studentIdInfo);

        //リクエスト領域に生徒・保護者の情報を格納
        request.setAttribute("studentInformation", studentInfo);
        request.setAttribute("parentInformation", parentList);
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