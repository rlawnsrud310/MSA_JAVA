<%@page import="shop.dto.Product"%>
<%@page import="shop.dao.ProductRepository"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String productId = request.getParameter("id");
String root = request.getContextPath(); 
ProductRepository productDAO = new  ProductRepository();
Product product =  productDAO.getProductById(productId);

String condition = product.getCondition();
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




	<div class="px-4 py-5 my-5 text-center">
		<h1 class="display-5 fw-bold text-body-emphasis">상품 정보</h1>
		<div class="col-lg-6 mx-auto">
			<p class="lead mb-4">Shop 쇼핑몰 입니다.</p>
			<div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
				<a href="./products.jsp?keyword=" class="btn btn-primary btn-lg px-4 gap-3">상품목록</a>
			</div>
		</div>
	</div>
	
	<!-- 상품 정보 영역 -->
	
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<!-- [NEW] 썸네일 이미지 요청하기 추가 -->
				<img src="img?id=<%= product.getProductId() %>" class="w-100 p-2" />
			</div>
			<div class="col-md-6">
				<h3 class="mb-5"><%= product.getName() %></h3>
			 	<table class="table">
			 		<colgroup>
			 			<col width="120px" />
			 			<col />
			 		</colgroup>
			 		<tr>
			 			<td>상품ID :</td>
			 			<td><%= product.getProductId() %></td>
			 		</tr>
			 		<tr>
			 			<td>제조사 :</td>
			 			<td><%= product.getManufacturer() %></td>
			 		</tr>
			 		<tr>
			 			<td>분류 :</td>
			 			<td><%= product.getCategory() %></td>
			 		</tr>
			 		<tr>
			 			<td>상태 :</td>
			 			<td><%= product.getCondition() %></td>
			 		</tr>
			 		<tr>
			 			<td>재고 수 :</td>
			 			<td><%= product.getUnitsInStock() %></td>
			 		</tr>
			 		<tr>
			 			<td>가격 :</td>
			 			<td><%= product.getUnitPrice() %></td>
			 		</tr>
				</table>
				<div class="mt-4">
					<form name="addForm" action="./addCart.jsp" method="post">
						<input type="hidden" name="id" value="P100001" />
						<div class="btn-box d-flex justify-content-end ">
							<!-- [NEW] 장바구니 버튼 추가 -->
							<a href="./cart.jsp" class="btn btn-lg btn-warning mx-3">장바구니</a>
							
							<!-- 페이지 이동 막기 :  href="javascript:;" -->			
							<a href="javascript:;" class="btn btn-lg btn-success mx-3" onclick="addToCart()">주문하기</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	
	
<footer class="container p-5">
	<p>copyright Shop</p>
</footer>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<!-- <script src="../static/js/validation.js"></script> -->			<!-- 상대경로 -->
	<!-- 절대경로 -->
<script src="/static/js/validation.js"></script>





	<script>
	
		// 장바구니 추가
		function addToCart() {
			if( confirm("상품을 장바구니에 추가하시겠습니까?") ) {
				document.addForm.submit()
			} else {
				document.addForm.reset()
			}
			
		}
		
	</script>
</body>
</html>






















