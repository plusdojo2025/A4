<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>生徒・保護者用ログイン</title>
	<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/parent.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/student.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/student_parent_common.css'/>">
</head>
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<div class="logo">
			<a href="<c:url value='/OtherMenuServlet'/>"><img src = "<c:url value='/images/cshare.png'/>" width="300px" height="122px"></a>
		</div>
	</header>
	
	<div class="login-form-container">
	<form class="login-form" method="POST" action="<c:url value='/OtherLoginServlet'/>" id="form">
		
			<div class="login-form-container">
				
				<div class="selectbox-5"><!-- 生徒・保護者の氏名とパスワードの入力 -->
					<select name="position">
					<option value="student">生徒</option>
					<option value="parent">保護者</option>
					</select>
				</div>
				<div>
					<label for="name">氏名</label><br>
					<input type="text" name="otherName" required>
				</div>
				
				<div>
					<label for="pw">パスワード</label><br>
					<input type="password" name="otherPw" required>
				</div><br>
				<input type="submit" name="login" value="ログイン">
			</div>
		
	</form>
	</div>
	<footer class="footer">
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>