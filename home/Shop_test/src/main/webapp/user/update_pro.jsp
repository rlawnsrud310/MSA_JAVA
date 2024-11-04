<%@page import="shop.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userDAO" class="shop.dao.UserRepository" />
<%

	// 회원 정보 수정 처리
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
	
    int result = userDAO.update(user);
    if (result > 0 ){
        response.sendRedirect("complete.jsp?msg=2");
    } else {
        response.sendRedirect("update.jsp");
    }

%>
