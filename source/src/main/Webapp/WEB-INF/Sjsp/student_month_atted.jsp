<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>カレンダー</title>
	<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/student.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/student_parent_common.css'/>">
	<!-- FullCalendar CDN -->
  	<link href="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.10/index.global.min.css" rel="stylesheet" />
  	<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.10/index.global.min.js"></script>

    <style>
      #calendar {
        max-width: 900px;
        margin: 40px auto;
      }
    </style>
</head>
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<div class="out">
			<a href="<c:url value='/OtherLogoutServlet'/>"><img src = "<c:url value='/images/out.png'/>" width="50px" height="50px"></a>
		</div>
		<div class="logo">
			<a href="<c:url value='/OtherMenuServlet'/>"><img src = "<c:url value='/images/cshare.png'/>" width="300px" height="122px"></a>
		</div>
		
		<nav class = "burner">
			<ul>
				<li><a href="<c:url value='/OtherAttendanceServlet'/>">出欠管理</a></li>
				<li><a href="<c:url value='/OtherGradeServlet'/>" class="highlight">成績閲覧</a></li>
				<li><a href="<c:url value='/OtherMessageServlet'/>" class="highlight">連絡閲覧</a></li>
			</ul>
		</nav>
	</header>
	
	<div id="calendar"></div>

  <!-- POSTでServletに送信するフォーム -->
  <form id="dateForm" action="<c:url value='/OtherDisplayAttendanceServlet' />" method="POST">
    <input type="hidden" name="date" id="dateInput">
  </form>

  <script>
    // カレンダーの日付をクリックしたとき
    document.addEventListener('DOMContentLoaded', function() {
      const calendarEl = document.getElementById('calendar');

      const calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        selectable: true,
        dateClick: function(info) {
          const clickedDate = info.dateStr; // "2025-06-16" 形式
          alert("送信する日付: " + clickedDate); // デバッグ用

          // フォームに値をセットして送信
          document.getElementById('dateInput').value = clickedDate;
          document.getElementById('dateForm').submit();
        }
      });

      calendar.render();
    });
  </script>
	<footer class="footer">
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>