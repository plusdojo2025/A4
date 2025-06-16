<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生用ユーザー一覧</title>
</head>
<body>
<header>
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

	<input type="submit" id="register" name="regist" value="登録">

 <c:forEach var="e" items="${Allaccess}" >
	<form method="POST" action="/A4/UpdateDeleteServlet">
	氏名<input type="text" name="sName" value="${e.sName}">
	氏名<input type="text" name="pName" value="${e.pName}"><br>
	学籍番号<input type="text" name="sNumber" value="${e.sNumber}">
	学籍番号<input type="text" name="pNumber" value="${e.pNumber}"><br>
	パスワード<input type="password" name="sPw" value="${e.sPw}">
	パスワード<input type="password" name="pPw" value="${e.pPw}"><br>
	<input type="submit" name="update" value="更新">
	<input type="submit" name="delete" value="削除"><br>
	</form>
</c:forEach>
</body>
</html>