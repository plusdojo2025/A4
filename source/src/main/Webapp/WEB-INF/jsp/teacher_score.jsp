<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生用成績閲覧・登録</title>
</head>
<body>
	<header>
		<ul>
			<li><a href="/A4/AttendanceServlet">出欠管理</a></li>
			<li><a href="/A4/GradeServlet">成績管理</a></li>
			<li><a href="/A4/MessageServlet">連絡管理</a></li>
			<li><a href="/A4/AccountRegistServlet">ユーザー一覧管理</a></li>
			<li><a href="/A4/LoadHistoryServlet">チャット</a></li>
		</ul>
	</header>
	<div>
		<!-- 成績登録ボタン -->
		<input type="submit" name="regist" value="成績登録">
	</div>
	<div>
		<!-- 生徒名簿の表示 -->
		<h2>生徒名簿</h2>
		<ul>
			<c:forEach var="studentName" items="${studentList}" >
				<li><a href="/A4/AccountRegist">${name}</a></li>
			</c:forEach>
		</ul>
	</div>
	<footer>
	
	</footer>
</body>
</html>