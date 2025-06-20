<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生専用ユーザー登録</title>
</head>
<body>
<header>
		<h1><a href="/A4/TeacherMenuServlet">C-Share</a></h1>
		<label><a href="/A4/TeacherLoginServlet">ログアウト</a></label>
		<ul>
			<li><a href="/A4/TeacherAttendanceServlet">出欠管理</a></li>
			<li><a href="/A4/TeacherGradeServlet">成績管理</a></li>
			<li><a href="/A4/TeacherMessageServlet"></a>連絡管理</li>
			<li><a href="/A4/TeacherAccountRegistServlet"></a>ユーザー一覧</li>
			<li><a href="/A4/SoServlet">チャット</a></li>
		</ul>
</header>
	
	<main>
	<form method="POST" action="/A4/TeacherAccountRegistServlet">
	</form>
		<table>
			  <!--  生徒 -->
              <tr>
              <td>
                <label>生徒<br>
                </label>
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
                <label>保護者<br>
                </label>
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
                <input type="submit" id="register" name="submit" value="登録">
                <span id="error_message"></span>
              </td>
              </tr>
			</table>
              <!--  学籍番号の共有 -->
              <script>
  				var number1 = document.getElementById("number1");
  				var number2 = document.getElementById("number2");
  				number1.addEventListener("input", function() {number2.value = number1.value; });
			  </script>
	</main>
</body>
</html>