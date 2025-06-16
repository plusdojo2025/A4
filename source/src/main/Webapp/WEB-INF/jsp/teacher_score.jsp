<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生用成績閲覧・登録・更新・削除</title>
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
		<!-- 成績登録ボタン -->
		<input type="submit" name="regist" value="成績登録">
	</div>

	<div>
		<!-- 生徒名簿の表示 -->
		<h2>生徒名簿</h2>
		<ul>
			<c:forEach var="student" items="${studentList}" >
				<li>
                    <!--サーブレットの変更あるかも-->
                    <a href="/A4/GradeServlet?studentId=${student.id}">
                        ${student.name}
                    </a>
                </li>
			</c:forEach>
		</ul>
	</div>

    <!--上記のidをもとにサーブレットで特定の生徒の成績情報をGradeServletから持ってきて、Requestスコープに"selectedStudent"の名前で保存する必要あり。-->
    <div>
        <!--成績表示-->
        <c:if test="${not empty selectedStudent}">
            <h2>${selectedStudent.name} さんの成績</h2>

            <c:forEach var="score" items="${selectedStudent.scores}">
                <!--formタグの位置変更あるかも-->
                <form method="POST" action="/A4/GradeServlet" id="form">
                    <!--何学期かを表示する部分-->
                    <button type="button" onclick="toggleScore('${score.term}')">↓ ${score.term}</button>
                    <!--このコードで成績を表示するか否かを決める(ON&OFはJavaScriptで設定)-->
                    <div id="score-${score.term}" style="display: none;">
                        <!--テスト名の表示-->
                        <p>${score.testName}テスト</p>
                        <!--選択した生徒の成績の表示-->
                        <table>
                            <!--表形式-->
                            <tr>
                                <th>国語</th>
                                <th>数学</th>
                                <th>理科</th>
                                <th>社会</th>
                                <th>英語</th>
                                <th>総合</th>
                            </tr>
                            <tr>
                                <td>${score.japanese}</td>
                                <td>${score.math}</td>
                                <td>${score.science}</td>
                                <td>${score.social}</td>
                                <td>${score.english}</td>
                                <td>${score.sum}</td>
                            </tr>
                            <tr>
                                <td>${score.averageJapanese}</td>
                                <td>${score.averageMath}</td>
                                <td>${score.averageScience}</td>
                                <td>${score.averageSocial}</td>
                                <td>${score.averageEnglish}</td>
                                <td>${score.averageSum}</td> 
                            </tr>
                            
                        </table>
                        <!--更新・削除ボタン-->
                        <p class ="submit">
                            <input type="submit" name="update" value="更新">
                            <input type="submit" name="delete" value="削除"><br>
                            <span id='output'></span>
                        </p>
                    </div>
                </form>
            </c:forEach>
        </c:if>
    </div>
	<footer>
	
	</footer>
</body>
</html>

