<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生専用ユーザー登録</title>
<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
<link rel="stylesheet" href="<c:url value='/css/teacher.css'/>">
</head>
<body>
<header>
		<!-- ページタイトルやメニュー欄を記載 -->
		<label class="out"><img src = "<c:url value='/TeacherAccountRegistServlet'/>">width="50px" height="50px"></label>
		<div class="logo">
			<a href="<c:url value='/LoginServlet'/>"><img src = "<c:url value='/images/cshare.png'/>" >width="300px" height="122px"></a>
		</div>
		<nav class = "burner">
            <ul>
                <li><a href="<c:url value='/AttendanceServlet'/>" class="highlight">出欠管理</a></li>
				<li><a href="<c:url value='/GradeServlet'/>" class="highlight">成績管理</a></li>
				<li><a href="<c:url value='/MessageServlet'/>" class="highlight">連絡管理</a></li>
				<li><a href="<c:url value='/AccountRegistServlet'/>">ユーザー一覧管理</a></li>
				<li><a href="<c:url value='/LoadHistoryServlet'/>" class="highlight">チャット</a></li>
            </ul>
        </nav>
</header>
	
<main>
	<div class="contact-form-container">
		<form method="POST" action="<c:url value='/AccountRegistServlet'/>" id="form">
			<table>
				<!--  生徒 -->
				<tr>
					<td>
						<h3>生徒</h3>
					</td>
				</tr>      
				<tr>
					<td>
						<label>氏名<br>
						<input type="text" name="studentName">
						</label>
					</td>
				</tr>
				<tr>
					<td>
						<label>クラス<br>
	                		<input type="text" name="className">
						</label>
					</td>
				</tr>
				<tr>
					<td>
						<label>学籍番号<br>
							<input type="text" name="studentNumber" id="number1">
						</label>
					</td>
				</tr> 
				<tr>
					<td>
						<label>パスワード<br>
							<input type="text" name="studentPw">
						</label>
					</td>
				</tr>
				</table>
				
				<!--  保護者 -->
				<table> 
					<tr>
						<td>
							<h3>保護者</h3>
						</td>
					</tr>    
					<tr>
						<td>
							<label>氏名<br>
								<input type="text" name="parentName">
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label>学籍番号<br>
								<input type="text" name="studentNumber" id="number2">
							</label>
						</td>
					</tr>      
					<tr>
						<td>
							<label>パスワード<br>
								<input type="text" name="parentPw">
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" id="register" name="regist" value="登録">
							<span id="error_message"></span>
						</td>
					</tr>
				</table>       
		</form>
  	</div>
 </main>
 <!--  学籍番号の共有 -->
	<script>
	  	var number1 = document.getElementById("number1");
	  	var number2 = document.getElementById("number2");
	  	number1.addEventListener("input", function() {number2.value = number1.value; });
	</script>

	<footer class="footer">
		<img src = "<c:url value='/images/runningman.png'/>">
	</footer>
</body>
</html>