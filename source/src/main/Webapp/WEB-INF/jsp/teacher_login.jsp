<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生専用ログイン</title>
</head>
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<h1>C-Share</h1>
		<label><a href="/A4/TeacherAccountRegistServlet">アカウント登録</a></label>
		${msg}
	</header>
	
	<form method="POST" action="/A4/TeacherLoguinServlet">
	<!--  -->
		<div>
			<!-- 教師名とパスワードの入力 -->
			氏名<input type="text" name="teacherName" required>
			パスワード<input type="password" name="teacherPw" required>
			<input type="submit" name="login" value="ログイン">
		</div>
	</form>
	<footer>
	</footer>
</body>
</html>