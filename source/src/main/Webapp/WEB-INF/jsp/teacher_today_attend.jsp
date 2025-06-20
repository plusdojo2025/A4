<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生用出欠管理</title>
</head>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/teacher.css">
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<label class="out">
			<a href="/A4/TeacherLoginServlet"><img src = "images/out.png" width="50px" height="50px"></a>
		</label>
		<div class="logo">
			<a href="/webapp/TeacherMenuServlet"><img src = "images/cshare.png" width="300px" height="122px"></a>
		</div>
		
		<nav class = "burner">
			<ul>
				<li><a href="/A4/TeacherAttendanceServlet">出欠管理</a></li>
				<li><a href="/A4/TeacherGradeServlet">成績管理</a></li>
				<li><a href="/A4/TeacherMessageServlet">連絡管理</a></li>
				<li><a href="/A4/TeacherAccountRegistServlet">ユーザー一覧</a></li>
				<li><a href="/A4/SoServlet">チャット</a></li>
			</ul>
		</nav>	
	</header>
	<form>
		
		<h2>
		<!-- servletからその日の日付を取得 -->
		</h2>
	</form>
	<div  class="attend">
	<!-- ボタンを押すとカレンダーの画面に遷移 -->
	<a href="teacher_month_attend.jsp"><img src = "images/calender.png" width="70px" height="70px"></a>
	
	<input type="text" name="attdate" value="<%= request.getAttribute("attendanceDate") %>" readonly>
	</div>
	
	<div class="attend2">
	<form method="POST" action="/A4/TeacherAttendanceServlet">
		<c:forEach var="e" items="${cardList}">
			<!-- 生徒の出席状況 -->
		    <table>
			    <tr>
		        	<th>名前</th>
					<th>出欠</th>
					<th>操作</th>
				</tr>
				<tr>
			        <td>
			        	<div style="display:flex;">
			       			<input type="hidden" name="number" value="${e.number}">      	
		            		<div><input name = sName value = "${e.name}"></div>
			            		<div class="attend-row">
					                <select name="attup">
					                    <option value="Present" <c:if test="${studentAttendance.attendance == 'Present'}">selected</c:if>>出席</option>
					                    <option value="Absent" <c:if test="${studentAttendance.attendance == 'Absent'}">selected</c:if>>欠席</option>
					                    <option value="Late" <c:if test="${studentAttendance.attendance == 'Late'}">selected</c:if>>遅刻</option>
					                    <option value="Early" <c:if test="${studentAttendance.attendance == 'Early'}">selected</c:if>>早退</option>
					                </select>
					            </div> 
			            	<input type="submit" value="更新">
		            	</div>
	            	</td>
		        </tr>
		    </table>
		</c:forEach>
	</form>
	</div>	
	<footer class="footer">
		<img src = "images/runningman.png">
	</footer>
</body>
</html>