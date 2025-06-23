<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生専用連絡通知</title>
<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
<link rel="stylesheet" href="<c:url value='/css/teacher.css'/>">
</head>
<body>
	<header>
		<label class="out"><img src = "<c:url value='/TeacherAccountRegistServlet'/>">width="50px" height="50px"></label>
		<div class="logo">
			<a href="<c:url value='/LoginServlet'/>"><img src = "<c:url value='/images/cshare.png'/>" >width="300px" height="122px"></a>
		</div>
		<nav class = "burner">
			<ul>
				<li><a href="<c:url value='/AttendanceServlet'/>" class="highlight">出欠管理</a></li>
				<li><a href="<c:url value='/GradeServlet'/>" class="highlight">成績管理</a></li>
				<li><a href="<c:url value='/MessageServlet'/>" class="highlight">連絡管理</a></li>
				<li><a href="<c:url value='/AccountRegistServlet'/>">ユーザー一覧管理</a></li>
				<li><a href="<c:url value='/LoadHistoryServlet'/>" class="highlight">チャット</a></li>
			</ul>
		</nav>
	</header>
	
	<h2>連絡一覧</h2>
	<!-- 登録日時を表示 -->	
	<c:forEach var="e" items="${announceList}">
		<table>
			<tr>
				<td>${e.date}</td>
			</tr>
			<!-- 連絡内容を表示 -->
			<tr>
	  			<td>${e.announcements}</td>
	 		</tr>
	 	</table>
	</c:forEach>
	<!-- 連絡事項の登録 -->
	<form method="POST" action="<c:url value='/TeacherMessageServlet'/>" id="form">
		<table>
			<tr>
				<td>
					<input type="hidden" name="classname" value="${e.classname}">   
		  			<input type="text" name="enter" value="入力してください" required>
	  			</td>
	  			<td>
	  				<input type="submit"name="sendMessage" value="送信">
	  			</td>
			</tr>
		</table>
	</form>
	
	<footer class="footer">
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>