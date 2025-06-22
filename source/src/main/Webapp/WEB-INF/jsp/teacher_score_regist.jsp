<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生用成績登録</title>
<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
<link rel="stylesheet" href="<c:url value='/css/teacher.css'/>">
</head>
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
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
				<li><a href="<c:url value='/LoadHistoryServlet'/>" class="highlight">チャット</a></li>
			</ul>
		</nav>
	</header>
	<select>
		<!-- 学期選択 -->
	    <option value="1">1学期</option>
	    <option value="2">2学期</option>
	    <option value="3">3学期</option>
  	</select>
  	
	<form method="POST" action="<c:url value='/TeacherGradeRegistServlet'/>">
		<!-- テストを検索する -->
		<input type="text" name="testName">テスト
		<input type="submit" name="search" value="検索"><br>
	</form>
	
	<form method="POST" action="<c:url value='/TeacherGradeRegistServlet'/>" id="form">
		<table>
			<c:forEach var="student" items="${scoreList}" varStatus="status">
				<tr>
					<!-- 生徒名をリクエスト領域から取得する -->
					<td><input type="text" name="japanese" value="${scoreList.japanese}"></td>
					<td><input type="text" name="math" value="${scoreList.math}"></td>
					<td><input type="text" name="science" value="${scoreList.science}"></td>
					<td><input type="text" name="social" value="${scoreList.social}"></td>
					<td><input type="text" name="english" value="${scoreList.english}"></td>
					<td><input type="text" name="sum" value="${scoreList.sum}"></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" name="regist" value="登録"><br>
	</form>
	
	
	<footer class="footer">
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>