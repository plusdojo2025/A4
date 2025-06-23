<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>先生用出欠管理</title>
	<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
<link rel="stylesheet" href="<c:url value='/css/teacher.css'/>">
</head>
<body>
	<header>
			<label class="out"><img src = "<c:url value='/TeacherLoginServlet'/>">width="50px" height="50px"></label>
			<div class="logo">
				<a href="<c:url value='/TeacherMenuServlet'/>"><img src = "<c:url value='/images/cshare.png'/>" >width="300px" height="122px"></a>
			</div>
			<nav class = "burner">
	            <ul>
	                <li><a href="<c:url value='/TeacherAttendanceServlet'/>" class="highlight">出欠管理</a></li>
					<li><a href="<c:url value='/TeacherGradeServlet'/>" class="highlight">成績管理</a></li>
					<li><a href="<c:url value='/TeacherMessageServlet'/>" class="highlight">連絡管理</a></li>
					<li><a href="<c:url value='/TeacherAccountRegistServlet'/>">ユーザー一覧管理</a></li>
					<li><a href="<c:url value='/SoServlet'/>" class="highlight">チャット</a></li>
	            </ul>
	        </nav>
	</header>
	<form>
		
		
		<!-- servletからその日の日付を取得 -->
		String action = request.getParameter("action");
	    if ("移動".equals(action)) {
	    	String tDay= request.getAttribute("attendanceDate")
	    } else {
	    LocalDate today = LocalDate now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	    String tDay = today.format(formatter);
	    }
	   <h2> 日付： <%= tDay %></h2>
	</form>
	<div  class="attend">
	<!-- ボタンを押すとカレンダーの画面に遷移 -->
	<a href="teacher_month_attend.jsp"><img src = "images/calender.png" width="70px" height="70px"></a>
	
	<input type="text" name="attdate" value="<%= request.getAttribute("attendanceDate") %>" readonly>
	</div>
	
	<div class="attend2">
	<form method="POST" action="<c:url value='/TeacherAttendanceServlet' />">
		<c:forEach var="e" items="${cardList}">
			<!-- 生徒の出席状況 -->
		    <table>
			    <tr>
		        	<th>名前</th>
					<th>出欠</th>
					<th>操作</th>
				</tr>
				<tr>
			        <td>
			        	<div style="display:flex;">
			       			<input type="hidden" name="number" value="${e.number}">      	
		            		<div><input name = sName value = "${e.name}"></div>
			            		<div class="attend-row">
					                <select name="attup">
					                    <option value="Present" <c:if test="${studentAttendance.attendance == 'Present'}">selected</c:if>>出席</option>
					                    <option value="Absent" <c:if test="${studentAttendance.attendance == 'Absent'}">selected</c:if>>欠席</option>
					                    <option value="Late" <c:if test="${studentAttendance.attendance == 'Late'}">selected</c:if>>遅刻</option>
					                    <option value="Early" <c:if test="${studentAttendance.attendance == 'Early'}">selected</c:if>>早退</option>
					                </select>
					            </div> 
			            	<input type="submit" value="更新">
		            	</div>
	            	</td>
		        </tr>
		    </table>
		</c:forEach>
	</form>
	</div>	
	<footer class="footer">
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>