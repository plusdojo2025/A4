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

@WebServlet("/OtherMenuServlet")
public class OtherMenuServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("position") == null && session.getAttribute("studentName") == null ||
			session.getAttribute("position") == null && session.getAttribute("parentName") == null) {
			response.sendRedirect(request.getContextPath() +"/A4/OtherLoginServlet");
			return;
		}
System.out.println(session.getAttribute("position"));
		//生徒・保護者のホーム画面に最新の連絡登録情報を表示する
		AnnouncementsDAO announceDao = new AnnouncementsDAO();
		ArrayList<Announcemnts> announcelatest = new ArrayList<Announcemnts>();
		Announcemnts annDto = new Announcemnts();
		String announce = annDto.getAnnounce();
		announcelatest = (ArrayList<Announcemnts>) announceDao.select(announce);
		
		//リクエストスコープへの保存
		request.setAttribute("announcement", announcelatest);
		
        // ホームページにフォワードする

        if(session.getAttribute("position").equals("生徒")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Sjsp/student_home.jsp");
		    dispatcher.forward(request, response);
        }
		else if(session.getAttribute("position").equals("保護者")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Pjsp/parent_home.jsp");
		    dispatcher.forward(request, response);
        }
    }

}