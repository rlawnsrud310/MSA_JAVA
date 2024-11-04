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
		String username = request.getParameter("username");
		String passowrd = request.getParameter("password");
	%>
	<p>아이디		: <%= username %>
	<p>비밀번호	: <%= passowrd %>

</body>
</html>