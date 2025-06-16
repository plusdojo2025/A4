<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>保護者専用ホーム</title>
</head>
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<h1>C-Share</h1>
		<label><a href="/A4/LoginServlet">ログアウト</a></label>
		<ul>
			<li><a href="/A4/AttendanceServlet">出席閲覧・欠席登録</a></li>
			<li><a href="/A4/GradeServlet">成績閲覧</a></li>
			<li><a href="/A4/MessageServlet">連絡閲覧</a></li>
			<li><a href="/A4/LoadHistoryServlet">チャット</a></li>
		</ul>
	</header>
	<div>
		<!-- 時間割を表示する -->
		<h2>○○年○○月○○日～○○日</h2>
	</div>
	<div>
		<!-- 最新のお知らせ表示 -->
		<h2>最新のお知らせ</h2>
	</div>
	<footer>
	</footer>
</body>
</html>