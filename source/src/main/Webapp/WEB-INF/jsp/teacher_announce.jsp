<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生専用連絡通知</title>
</head>
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<h1>C-Share</h1>
		<label><a href="/A4/TeacherLoginServlet">ログアウト</a></label>
		<ul>
			<li><a href="/A4/TeacherAttendanceServlet">出欠管理</a></li>
			<li><a href="/A4/TeacherGradeServlet">成績管理</a></li>
			<li><a href="/A4/TeacherMessageServlet">連絡管理</a></li>
			<li><a href="/A4/TeacherAccountRegistServlet">ユーザー一覧</a></li>
			<li><a href="/A4/SoServlet">チャット</a></li>
		</ul>
	</header>
	<h2>連絡一覧</h2>
	<!-- 登録日時を表示 -->	
	<c:forEach var="e" items="${announceList}">
	<table>
	  <tr>
	    <td>${e.date}</td>
	  </tr>
	  <!-- 連絡内容を表示 -->
	  <tr>
	  	<td>${e.announcements}</td>
	  </tr>
	  </table>
	  </c:forEach>
	  <!-- 連絡事項の登録 -->
	  <form method="POST" action="/A4/TeacherMessageServlet">
	  <table>
	  <tr>
	  	<td><input type="hidden" name="classname" value="${e.classname}">   
	  		<input type="text" name="enter" value="入力してください" required>
	  	</td>
	  	<td>
	  		<input type="submit"name="sendMessage" value="送信">
	  	</td>
	  </tr>
	</table>
	</form>
	 
</body>
</html>