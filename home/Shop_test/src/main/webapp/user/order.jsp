<%@page import="shop.dao.OrderRepository"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="shop.dao.UserRepository"%>
<%@page import="shop.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String root = request.getContextPath();
	String userId = (String) session.getAttribute("loginId");
	OrderRepository orderDAO = new OrderRepository();
	List<Product> orderlist = orderDAO.list(userId);
%>






<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shop🛒 - ALOHA CLASS🌴</title>
<!-- 파비콘 -->
<link rel="icon" href="/static/img/logo.png" type="image/x-icon">
<!-- 썸네일 이미지 설정 -->
<meta property="og:image" content="https://i.imgur.com/yiTQ3EV.jpg">
<!-- 웹 페이지 설명 (선택 사항) -->
<meta property="og:description" content="ALOHA CLASS🌴 - 쇼핑몰 프로젝트">
<!-- 웹 페이지 URL -->
<meta property="og:url" content="">
<!-- 웹 페이지 제목 -->
<meta name="title" content="Shop🛒 - ALOHA CLASS🌴">
<meta property="og:title" content="Shop🛒 - ALOHA CLASS🌴">
<!-- 웹 페이지 타입 (웹사이트, 기사, 제품 등) -->
<meta property="og:type" content="website">
<!-- 검색어 -->
<meta name="keywords" content="쇼핑몰 프로젝트, 자바 웹개발, ALOHA CLASS, 알로하 클래스">
<meta name="robots" content="index, follow">
<!-- 사이트 맵 -->
<link rel="sitemap" href="/static/sitemap.xml">




	
    
<!-- bootstrap lib -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<!-- Noto Sans font -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Noto+Sans:400,700&display=swap">

<!-- material design icon -->
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="/static/css/style.css" rel="stylesheet" />
</head>
<body>   

<jsp:include page="/layout/header.jsp" />



	
	<div class="row m-0 mypage">
		<div class="sidebar border border-right col-md-3 col-lg-2 p-0 bg-body-tertiary">
			<div class="d-flex flex-column flex-shrink-0 p-3 bg-body-tertiary">
			    <ul class="nav nav-pills flex-column mb-auto">
			      <!-- 로그인 시 -->
			      
			      <li class="nav-item">
			        <a href="/user/index.jsp" class="nav-link link-body-emphasis">
			          마이 페이지
			        </a>
			      </li>
			      <li class="nav-item">
			        <a href="/user/update.jsp" class="nav-link link-body-emphasis">
			          회원정보 수정
			        </a>
			      </li>
			      
			      
			      <li>
			        <a href="#" class="nav-link active" aria-current="page" >
			          주문내역
			        </a>
			      </li>
			    </ul>
			    <hr>
			  </div>
		</div>
		
		<div class="col-md-9 ms-sm-auto col-lg-10 p-0 m-0">
			<div class="px-4 py-3 my-3 text-center">
				<h1 class="display-5 fw-bold text-body-emphasis">주문 내역</h1>
				<div class="col-lg-6 mx-auto">
					
				</div>
			</div>
			
			<!-- 주문 내역 영역 -->
			<div class="container shop m-auto mb-5">
					<form action="/user/order_pro.jsp" method="post">
					
					</form>
				
				<!-- 주문 내역 목록 -->
				<table class="table table-striped table-hover table-bordered text-center align-middle">
					<thead>
						<tr class="table-primary">
							<th>주문번호</th>
							<th>상품</th>
							<th>가격</th>
							<th>수량</th>
							<th>소계</th>
							<th>비고</th>
						</tr>
					</thead>
					<tbody>
						<!-- 반복할꺼 -->
						<%
						int sum = 0;
						for(Product order : orderlist) {
						%>
						<tr>
							<td><%= order.getOrderNo()%></td>			
							<td>못했음</td>			
							<td>못했음</td>			
							<td>못햇음</td>			
							<td><%= order.getUnitPrice() %></td>			
							<td></td>			
						</tr>
						<% 
						sum += order.getUnitPrice();
						}
						%>
						<!-- 반복끝  -->
					</tbody>
					<tfoot>
						
						<tr>
							<td></td>
							<td></td>
							<td>총액</td>
							<td id="cart-sum"><%= sum %></td>
							<td></td>
						</tr>
						
					</tfoot>
				</table>
				
				
			</div>
			
			
<footer class="container p-5">
	<p>copyright Shop</p>
</footer>
		</div>
	</div>
	
	
	
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<!-- <script src="../static/js/validation.js"></script> -->			<!-- 상대경로 -->
	<!-- 절대경로 -->
<script src="/static/js/validation.js"></script>





	
	

	<script>
		
		let form = document.updateForm
		
		// 성별 선택
		let tempGender = document.getElementById('temp-gender')
		let radioFemale = document.getElementById('gender-female')
		let radioMale = document.getElementById('gender-male')
		// alert(tempGender.value)
		if( tempGender.value == '남' )		radioMale.checked = true
		if( tempGender.value == '여' )		radioFemale.checked = true
		
		
		// 생일 월 (select) 선택
		let tempMonth = document.getElementById('temp-month')
		let selectMonth = form.month
		selectMonth.value = tempMonth.value
		
		
		// 메일 도메인 (select) 선택
		let tempEmail2 = document.getElementById('temp-email2')
		let selectEmail2 = form.email2
		selectEmail2.value = tempEmail2.value
		
		
		// 탈퇴 체크
		function alertDel() {

			let form = document.updateForm

			let check = confirm('정말 탈퇴하시겠습니까?')

			if( check ) {
				form.action = 'delete.jsp'
				form.submit()
			}

		}
	
	</script>
</body>
</html>















