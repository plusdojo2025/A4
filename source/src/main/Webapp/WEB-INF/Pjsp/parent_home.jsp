<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
		<label><a href="/A4/OtherLoginServlet">ログアウト</a></label>
		<ul>
			<li><a href="/A4/OtherAttendanceServlet">出席閲覧・欠席登録</a></li>
			<li><a href="/A4/OtherGradeServlet">成績閲覧</a></li>
			<li><a href="/A4/OtherMessageServlet">連絡閲覧</a></li>
			<li><a href="/A4/SoServlet">チャット</a></li>
		</ul>
	</header>
	<div>
		<!-- 時間割を表示する -->
		<h2>○○年○○月○○日～○○日</h2>
	</div>
	<div>
		<!-- 最新のお知らせ表示 -->
		<h2>最新のお知らせ</h2>
		<p>登録日時：<c:out value="${announcement.announceDate}" /></p>
		<p>連絡内容：<c:out value="${announcement.announce}" /></p>
	</div>
	<footer>
	</footer>
</body>
</html>