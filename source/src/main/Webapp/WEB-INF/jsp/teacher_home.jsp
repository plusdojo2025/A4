<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生専用ホーム</title>
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
	<div>
		<!-- カレンダーを制作 -->
		
		<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.10/index.global.min.js"></script>

		<script>
			document.addEventListener('DOMContentLoaded', function () {
				const calendarEl = document.getElementById('calendar');

				const calendar = new FullCalendar.Calendar(calendarEl, {
					initialView: 'timeGridWeek', // 初期表示：週表示
					headerToolbar: {
						left: 'prev,next today',
						center: 'title',
						right: 'dayGridMonth,timeGridWeek' // ← 月・週切り替えボタン
					},
					
					initialDate: '2025-07-01',
					slotMinTime: "09:00:00",
					slotMaxTime: "18:00:00",
					events: [
						{
							title: '山田勤務',
							start: '2025-07-01T09:00:00',
							end: '2025-07-01T12:00:00'
						},
						{
							title: '佐藤会議',
							start: '2025-07-03T13:00:00',
							end: '2025-07-03T14:00:00',
							color: 'green'
						}
					]
				});
				
				calendar.render();
			});
		</script>
		
		
		
		
		
	</div>
	<div>
		<!-- 最新のお知らせ表示 -->
		<h2>最新のお知らせ</h2>
		<p>登録日時：<c:out value="${announcement.announceDate}" /></p>
		<p>連絡内容：<c:out value="${announcement.announce}" /></p>		
	</div>
	<footer>
	</footer>
</body>
</html>