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

import dao.AnnouncementsDAO;
import dto.Announcemnts;
import dto.Tidpw;

@WebServlet("/TeacherMenuServlet")
public class TeacherMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		Tidpw loginUser = (Tidpw) (session != null ? session.getAttribute("Tidpw") : null);
		if (loginUser == null) {
            // ログインしていない場合はログインページにリダイレクト
            response.sendRedirect("/A4/TeacherLoginServlet");
            return;
        }

		 
		//先生のホーム画面に最新の連絡登録情報を表示する
		AnnouncementsDAO announceDao = new AnnouncementsDAO();
		ArrayList<Announcemnts> announcelatest = new ArrayList<Announcemnts>();
		Announcemnts annDto = new Announcemnts();
		String announce = annDto.getAnnounce();
		announcelatest = (ArrayList<Announcemnts>) announceDao.select(announce);
		
		//リクエストスコープへの保存
		request.setAttribute("announcement", announcelatest);
		
		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/teacher_home.jsp");
		dispatcher.forward(request, response);
		
	}

}
