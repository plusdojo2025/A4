<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			名前
			<td>${studentName.name}
			
    		出欠:
   			<select>
		        <option value="Present" ${studentAttendance.attendance == 'Present' ? 'selected' : ''}>出席</option>
		        <option value="Absent" ${studentAttendance.attedance == 'Absent' ? 'selected' : ''}>欠席</option>
		        <option value="Late" ${studentAttendance.attedance == 'Late' ? 'selected' : ''}>遅刻</option>
		        <option value="early" ${studentAttendance.attedance == 'early' ? 'selected' : ''}>早退</option>
	    	</select><br>
		    <input type="submit" value="登録" />
		</form>
	</c:forEach>
	</table>	
	<footer>
	</footer>
</body>
</html>