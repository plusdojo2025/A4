<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒・保護者用ログイン</title>
</head>
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<h1>C-Share</h1>
	</header>
	
	<form method="POST" action="/A4">
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
	</footer>
</body>
</html>