<%@page import="shop.dto.User"%>
<%@page import="shop.dao.UserRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userDAO" class="shop.dao.UserRepository" />

<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	String id = (String) session.getAttribute("loginId");
	out.println(id);    
	
	// 삭제진행
	int result = userDAO.delete(id);
	
	// 삭제 성공
	if( result > 0){
		session.removeAttribute("loginId");
		response.sendRedirect("complete.jsp?msg=3");
	}
%>
