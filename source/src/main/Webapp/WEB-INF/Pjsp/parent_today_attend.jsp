<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒の出席状況の確認・欠席登録</title>
</head>
<body>
    <header>
        <h1><a href="/A4/MenuServlet">C-Share</a></h1>
        <p><a href="/A4/LoginServlet">ログアウト</a></p>
        <ul>
			<li><a href="/A4/AttendanceServlet">出欠管理</a></li>
			<li><a href="/A4/GradeServlet">成績管理</a></li>
			<li><a href="/A4/MessageServlet">連絡管理</a></li>
			<li><a href="/A4/AccountRegistServlet">ユーザー一覧管理</a></li>
			<li><a href="/A4/LoadHistoryServlet">チャット</a></li>
		</ul>
    </header>

    <div>
        <!--日付表示(のちに変更必要)-->
        <p>○○月○○日</p>
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

    </footer>
</body>
</html>