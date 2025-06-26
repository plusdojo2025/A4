<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
		  // 最初にアクセスされたら LoginServlet にリダイレクト
		  response.sendRedirect(request.getContextPath() + "/TeacherLoginServlet");
		%>
</body>
</html>