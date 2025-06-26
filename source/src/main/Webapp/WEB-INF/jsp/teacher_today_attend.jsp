<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>先生用出欠管理</title>
    <link rel="stylesheet" href="<c:url value='/css/common.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/teacher.css'/>">
</head>
<body>
    <header>
        <label class="out">
            <a href="<c:url value='TeacherLogoutServlet'/>">
                <img src="images/out.png" width="50px" height="50px">
            </a>
        </label>
        <div class="logo">
            <a href="<c:url value='/TeacherMenuServlet'/>">
                <img src="<c:url value='/images/cshare.png'/>" width="300px" height="122px">
            </a>
        </div>
        <nav class="burner">
            <ul>
                <li><a href="<c:url value='/TeacherAttendanceServlet'/>">出欠管理</a></li>
                <li><a href="<c:url value='/TeacherGradeServlet'/>" class="highlight">成績管理</a></li>
                <li><a href="<c:url value='/TeacherMessageServlet'/>" class="highlight">連絡管理</a></li>
                <li><a href="<c:url value='/OtherAccountRegistServlet'/>" class="highlight">ユーザー一覧管理</a></li>
                
            </ul>
        </nav>
    </header>

    <form>
        <div class="attend">
            <!--日付表示-->
            <a href="<c:url value='/TeacherDisplayCalenderServlet'/>">
                <img src="images/calender.png" width="70px" height="70px">
            </a>
            
        </div>
    </form>
    <div class="attend2">
    	<h2>（${today}）</h2>
        <table>
            <thead>
                <tr>
                    <th>名前</th>
                    <th>出欠</th>
                    <th>操作</th>
                </tr>
            </thead>
   			<tbody>
   			<c:forEach var="e" items="${attendanceList}">
				<form method="POST" action="/TeacherAttendanceServlet" class="form-flex">
               		<tr>
                 
                     <td class="name-label">${e.sName}</td>
                     <td>
                         <div class="selectbox-5">
                             <select name="attendance">
                                 <option value="Present" <c:if test="${e.status == 'Present'}">selected</c:if>>出席</option>
                                 <option value="Absent" <c:if test="${e.status == 'Absent'}">selected</c:if>>欠席</option>
                                 <option value="Late" <c:if test="${e.status == 'Late'}">selected</c:if>>遅刻</option>
                                 <option value="Early" <c:if test="${e.status == 'Early'}">selected</c:if>>早退</option>
                             </select>
                         </div>
                     </td>
                     <td>
                         <input type="submit" value="更新" class="submit-btn">
                     </td>
                 
               		</tr>
               </form>
           	</c:forEach>
   		</tbody>
        </table>
    </div>

    <footer class="footer">
        <img src="<c:url value='/images/runningman.png'/>">
    </footer>
</body>
</html>