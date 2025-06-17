package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AttendanceDAO;
import dto.Attendance;

@WebServlet("/A4/OtherAttendanceServlet")
public class OtherAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if(session.getAttribute("position") == null && session.getAttribute("studentName") == null ||
			session.getAttribute("position") == null && session.getAttribute("patrentName") == null) {
			response.sendRedirect("A4/OtherLoginServlet");
			return;
		}
		Attendance studentInfo = new Attendance();
		//出席情報の取得（編集するかも）
		String attendanceStatus = studentInfo.getStatus();
		//リクエスト領域に保存
		request.setAttribute("status", attendanceStatus);
		
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/A4/Pjsp/other_login.jsp");
		dispatcher.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String position = request.getParameter("position");
		String studentName = request.getParameter("studentName"); // 生徒名取得
        AttendanceDAO attendDao = new AttendanceDAO();
        
        String attendantId = request.getParameter("attendantId");
        String number = request.getParameter("number");
        String status = request.getParameter("status");
        String attendanceDate = request.getParameter("attendanceDate");
        
		//出席登録・欠席登録
		if(position.equals("student")) {
			if(attendDao.update(new Attendance(attendantId,number,status,attendanceDate))) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_home.jsp");
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_score.jsp");
				dispatcher.forward(request, response);
			}
			
		}else if(position.equals("parent")) {
			if(attendDao.update(new Attendance(attendantId,number,status,attendanceDate))) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/parent_home.jsp");
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/parent_score.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		
		if (!status.isEmpty()) {
	        AttendanceDAO.saveAttendance(studentName, today.toString(), status);
	        //登録後はどこに移動？
	        if ("student".equals(position)) {
	        	response.sendRedirect("student_today_attend.jsp");
	        } else if ("parent".equals(position)) {
	        	response.sendRedirect("parent_today_attend.jsp"); 
	        }
		}

	}
}
