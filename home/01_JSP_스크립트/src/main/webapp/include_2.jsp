<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 - include</title>
</head>
<body>
<%
	String menu1 = "Home";
	String menu2 = "Board";
	String menu3 = "Gallery";
%>
	<!-- 액션태그 include -->
	<jsp:include page="header.jsp">
		<jsp:param value="Home" name="menu1"/>
		<jsp:param value="Board" name="menu2"/>
		<jsp:param value="Gallery" name="menu3"/>
	</jsp:include>
	<main>
		<div class="container">
			<h1>메인 영역</h1>
		</div>
	</main>
	<jsp:include page="fotter.jsp"></jsp:include>
	
</body>
</html>