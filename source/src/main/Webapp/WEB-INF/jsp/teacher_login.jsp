<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>先生専用ログイン</title>
	<!--  <link rel="stylesheet" href="<c:url value='/css/common.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/teacher.css'/>">  -->
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/teacher.css">
</head>

<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<h1>C-Share</h1>
		<label class="out"><a href="/A4/TeacherAccountRegistServlet">アカウント登録</a></label>
		
		<div class="logo">
			<a href="/webapp/LoginServlet"><img src = "images/cshare.png" width="300px" height="122px"></a>
		</div>
		${msg}
	</header>
	
	<div class="login-form-container">
		<form class="login-form" method="POST" action="/A4/TeacherLoguinServlet">
			<div class="tregist">
				<!-- 教師名とパスワードの入力 -->
				<div>
					<label for="name">名前</label><br>
					<input type="text" name="teacherName" required>
				</div>
	
				<div>
					<label for="pw">パスワード</label><br>
					<input type="password" name="teacherPw" required>
				</div>
				<input type="submit" name="login" value="ログイン">
			</div>
		</form>
	</div>
	
	<footer class="footer">
		<img src = "images/runningman.png">
	</footer>
</body>
</html>