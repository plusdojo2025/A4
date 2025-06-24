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
			<label class="out">
				<a href="<c:url value='TeacherLoginServlet'/>"><img src = "images/out.png" width="50px" height="50px"></a>
			</label>
			<div class="logo">
				<a href="<c:url value='/TeacherMenuServlet'/>"><img src = "<c:url value='/images/cshare.png'/>" width="300px" height="122px"></a>
			</div>
			<nav class = "burner">
	            <ul>
	                <li><a href="<c:url value='/TeacherAttendanceServlet'/>">出欠管理</a></li>
					<li><a href="<c:url value='/TeacherGradeServlet'/>" class="highlight">成績管理</a></li>
					<li><a href="<c:url value='/TeacherMessageServlet'/>" class="highlight">連絡管理</a></li>
					<li><a href="<c:url value='/TeacherAccountRegistServlet'/>" class="highlight">ユーザー一覧管理</a></li>
					<li><a href="<c:url value='/SoServlet'/>" class="highlight">チャット</a></li>
	            </ul>
	        </nav>

	</header>
	<form>
	  	<div class="attend">
	        <!--日付表示-->
	        <a href="teacher_month_attend.jsp">
	        <img src = "images/calender.png" width="70px" height="70px"></a>
	        <p>日付：${attendanceDate.attendanceDate}</p>
    	</div>
	</form>
	
	<div class="attend2">
		<table>
			<thead>
			<tr>
				<th>名前</th>
				<th>出欠</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="e" items="${cardList}">
				
					<form method="POST" action="/TeacherAttendanceServlet" class="form-flex">
					<table>
					<tr>
						<td class="name-label">${e.name}</td>
						<td>
							<div class="selectbox-5">
							<select name="attendance">
								<option value="Present" <c:if test="${e.attendance == 'Present'}">selected</c:if>>出席</option>
								<option value="Absent" <c:if test="${e.attendance == 'Absent'}">selected</c:if>>欠席</option>
								<option value="Late" <c:if test="${e.attendance == 'Late'}">selected</c:if>>遅刻</option>
								<option value="Early" <c:if test="${e.attendance == 'Early'}">selected</c:if>>早退</option>
							</select>
							</div>
						</td>
						<td>
							<input type="submit" value="更新" class="submit-btn">
						</td>
					</tr>
					</table>
					</form>
				



			</c:forEach>
			</tbody>
		</table>
	</div>
	<footer class="footer">
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>