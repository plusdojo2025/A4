<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>先生用成績閲覧・更新・削除</title>
</head>
<body>
	<header>
		<h1><a href="/A4/MenuServlet">C-Share</a></h1>
        <label><a href="/A4/LoginServlet">ログアウト</a></label>
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
                   	<input type="hidden" name="number" value="${student.number}">       	
            		<button type="button" onclick="toggleScore('${student.name}')">↓ ${student.name}</button>
                    
                </li>
			</c:forEach>
		</ul>
	</div>

    <!--上記のidをもとにサーブレットで特定の生徒の成績情報をGradeServletから持ってきて、Requestスコープに"selectedStudent"の名前で保存する必要あり。-->
    <div>
        <!--成績表示-->
        
        <c:if test="${not empty selectedStudent}">
            <h2><input name = sName ${selectedStudent.name} >さんの成績</h2>
			<c:forEach var="score" items="${score}">
                    <!--何学期かを表示する部分-->
                    <button type="button" onclick="toggleScore('${score.term}')">↓ ${score.term}</button>
           			
                    <!--このコードで成績を表示するか否かを決める(ON&OFはJavaScriptで設定)-->
                    <div id="score-${score.term}" style="display: none;">
                    
                        <!--テスト名の表示-->
                        <p>${score.testName}テスト</p>
                        <form method="POST" action="/A4/GradeServlet" id="form">
                        <input type="hidden" name="id" value="${score.id}">
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
                                <td><input type = text name = jap value="${score.japanese}"></td>
                                <td><input type = text name = mat value="${score.math}"></td>
                                <td><input type = text name = sci value="${score.science}"></td>
                                <td><input type = text name = soc value="${score.social}"></td>
                                <td><input type = text name = eng value="${score.english}"></td>
                                <td><input type = text name = sum value="${score.sum}"></td>
                            </tr>
                            <tr>
                                <td><input type = text name = ajap value="${score.averageJapanese}"></td>
                                <td><input type = text name = amat value="${score.averageMath}"></td>
                                <td><input type = text name = asci value="${score.averageScience}"></td>
                                <td><input type = text name = asoc value="${score.averageSocial}"></td>
                                <td><input type = text name = aeng value="${score.averageEnglish}"></td>
                                <td><input type = text name = asum value="${score.averageSum}"></td> 
                            </tr>
                            
                        </table>
                        <!--更新・削除ボタン-->
                        <p class ="submit">
                            <input type="submit" name="update" value="更新">
                            <input type="submit" name="delete" value="削除"><br>
                            <span id='output'></span>
                        </p>
                        </form>
                    </div>      
            </c:forEach>
        </c:if>
        
    </div>
	<footer>
	
	</footer>
</body>
</html>

