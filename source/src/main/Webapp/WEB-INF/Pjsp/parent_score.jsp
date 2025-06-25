<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>保護者用成績閲覧</title>
	<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/parent.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/student_parent_common.css'/>">
</head>
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<div class="out">
			<a href="<c:url value='/LoginServlet'/>"><img src = "<c:url value='/images/out.png'/>" width="50px" height="50px"></a>
		</div>
		<div class="logo">
			<a href="<c:url value='/OtherMenuServlet'/>"><img src = "<c:url value='/images/cshare.png'/>" width="300px" height="122px"></a>
		</div>
		
		<nav class = "burner">
			<ul>
				<li><a href="<c:url value='/OtherAttendanceServlet'/>" class="highlight">出欠管理</a></li>
				<li><a href="<c:url value='/OtherGradeServlet'/>">成績閲覧</a></li>
				<li><a href="<c:url value='/OtherMessageServlet'/>" class="highlight">連絡閲覧</a></li>
			</ul>
		</nav>
	</header>
	<main>
	<div class="student-main-content">
		<div class="selectbox-5">
			<select>
				<!-- 学期選択 -->
			    <option value="1">1学期</option>
			    <option value="2">2学期</option>
			    <option value="3">3学期</option>
		  	</select>
		 </div> 	
	  	<form method="POST" action="">
			<!-- テストを検索する -->
			<input type="text" name="testName">テスト
			<input type="submit" name="search" value="検索"><br>
		</form>
		<c:forEach var="e" items="${scoreList}" >
		<form method="POST" action="/A4/OtherGradeServlet">
			<table>
				<tr>
					<td></td>
					<td>国語</td>
					<td>数学</td>
					<td>理科</td>
					<td>社会</td>
					<td>英語</td>
					<td>総合</td>
				</tr>
				<tr>
					<td>点数</td>
					<td>${e.japanese}</td>
					<td>${e.math}</td>
					<td>${e.science}</td>
					<td>${e.social}</td>
					<td>${e.english}</td>
					<td>${e.sum}</td>
				</tr>
				<tr>
					<td>平均</td>
					<td>${e.averageJapanese}</td>
					<td>${e.averageMath}</td>
					<td>${e.averageScience}</td>
					<td>${e.averageSocial}</td>
					<td>${e.averageEnglish}</td>
					<td>${e.averageSum}</td>
				</tr>
			</table>
		</form>	
		</c:forEach>
	</div>	
	</main>
	<footer class="footer">
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>