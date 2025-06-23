<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<a href="<c:url value='/OtherLoginServlet'/>"><img src = "<c:url value='/images/cshare.png'/>"> width="300px" height="122px"></a>
		</div>
	</header>
	
	<form method="POST" action="<c:url value='/OtherLoguinServlet'/>" id="form">
	<!--  -->
		<div>
			<!-- 生徒・保護者の氏名とパスワードの入力 -->
			<select name="position">
			<option value="student">生徒</option>
			<option value="parent">保護者</option>
			</select>
			氏名<input type="text" name="studentName" required>
			パスワード<input type="password" name="studentPw" required>
			<input type="submit" name="login" value="ログイン">
		</div>
	</form>
	<footer>
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>