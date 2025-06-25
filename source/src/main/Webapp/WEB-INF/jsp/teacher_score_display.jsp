<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>成績表示</title>
<link rel="stylesheet" href="<c:url value='css/common.css'/>">
<link rel="stylesheet" href="<c:url value='/css/teacher.css'/>">
</head>
<body>
	<header>
		<label class="out"> <a
			href="<c:url value='TeacherLogoutServlet'/>"><img
				src="images/out.png" width="50px" height="50px"></a>
		</label>
		<div class="logo">
			<a href="<c:url value='/TeacherMenuServlet'/>"><img
				src="<c:url value='/images/cshare.png'/>" width="300px"
				height="122px"></a>
		</div>
		<nav class="burner">
			<ul>
				<li><a href="<c:url value='/TeacherAttendanceServlet'/>"
					class="highlight">出欠管理</a></li>
				<li><a href="<c:url value='/TeacherGradeServlet'/>">成績管理</a></li>
				<li><a href="<c:url value='/TeacherMessageServlet'/>"
					class="highlight">連絡管理</a></li>
				<li><a href="<c:url value='/OtherAccountRegistServlet'/>"
					class="highlight">ユーザー一覧管理</a></li>

			</ul>
		</nav>
	</header>
	<h2>${sName}</h2>
	<c:forEach var="score" items="${testsResult}">
		<!--テスト名の表示-->
		<p>${score.term}学期</p>
		<p>${score.testName}テスト</p>
		<form method="POST"
			action="<c:url value='/TeacherScoreDisplayServlet'/>" id="form">
			<input type="hidden" name="id" value="${score.testsId}">
			<table>
				<!--表形式-->
				<tr>
					<th>国語</th>
					<th>数学</th>
					<th>理科</th>
					<th>社会</th>
					<th>英語</th>
					<th>総合</th>
				</tr>
				<tr>
					<td><input type=text name=japanese value="${score.japanese}"></td>
					<td><input type=text name=math value="${score.math}"></td>
					<td><input type=text name=science value="${score.science}"></td>
					<td><input type=text name=social value="${score.social}"></td>
					<td><input type=text name=english value="${score.english}"></td>
					<td><input type=text name=sum value="${score.sum}"></td>
				</tr>
				<tr>
					<td><input type=text name=averageJapanese value="${score.averageJapanese}"></td>
					<td><input type=text name=averageMath value="${score.averageMath}"></td>
					<td><input type=text name=averageScience value="${score.averageScience}"></td>
					<td><input type=text name=averageSocial value="${score.averageSocial}"></td>
					<td><input type=text name=averageEnglish value="${score.averageEnglish}"></td>
					<td><input type=text name=averageSum value="${score.averageSum}"></td>
				</tr>
			</table>
			<!--更新・削除ボタン-->
			<p class="submit">
				<input type="submit" name="update" value="更新">
				<input type="submit" name="delete" value="削除"><br>
				<span id='output'></span>
			</p>
		</form>

	</c:forEach>

	<footer class="footer">
		<img src="<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>