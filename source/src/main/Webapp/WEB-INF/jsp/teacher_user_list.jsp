<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>先生用ユーザー一覧</title>
	<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/teacher.css'/>">
</head>
<body>
	<header>
			<label class="out"><img src = "images/out.png" width="50px" height="50px"></label>
			<div class="logo">
				<a href="/webapp/LoginServlet"><img src = "images/cshare.png" width="300px" height="122px"></a>
			</div>
			<nav class = "burner">
	            <ul>
	                <li><a href="/A4/AttendanceServlet" class="highlight">出欠管理</a></li>
	                <li><a href="/A4/GradeServlet" class="highlight">成績管理</a></li>
	                <li><a href="/A4/MessageServlet" class="highlight">連絡管理</a></li>
	                <li><a href="/A4/AccountRegistServlet">ユーザー一覧管理</a></li>
	                <li><a href="/A4/LoadHistoryServlet" class="highlight">チャット</a></li>
	            </ul>
	        </nav>
	</header>

	<label class="out"><a href="/A4/AccountRegistServlet">ユーザー登録</a></label>
	
	 <c:forEach var="e" items="${Allaccess}">
			<form class="access-edit-form" method="POST" action="/A4/UpdateDeleteServlet">
				<div class="access-wrapper">
					<div class="access-row">
						<!-- 生徒 -->
						<div class="access-column">
							<label>氏名</label>
							<input type="text" name="sName" value="${e.sName}">
	
							<label>学籍番号</label>
							<input type="text" name="sNumber" value="${e.sNumber}">
	
							<label>パスワード</label>
							<input type="text" name="sPw" value="${e.sPw}">
						</div>

						<!-- 保護者 -->
						<div class="access-column">
							<label>氏名</label>
							<input type="text" name="pName" value="${e.pName}">
	
							<label>学籍番号</label>
							<input type="text" name="pNumber" value="${e.pNumber}">
	
							<label>パスワード</label>
							<input type="text" name="pPw" value="${e.pPw}">
						</div>
					</div>

						<!-- ボタン -->
					<div class="access-buttons">
						<input type="submit" name="submit" value="更新">
						<input type="submit" name="submit" value="削除">
					</div>
				</div>	
			</form>
		</c:forEach>
	<footer class="footer">
		<img src = "images/runningman.png">
	</footer>
</body>
</html>