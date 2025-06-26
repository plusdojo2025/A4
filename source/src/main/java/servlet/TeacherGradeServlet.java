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
import dto.Sidpw;
import dto.Tidpw;

@WebServlet("/TeacherGradeServlet")
public class TeacherGradeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession(false); // 既存セッションのみ取得
		if (session.getAttribute("Tidpw") == null) {
			response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
			return;
		}
		// インスタンス化
		SidpwDAO studentInfo = new SidpwDAO();
		Tidpw loginUser = (Tidpw) session.getAttribute("Tidpw");
		ArrayList<Sidpw> studentList = new ArrayList<Sidpw>();
		String number = request.getParameter("number");

		// 生徒情報をDAOを経由してデータベースから取得
		int className = loginUser.getClassName();

		// クラス内の生徒の情報が欲しいので、引数はなし。DAOの方で生徒の情報をDTOにまとめてArrayList<Sidpw>で戻り値として返す。
		studentList = (ArrayList<Sidpw>) studentInfo.select(className);

		// そのデータをrequest領域に保存する。
		request.setAttribute("number", number);
		session.setAttribute("studentList", studentList);

		// 成績登録・閲覧・更新・削除ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_score.jsp");
		dispatcher.forward(request, response);
	}

}
