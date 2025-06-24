<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>生徒用ホーム</title>
	<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/parent.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/student.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/student_parent_common.css'/>">
</head>
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<div class="out">
			<a href="<c:url value='/LoginServlet'/>"><img src = "<c:url value='/images/out.png'/> width="50px" height="50px"></a>
		</div>
		<div class="logo">
			<a href="<c:url value='/OtherMenuServlet'/>"><img src = "<c:url value='/images/cshare.png'/>" width="300px" height="122px"></a>
		</div>
		
		<nav class = "burner">
			<ul>
				<li><a href="<c:url value='/OtherAttendanceServlet'/>" class="highlight">出席閲覧・出席登録</a></li>
				<li><a href="<c:url value='/OtherGradeServlet'/>" class="highlight">成績閲覧</a></li>
				<li><a href="<c:url value='/OtherMessageServlet'/>" class="highlight">連絡閲覧</a></li>
			</ul>
		</nav>
	</header>
	<div style="display: flex; gap:300px; justify-content: center;">
		<div>
		<!-- 時間割を表示する -->
		<h2>時間割</h2>
			<img src = "images/jikanwari.png" width="500px" height="300px">
		</div>
	</div>
	<div>
		<!-- 最新のお知らせ表示 -->
		<h2>最新のお知らせ</h2>
		<p>登録日時：<c:out value="${announcement.announceDate}" /></p>
		<p>連絡内容：<c:out value="${announcement.announce}" /></p>
	</div>
	<footer>
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>