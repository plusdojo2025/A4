<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>生徒の出席状況の確認・出席登録</title>
	<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/parent.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/student.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/student_parent_common.css'/>">
</head>
<body>
	<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<div class="out">
			<a href="<c:url value='/LoginServlet'/>"><img src = "<c:url value='/images/out.png'/> width="50px" height="50px"></a>
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

    <div class="day">
        <!--日付表示(のちに変更必要)-->
        <p>日付：${attendanceDate.attendanceDate}</p>
    </div>
    <!-- ボタンを押すとカレンダーの画面に遷移 -->
    <div class="calender">
    	<a href="<c:url value='/student_month_attend.jsp'/>"><img src = "<c:url value='images/calender.png'/>"width="70px" height="70px"></a>
    </div>
    <div>
        <!--生徒の出席状況の表示-->
        <form>
            <div class="attend">
                <div class="attend2">
	               <lavel for="name">名前</lavel>
	               <label for="status">出欠</label>
                </div>
                <div class="attend2">
                	<lavel for="name">
               			<p id="student-name">${student.name}</p>
               			<input type="hidden" name="number" value="${e.number}">
               		</lavel>
               		<label for="status">
               			<select name="status" id="status">
               				<option value="absent" ${student.attendance == 'absent' ? 'selected' : ''}>出席</option>
               			</select>
               		</label>
            	</div>
            	<div class="button">
            		<input type="submit" name="regist" value="出席登録"><br>
            	</div>
            </div>
        </form>
    </div>
    <footer>
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>