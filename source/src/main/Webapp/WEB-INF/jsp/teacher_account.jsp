<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生アカウント登録</title>
</head>
<body>
	<header>
		<!-- ページタイトル -->
		<h1>C-Share</h1>
		<label><a href="/A4/TeacherLoginServlet">ログイン画面に戻る</a></label>
		${errormsg}
	</header>
	<form method="POST" action="">
		<!-- クラス名入力 -->
		<label>クラス名</label>
		<input type="text" name="className">
		<!-- 氏名入力 -->
		<label>氏名</label>
		<input type="text" name="teacherName">
		<!-- パスワード入力 -->
		<label>パスワード</label>
		<input type="password" name="teacherPw">
		
		<!-- 登録ボタン -->
		<input type="submit" name="regist" value="登録">
		<span id="error_message"></span>
	</form>
</body>
</html>