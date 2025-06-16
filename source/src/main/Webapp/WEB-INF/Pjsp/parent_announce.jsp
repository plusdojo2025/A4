<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>保護者専用連絡通知</title>
</head>
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<h1>C-Share</h1>
		<label><a href="/A4/LoginServlet">ログアウト</a></label>
		<ul>
			<li><a href="/A4/AttendanceServlet">出欠管理</a></li>
			<li><a href="/A4/GradeServlet">成績管理</a></li>
			<li><a href="/A4/MessageServlet">連絡管理</a></li>
			<li><a href="/A4/AccountRegistServlet">ユーザー一覧</a></li>
			<li><a href="/A4/LoadHistoryServlet">チャット</a></li>
		</ul>
	</header>
	<h2>連絡一覧</h2>
	<table>
	  <tr>
	    <td><!--登録日時を表示--></td>
	  </tr>
	  <!-- 連絡内容を表示 -->
	  <tr>
	  	<td>
	    	<input type="text" name="announcetext" readonly>
	    </td>
	  </tr>
	  <tr>
	    <td>
	    	<input type="text" name="announcetext" readonly>
	    </td>
	  </tr>
	</table>
</body>
</html>