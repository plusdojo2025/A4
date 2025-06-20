<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生用成績登録</title>
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
	
	<form method="POST" action="/A4/TeacherGradeRegistServlet" id="form">
		<!-- 入力欄 -->
		<input type="text" name="" value="${}">
		<!-- 生徒名をリクエスト領域から取得する -->
		<input type="text" name="japanese"><br>
		<input type="text" name="math"><br>
		<input type="text" name="science"><br>
		<input type="text" name="social"><br>
		<input type="text" name="english"><br>
		<input type="submit" name="regist" value="登録"><br>
	</form>
	
	<footer>
	</footer>
</body>
</html>