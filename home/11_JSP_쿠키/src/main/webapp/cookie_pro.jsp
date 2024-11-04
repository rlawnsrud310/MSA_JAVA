<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String remembertId = request.getParameter("remember-id");
	
	// checkbox 체크 시, 기본값 on 으로 넘어온다.
	out.println("remembertId : " + remembertId + "<br>" );
	
	// 아이디 저장 체크 시, 쿠키 생성
	if( remembertId != null && remembertId.equals("on")) {
		// 쿠키 생성
		Cookie cookieId = new Cookie("username", username);
		Cookie cookieRememberId = new Cookie("remembertId", remembertId);
		response.addCookie(cookieId);
		response.addCookie(cookieRememberId);
		out.println("아이디를 쿠키에 저장하였습니다. <br>");
	}
	// 아이디 저장 미체크 시, 쿠키 삭제
	else{
		Cookie cookieId = new Cookie("username", username);
		Cookie cookieRememberId = new Cookie("remembertId", remembertId);
		// 쿠키 만료
		cookieId.setMaxAge(0);
		cookieRememberId.setMaxAge(0);
		response.addCookie(cookieId);
		response.addCookie(cookieRememberId);
		out.println("아이디를 쿠키에 삭제했습나더, <br>");
	}
%>
<a href="cookie.jsp">cookie.jsp</a>