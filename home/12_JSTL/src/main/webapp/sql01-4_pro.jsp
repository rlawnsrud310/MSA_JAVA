<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.SortedMap"%>
<%@page import="org.apache.taglibs.standard.tag.common.sql.ResultImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Board"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - sql</title>
</head>
<body>

	
	<!-- 데이터 소스 -->
	<sql:setDataSource var="dataSource" 
		url="jdbc:mysql://localhost:3306/aloha?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false"
		driver="com.mysql.cj.jdbc.Driver"
		user="aloha"
		password="123456"
	/>
	
	<sql:query var="resultSet" dataSource="${dataSource}">
		SELECT * FROM board
		WHERE no = ?
		<sql:param value="${ param.no }" />
	</sql:query>
	
	
	<!-- resultSet -> Board 객체로 매핑 -->
	<jsp:useBean id="boardList" class="java.util.ArrayList"/>
	<c:forEach var="row" items="${resultSet.rows}">
		<%
			//Board board = new Board();
			//pageContext.setAttribute("board", board);
		%>
	
		<jsp:useBean id="board" class="DTO.Board">
			<%-- <jsp:setProperty property="변수명" name="객체" value="${ row.컬럼명}"/> --%>
			<jsp:setProperty property="no" name="board" value="${row.no }"/>
			<jsp:setProperty property="title" name="board" value="${row.title }"/>
			<jsp:setProperty property="writer" name="board" value="${row.writer }"/>
			<jsp:setProperty property="content" name="board" value="${row.content }"/>
			<jsp:setProperty property="regDate" name="board" value="${row.reg_date }"/>
		</jsp:useBean>
		<% boardList.add(board); %>
	</c:forEach>
	<h1>게시글 조회</h1>
	<h5><c:out value="${ board.no }번 게시글"></c:out></h5>
	
	<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>내용</th>
		<th>등록일자</th>
	</tr>
	
	<c:forEach var="board" items="${boardList}">
		<tr>
			<td> <c:out value="${ board.no }"></c:out></td>
			<td> <c:out value="${ board.title }"></c:out></td>
			<td> <c:out value="${ board.writer }"></c:out></td>
			<td> <c:out value="${ board.content }"></c:out></td>
			<td> <c:out value="${ board.regDate }"></c:out></td>
		</tr>
	</c:forEach>
	
</table>
</body>
</html>