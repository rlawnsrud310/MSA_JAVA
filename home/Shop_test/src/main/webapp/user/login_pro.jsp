<!-- 로그인 처리 -->
<%@page import="java.util.UUID"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="shop.dto.User"%>
<%@page import="shop.dao.UserRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	UserRepository userDAO = new  UserRepository();
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	
	User loginUser = userDAO.login(id, pw);
	
	
	
	if(loginUser.getId() == null){
		// 로그인 실패
		response.sendRedirect("login.jsp?error=0");
		return;
	}
	// 로그인 성공
	// - 세션에 아이디 등록
	session.setAttribute("loginId", loginUser.getId());
	session.setAttribute("UserId", loginUser.getId());
	// 아이디 저장
	String rememberId = request.getParameter("remember-id");
	Cookie cookieRememberId = new Cookie("rememberId", "");
	/* Cookie cookieusername = new Cookie("username", ""); */
	
	System.out.println("rememberId : " + rememberId);
	System.out.println("세션 체크 : " + (String) session.getAttribute("loginId"));
	// 아이디 저장 체크
	if( rememberId != null && rememberId.equals("on")){
		// 쿠키 생성
		cookieRememberId.setValue(URLEncoder.encode(rememberId,"UTF-8"));
	}
	// 아이디 저장 체크 해제
	else{
			// 쿠키 삭제
			session.setAttribute("UserId", "");
			cookieRememberId.setMaxAge(0);
	}
	
	// 자동 로그인
	
	// 쿠키 전달
	response.addCookie(cookieRememberId);
	
	// 로그인 성공 페이지로 이동
	response.sendRedirect("complete.jsp?msg=0");		

%>





