<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>保護者専用連絡通知</title>
	<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/parent.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/student_parent_common.css'/>">
</head>
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<div class="out">
			<a href="<c:url value='/OtherLogoutServlet'/>" onclick="return outAlert();"><img src = "<c:url value='/images/out.png'/>" width="50px" height="50px"></a>
		</div>
		<div class="logo">
			<a href="<c:url value='/OtherMenuServlet'/>"><img src = "<c:url value='/images/cshare.png'/>" width="300px" height="122px"></a>
		</div>
		
		<nav class = "burner">
			<ul>
				<li><a href="<c:url value='/OtherAttendanceServlet'/>" class="highlight">出欠管理</a></li>
				<li><a href="<c:url value='/OtherGradeServlet'/>" class="highlight">成績閲覧</a></li>
				<li><a href="<c:url value='/OtherMessageServlet'/>">連絡閲覧</a></li>
			</ul>
		</nav>
	</header>
	<h2>連絡一覧</h2>                
		<c:forEach var="a" items="${announceList}">
		    <p>${a.announceDate}：</p>
		    <p>${a.announce}</p>
		    
		</c:forEach>
	<footer class="footer">
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>	
</body>
<script>
	function outAlert() {
		return confirm("ログアウトしてよろしいですか？");
	}
</script>
</html>