<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生用ユーザー一覧</title>
</head>
<body>
<header>
		<h1><a href="/A4/TeacherMenuServlet">C-Share</a></h1>
		<label><a href="/A4/TeacherLoginServlet">ログアウト</a></label>
		<ul>
			<li><a href="/A4/TeacherAttendanceServlet">出欠管理</a></li>
			<li><a href="/A4/TeacherGradeServlet">成績管理</a></li>
			<li><a href="/A4/TeacherMessageServlet"></a>連絡管理</li>
			<li><a href="/A4/TeacherAccountRegistServlet"></a>ユーザー一覧</li>
			<li><a href="/A4/SoServlet">チャット</a></li>
		</ul>
</header>

	<input type="submit" id="register" name="regist" value="登録">

 <c:forEach var="e" items="${Allaccess}" >
	<form method="POST" action="/A4/OtherAccountRegistServlet">
	氏名<input type="text" name="sName" value="${e.sName}">
	氏名<input type="text" name="pName" value="${e.pName}"><br>
	学籍番号<input type="text" name="sNumber" value="${e.sNumber}">
	学籍番号<input type="text" name="pNumber" value="${e.pNumber}"><br>
	パスワード<input type="password" name="sPw" value="${e.sPw}">
	パスワード<input type="password" name="pPw" value="${e.pPw}"><br>
	<input type="submit" name="submit" value="更新">
	<input type="submit" name="submit" value="削除"><br>
	</form>
</c:forEach>
</body>
</html>