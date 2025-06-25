<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生用成績閲覧・更新・削除</title>
<link rel="stylesheet" href="<c:url value='css/common.css'/>">
<link rel="stylesheet" href="<c:url value='/css/teacher.css'/>">
</head>
<body>
	<header>
		<label class="out">
			<a href="<c:url value='TeacherLogoutServlet'/>"><img src = "images/out.png" width="50px" height="50px"></a>
		</label>
		<div class="logo">
			<a href="<c:url value='/TeacherMenuServlet'/>"><img src = "<c:url value='/images/cshare.png'/>" width="300px" height="122px"></a>
		</div>
		<nav class = "burner">
            <ul>
                <li><a href="<c:url value='/TeacherAttendanceServlet'/>" class="highlight">出欠管理</a></li>
				<li><a href="<c:url value='/TeacherGradeServlet'/>">成績管理</a></li>
				<li><a href="<c:url value='/TeacherMessageServlet'/>" class="highlight">連絡管理</a></li>
				<li><a href="<c:url value='/OtherAccountRegistServlet'/>" class="highlight">ユーザー一覧管理</a></li>
				
            </ul>
        </nav>
	</header>

	<div>
		<!-- 成績登録ボタン -->
		<label class="out"><a href="<c:url value='/TeacherGradeRegistServlet'/>"><input type="submit" name="regist" value="成績登録"></a></label>
	</div>

	
		<!-- 生徒名簿の表示 -->
	<div class="student-sidebar">
		<h2>生徒名簿</h2>
		<ul>
			<c:forEach var="student" items="${studentList}">
			   <form method="GET" action="TeacherScoreDisplayServlet">
			       <input type="hidden" name="number" value="${student.number}">
			       <input type="submit" value="${student.sName}">
			   </form>
			</c:forEach>

		</ul>
	</div>

   
	<footer class="footer">
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>

