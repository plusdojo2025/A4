<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カレンダー</title>
</head>
<body>
	<header>
		<!-- ページタイトル -->
		<h1><a href="/A4/TeacherMenuServlet">C-Share</a></h1>
		<label><a href="/A4/TeacherLoginServlet">ログアウト</a></label>
		<!-- メニュー欄 -->
		<ul>
			<li><a href="/A4/TeacherAttendanceServlet">出席登録・閲覧</a></li>
			<li><a href="/A4/TeacherGradeSrevlet">成績閲覧</a></li>
			<li><a href="/A4/TeacherMessageServlet">連絡閲覧</a></li>
			<li><a href="/A4/SoServlet">チャット</a></li>
		</ul>
	</header>
	
	<div>
		<!-- カレンダー表示 -->
		<h2>○○月</h2>
	</div>
	
</body>
</html>