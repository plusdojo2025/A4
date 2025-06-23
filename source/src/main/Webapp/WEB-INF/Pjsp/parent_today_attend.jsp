<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>生徒の出席状況の確認・欠席登録</title>
	<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/parent.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/student.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/student_parent_common.css'/>">
</head>
<body>
    <header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<label class="out"><img src = "<c:url value='/OtherLoginServlet'/>">width="50px" height="50px"></label>
		<div class="logo">
			<a href="<c:url value='/OtherMenuServlet'/>"><img src = "<c:url value='/images/cshare.png'/>" >width="300px" height="122px"></a>
		</div>
		<ul>
			<li><a href="<c:url value='/OtherAttendanceServlet'/>" class="highlight">出欠管理</a></li>
			<li><a href="<c:url value='/OtherGradeServlet'/>" class="highlight">成績閲覧</a></li>
			<li><a href="<c:url value='/OtherMessageServlet'/>" class="highlight">連絡閲覧</a></li>
			<li><a href="<c:url value='/SoServlet'/>" class="highlight">チャット</a></li>
		</ul>
	</header>

    <div>
        <!--日付表示(のちに変更必要)-->
        <a href="parent_month_attend.jsp">
        <img src = "images/calender.png" width="70px" height="70px"></a>
        <p>日付：${attendanceDate.attendanceDate}</p>
    </div>
    <div>
        <!--生徒の出席状況の表示-->
        <form>
            <div>
               <p>名前</p>
               <p>出欠</p><br>
               
               <p>${student.name}</p>
               <select>
               		<option value="absent" ${student.attendance == 'absent' ? 'selected' : ''}>欠席</option>
               </select>
            </div>
            <input type="submit" name="regist" value="欠席登録"><br>
        </form>
        
    </div>
    <footer>
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>