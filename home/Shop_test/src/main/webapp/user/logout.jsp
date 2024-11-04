<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	// 자동 로그인, 토큰 쿠키 삭제
	
	// 세션 무효화
	session.removeAttribute("loginId");
	// 쿠키 전달
	
	String root = request.getContextPath();
	response.sendRedirect(root+"/index.jsp");
%>