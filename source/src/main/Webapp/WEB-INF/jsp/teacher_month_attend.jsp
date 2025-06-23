<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カレンダー</title>
</head>
<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
<link rel="stylesheet" href="<c:url value='/css/teacher.css'/>">
<body>
	<header>
		<label class="out"><img src = "<c:url value='/TeacherAccountRegistServlet'/>">width="50px" height="50px"></label>
		<div class="logo">
			<a href="<c:url value='/LoginServlet'/>"><img src = "<c:url value='/images/cshare.png'/>" >width="300px" height="122px"></a>
		</div>
		<nav class = "burner">
			<ul>
				<li><a href="<c:url value='/AttendanceServlet'/>" class="highlight">出欠管理</a></li>
				<li><a href="<c:url value='/GradeServlet'/>" class="highlight">成績管理</a></li>
				<li><a href="<c:url value='/MessageServlet'/>" class="highlight">連絡管理</a></li>
				<li><a href="<c:url value='/AccountRegistServlet'/>">ユーザー一覧管理</a></li>
				<li><a href="<c:url value='/SoServlet'/>" class="highlight">チャット</a></li>
			</ul>
		</nav>
	</header>
	
	<div>
		<!-- カレンダー表示 -->
		<h2>○○月</h2>
		<form action="teacher_today_attend.jsp" method="get">
        <input type="date" name="attendanceDate" required>
        <input type="submit" name="action" value="移動">
	</div>
	<footer class="footer">
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>
