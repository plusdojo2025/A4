<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>先生専用ホーム</title>
	<link rel="stylesheet" href="<c:url value='/css/common.css' />">
	<link rel="stylesheet" href="<c:url value='/css/teacher.css' />">
	<!-- FullCalendarのCSS -->
	<link href="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.10/index.global.min.css" rel="stylesheet" />
	<style>
		#calendar {
		max-width: 900px;
		margin: 50px auto;
		}
	</style>
</head>
	
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<label class="out">
			<a href="<c:url value='TeacherLoginServlet'/>"><img src = "images/out.png" width="50px" height="50px"></a>
		</label>
		<div class="logo">
			<a><img src = "images/cshare.png" width="300px" height="122px"></a>
		</div>
		
		<nav class = "burner">
			<ul>
                <li><a href="<c:url value='/TeacherAttendanceServlet'/>">出欠管理</a></li>
				<li><a href="<c:url value='/TeacherGradeServlet'/>">成績管理</a></li>
				<li><a href="<c:url value='/TeacherMessageServlet'/>">連絡管理</a></li>
				<li><a href="<c:url value='/OtherAccountRegistServlet'/>">ユーザー一覧管理</a></li>
				
			</ul>
		</nav>
	</header>
	
		<!-- カレンダーを制作 -->
		<h2 style="text-align:center;">カレンダー</h2>
  		<div id="calendar"></div>
		<!-- FullCalendarのJS -->
  		<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.10/index.global.min.js"></script>
  		
		<script>
		  document.addEventListener('DOMContentLoaded', function () {
		    const calendarEl = document.getElementById('calendar');
		
		    const calendar = new FullCalendar.Calendar(calendarEl, {
		      initialView: 'dayGridMonth', // 初期表示：週表示
		      headerToolbar: {
		        left: 'prev,next today',
		        center: 'title',
		        right: '' 
		      },
		      initialDate: '2025-07-01',
		      slotMinTime: "09:00:00",
		      slotMaxTime: "18:00:00",
		      events: []
		    });
		
		    calendar.render();
		  });
		</script>
		
	<footer class="footer">
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>