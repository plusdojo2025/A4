<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>保護者用成績閲覧</title>
<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
<link rel="stylesheet" href="<c:url value='/css/parent.css'/>">
<link rel="stylesheet"
	href="<c:url value='/css/student_parent_common.css'/>">
</head>
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<div class="out">
			<a href="<c:url value='/OtherLogoutServlet'/>"
				onclick="return outAlert();"><img
				src="<c:url value='/images/out.png'/>" width="50px" height="50px"></a>

		</div>
		<div class="logo">
			<a href="<c:url value='/OtherMenuServlet'/>"><img
				src="<c:url value='/images/cshare.png'/>" width="300px"
				height="122px"></a>
		</div>

		<nav class="burner">
			<ul>
				<li><a href="<c:url value='/OtherAttendanceServlet'/>"
					class="highlight">出欠管理</a></li>
				<li><a href="<c:url value='/OtherGradeServlet'/>">成績閲覧</a></li>
				<li><a href="<c:url value='/OtherMessageServlet'/>"
					class="highlight">連絡閲覧</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<div class="student-main-content">

			<form method="POST" action="<c:url value='/OtherGradeServlet'/>">
				<div class="selectbox-5">
					<select name="term">
						<!-- 学期選択 -->
						<option value="1">1学期</option>
						<option value="2">2学期</option>
						<option value="3">3学期</option>
					</select>
				</div>

				<!-- テストを検索する -->
				<input type="text" name="testName">テスト <input type="submit"
					name="search" value="検索"><br>

				<!-- 検索結果が空の場合のメッセージ -->
				<c:if test="${empty scoreList}">
					<p>該当する成績データが見つかりませんでした。</p>
				</c:if>
				<div class="test">
					<c:forEach var="e" items="${scoreList}">
					<p>${e.term}学期</p>
					<p>${e.testName}テスト</p>
						<table>
							<tr>
								<th>国語</th>
								<th>数学</th>
								<th>理科</th>
								<th>社会</th>
								<th>英語</th>
								<th>総合</th>
							</tr>
							<tr>
								<td><input type=text name=japanese value="${e.japanese}"></td>
								<td><input type=text name=math value="${e.math}"></td>
								<td><input type=text name=science value="${e.science}"></td>
								<td><input type=text name=social value="${e.social}"></td>
								<td><input type=text name=english value="${e.english}"></td>
								<td><input type=text name=sum value="${e.sum}"></td>
							</tr>
							<tr>
								<td><input type=text name=averageJapanese
									value="${e.averageJapanese}"></td>
								<td><input type=text name=averageMath
									value="${e.averageMath}"></td>
								<td><input type=text name=averageScience
									value="${e.averageScience}"></td>
								<td><input type=text name=averageSocial
									value="${e.averageSocial}"></td>
								<td><input type=text name=averageEnglish
									value="${e.averageEnglish}"></td>
								<td><input type=text name=averageSum
									value="${e.averageSum}"></td>
							</tr>
						</table>
					</c:forEach>
				</div>
			</form>
		</div>
	</main>
	<footer class="footer">
		<img src="<c:url value='/images/runningman.png'/>">
	</footer>
</body>
<script>
	function outAlert() {
		return confirm("ログアウトしてよろしいですか？");
	}
</script>
</html>