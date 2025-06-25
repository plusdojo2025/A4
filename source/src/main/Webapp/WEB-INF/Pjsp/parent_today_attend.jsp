<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>生徒の出席状況の確認・欠席登録</title>
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
				<li><a href="<c:url value='/OtherAttendanceServlet'/>">出欠管理</a></li>
				<li><a href="<c:url value='/OtherGradeServlet'/>" class="highlight">成績閲覧</a></li>
				<li><a href="<c:url value='/OtherMessageServlet'/>" class="highlight">連絡閲覧</a></li>
			</ul>
		</nav>
	</header>

   
       <!-- ボタンを押すとカレンダーの画面に遷移 -->
    <div class="calender">
    <!-- 直接JSPを呼ぶことはできない。 -->
    	<a href="<c:url value='/OtherDisplayCalenderServlet'/>"><img src = "<c:url value='images/calender.png'/>"width="70px" height="70px"></a>
    </div>
    <div>
        <!--生徒の出席状況の表示-->
        <form method="POST" action="<c:url value='/OtherAttendanceServlet'/>" class="form-flex">

		    <input type="hidden" name="number" value="${attendanceDate.number}">
		    <input type="hidden" name="status" value="欠席">
		    
		    <div class="day">
		        <p>日付：${today}</p>
		    </div>
		    
		    <div class="attend">
		        <div class="attend2">
		            <label for="name">名前</label>
		            <label for="status">出欠</label>
		        </div>
		        <div class="attend2">
		            <label id="student-name">${sessionScope.Sidpw.sName}</label>
		            <label>${attendanceDate.status}</label>
		        </div>
		        <div class="button">
		            <input type="submit" name="regist" value="欠席登録" onclick="return absenceAlert();"><br>
		        </div>
		    </div>
		</form>

    </div>
    <footer class="footer">
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
<script>
function outAlert() {
	return confirm("ログアウトしてよろしいですか？");
  }

function absenceAlert() {
  alert("欠席登録してよろしいですか？");
  return true;
}
</script>
</html>