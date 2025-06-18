<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<h1>C-Share</h1>
		<label>ログアウト</label>
		<ul>
			<li>出欠管理</li>
			<li>成績管理</li>
			<li>連絡管理</li>
			<li>ユーザー一覧</li>
			<li>チャット</li>
		</ul>
	</header>
	<form>
		
		<h2>
		<!-- servletからその日の日付を取得 -->
		</h2>
	</form>
	
	<!-- ボタンを押すとカレンダーの画面に遷移 -->
	<a href="teacher_month_attend.jsp">⇦</a>
	
	<table>
	<tr>
		<!-- 生徒の出席状況ラベル -->
		<th>名前</th>
		<th>出欠</th>
	</tr>
	
	<c:forEach var="e" items="${}">
		<!-- 生徒の出席状況 -->
		<form method="POST" action="/A4/GradeServlet">
		    <table>
		        <tr>
		            <td>名前: <input type="hidden" name="studentName" value="${studentName.name}"></td>
		            <td>出欠:
		                <select name="attup">
		                    <option value="Present" <c:if test="${studentAttendance.attendance == 'Present'}">selected</c:if>>出席</option>
		                    <option value="Absent" <c:if test="${studentAttendance.attendance == 'Absent'}">selected</c:if>>欠席</option>
		                    <option value="Late" <c:if test="${studentAttendance.attendance == 'Late'}">selected</c:if>>遅刻</option>
		                    <option value="Early" <c:if test="${studentAttendance.attendance == 'Early'}">selected</c:if>>早退</option>
		                </select>
		            </td>
		            <td><input type="submit" value="登録"></td>
		        </tr>
		    </table>
		</form>

	</c:forEach>
	</table>	
	<footer>
	</footer>
</body>
</html>