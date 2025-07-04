<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生用アカウント登録</title>
</head>
<link rel="stylesheet" href="<c:url value='/css/teacher.css' />">
<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
<body>
	<header>
		<!-- ページタイトル -->
		<div class="logo">
			<a href="<c:url value='/TeacherLoginServlet'/>"><img src = "<c:url value='/images/cshare.png'/>" width="300px" height="122px"></a>
		</div>
		
		${errormsg}
	</header>
	<div class="teacher-form-container">
		<form class="teacher-form" method="POST" action="<c:url value='/TeacherAccountRegistServlet'/>" id="form">
			<!-- クラス名入力 -->
			<label>クラス名</label>
			<input type="text" name="className">
			<!-- 氏名入力 -->
			<label>氏名</label>
			<input type="text" name="teacherName">
			<!-- パスワード入力 -->
			<label>パスワード</label>
			<input type="password" name="teacherPw">
			
			<!-- 登録ボタン -->
			<input type="submit" name="regist" value="登録">
			<span id="error_message"></span>
		</form>
	</div>
<footer class="footer">
	<img src = "<c:url value='/images/runningman.png'/>">
</footer>	
</body>
</html>