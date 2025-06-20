<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>保護者用成績閲覧</title>
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
	<main>
	<select>
		<!-- 学期選択 -->
	    <option value="1">1学期</option>
	    <option value="2">2学期</option>
	    <option value="3">3学期</option>
  	</select>
  	<form method="POST" action="">
		<!-- テストを検索する -->
		<input type="text" name="testName">テスト
		<input type="submit" name="search" value="検索"><br>
	</form>
	<c:forEach var="e" items="${}" >
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
	</main>
</body>
</html>