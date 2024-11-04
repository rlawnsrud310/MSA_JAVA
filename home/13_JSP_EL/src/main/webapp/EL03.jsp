<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL - session</title>
</head>
<body>
	<h1>sessionScope El 내장 객체</h1>
	<%
		session.setAttribute("username", "joeun");
	%>	
	
	<h1>로그인된 아이디 : ${sessionScope.username  }</h1>
	<a href="EL03-1.jsp">EL03-1</a>
	<a href="EL03-2.jsp">EL03-2</a>
</body>
</html>