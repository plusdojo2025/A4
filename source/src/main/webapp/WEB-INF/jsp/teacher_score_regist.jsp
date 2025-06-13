<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生専用成績管理</title>
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
	
	<form method="POST" action="">
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