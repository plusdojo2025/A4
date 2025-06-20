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
		<h1><a href="/A4/TeacherMenuServlet">C-Share</a></h1>
		<label><a href="/A4/TeacherLoginServlet">ログアウト</a></label>
		<ul>
			<li><a href="/A4/TeacherAttendanceServlet">出欠管理</a></li>
			<li><a href="/A4/TeacherGradeServlet">成績管理</a></li>
			<li><a href="/A4/TeacherMessageServlet">連絡管理</a></li>
			<li><a href="/A4/TeacherAccountRegistServlet">ユーザー一覧</a></li>
			<li><a href="/A4/SoServlet">チャット</a></li>
		</ul>
	</header>
	<form>
		
		<h2>
		<!-- servletからその日の日付を取得 -->
		</h2>
	</form>
	
	<!-- ボタンを押すとカレンダーの画面に遷移 -->
	<a href="teacher_month_attend.jsp">⇦</a>
	
	<input type="text" name="attdate" value="<%= request.getAttribute("attendanceDate") %>" readonly>
	
	<c:forEach var="e" items="${cardList}">
		<!-- 生徒の出席状況 -->
		<form method="POST" action="/A4/TeacherAttendanceServlet">
		    <table>
		        <tr>
		            <td>名前: <input type="hidden" name="number" value="${e.number}">        	
		            		<input name = sName value = "${e.name}"></td>
		            <td>出欠:
		                <select name="attup">
		                    <option value="Present" <c:if test="${studentAttendance.attendance == 'Present'}">selected</c:if>>出席</option>
		                    <option value="Absent" <c:if test="${studentAttendance.attendance == 'Absent'}">selected</c:if>>欠席</option>
		                    <option value="Late" <c:if test="${studentAttendance.attendance == 'Late'}">selected</c:if>>遅刻</option>
		                    <option value="Early" <c:if test="${studentAttendance.attendance == 'Early'}">selected</c:if>>早退</option>
		                </select>
		            </td>
		            <td><input type="submit" value="更新"></td>
		        </tr>
		    </table>
		</form>

	</c:forEach>	
	<footer>
	</footer>
</body>
</html>