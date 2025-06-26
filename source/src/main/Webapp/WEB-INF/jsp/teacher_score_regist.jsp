<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<label class="out"><img
			src="<c:url value='/TeacherLogoutServlet'/>" width="50px"
			height="50px"></label>
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


	<form method="POST"
		action="<c:url value='/TeacherGradeRegistServlet'/>" id="form">
		<select name="term">
			<!-- 学期選択 -->
			<option value="1">1学期</option>
			<option value="2">2学期</option>
			<option value="3">3学期</option>
		</select>
		<!-- テストを検索する -->
		<input type="text" name="testName">テスト <input type="submit"
			name="submit" value="検索"><br>

		<!-- 検索結果が空の場合のメッセージ -->
		<c:if test="${empty scoreList}">
			<p>該当する成績データが見つかりませんでした。</p>
		</c:if>
		<table>
			<c:forEach var="student" items="${scoreList}" varStatus="status">
				<tr>
					<td><input type="text" name="sName" value="${student.sName}"
						readonly></td>
					<td><input type="text" name="japanese"
						value="${student.japanese}"></td>
					<td><input type="text" name="math" value="${student.math}"></td>
					<td><input type="text" name="science"
						value="${student.science}"></td>
					<td><input type="text" name="social" value="${student.social}"></td>
					<td><input type="text" name="english"
						value="${student.english}"></td>
					<td><input type="text" name="sum" value="${student.sum}"></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" name="submit" value="登録"><br>
	</form>


	<footer class="footer">
		<img src="<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>