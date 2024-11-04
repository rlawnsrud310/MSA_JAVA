<!-- 
	회원 가입 처리
 -->
<%@page import="shop.dao.UserRepository"%>
<%@page import="shop.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	
	String userId = request.getParameter("id");
	String password = request.getParameter("pw");
	String password_config = request.getParameter("pw_confirm");
	String userName = request.getParameter("name");
	String gender = request.getParameter("gender");
	// 생일
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	String birth = year+"-"+month+"-"+day;
	
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	String email = email1 + "@" + email2;
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	
/* 	System.out.println(userId);
	System.out.println(password);
	System.out.println(password_config);
	System.out.println(userName);
	System.out.println(gender);
	System.out.println(birth);
	System.out.println(email);
	System.out.println(phone);
	System.out.println(address); */
	
	if(!password.equals(password_config)){
		System.out.println("비번확인실패");
		response.sendRedirect("join.jsp?error=0");
		return;
	}
	
	User user = User.builder()
					.id(userId)
					.password(password)
					.name(userName)
					.gender(gender)
					.birth(birth)
					.mail(email)
					.phone(phone)
					.address(address)
					.build();
	
	
	
	
	UserRepository userDAO = new UserRepository();
	int result = userDAO.insert(user);
	
	if(result > 0){
		response.sendRedirect("complete.jsp?msg=1");
	}
	else{
		response.sendRedirect("join.jsp?error=0");
	}
	
	
%>
    
    

    
    
    
    
    
    