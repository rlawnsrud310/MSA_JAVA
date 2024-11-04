<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shop</title>
	<jsp:include page="/layout/meta.jsp" /> <jsp:include page="/layout/link.jsp" />
</head>
<body>   
	<% 
	String root = request.getContextPath();
	String msg = request.getParameter("msg");
	System.out.println("login : " + msg);
	
	String loginId = (String) session.getAttribute("loginId");
	%>
	
	<jsp:include page="/layout/header.jsp" />
	<div class="px-4 py-5 my-5 text-center">
		<h1 class="display-5 fw-bold text-body-emphasis">회원 정보</h1>
		
	</div>
	<!-- 회원 가입/수정/탈퇴 완료 -->
	<div class="container mb-5">
		
		<!-- msg = 0 -->
		<% if(msg.equals("0")) { %>
			<h1 class="text-center"><%= loginId %>님 환영 합니다.</h1>
			<div class="btn-box d-flex justify-content-center p-5">
				<a href="<%= root %>/" class="btn btn-lg btn-primary">메인 화면</a>
			</div>
		<% } %>
		
		<!-- msg = 1 -->
		<% if(msg.equals("1")) { %>
			<h1 class="text-center">회원 가입이 완료되었습니다.</h1>
			<div class="btn-box d-flex justify-content-center p-5">
				<a href="<%= root %>/" class="btn btn-lg btn-primary">메인 화면</a>
			</div>
		<% } %>
		
		<!-- msg = 2 -->
		<% if(msg.equals("2")) { %>
			<h1 class="text-center">회원 정보가 수정되었습니다.</h1>
			<div class="btn-box d-flex justify-content-center p-5">
				<a href="<%= root %>/" class="btn btn-lg btn-primary">메인 화면</a>
			</div>
		<% } %>
		
		<!-- msg = 3 -->
		<% if(msg.equals("3")) { %>
			<h1 class="text-center">회원 정보가 삭제되었습니다.</h1>
			<div class="btn-box d-flex justify-content-center p-5">
				<a href="<%= root %>/" class="btn btn-lg btn-primary">메인 화면</a>
			</div>
		<% } %>
		
		<!-- msg = 4 -->
		<% if(msg.equals("4")) { %>
			<h1 class="text-center">쇼핑몰 사이트 입니다.</h1>
			<div class="btn-box d-flex justify-content-center p-5">
				<a href="<%= root %>/" class="btn btn-lg btn-primary">메인 화면</a>
			</div>
		<% } %>
		
	</div>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
</body>
</html>






