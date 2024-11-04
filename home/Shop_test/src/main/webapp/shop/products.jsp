<%@page import="shop.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="shop.dao.ProductRepository"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	String root = request.getContextPath(); 
	ProductRepository productDAO = new  ProductRepository();
	List<Product> productList =  productDAO.list();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">



<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shop🛒 - ALOHA CLASS🌴</title>
<!-- 파비콘 -->
<link rel="icon" href="<%= root %>/static/img/logo.png" type="image/x-icon">
<!-- 썸네일 이미지 설정 -->
<meta property="og:image" content="https://i.imgur.com/yiTQ3EV.jpg">
<!-- 웹 페이지 설명 (선택 사항) -->
<meta property="og:description" content="ALOHA CLASS🌴 - 쇼핑몰 프로젝트">
<!-- 웹 페이지 URL -->
<meta property="og:url" content="/Shop">
<!-- 웹 페이지 제목 -->
<meta name="title" content="Shop🛒 - ALOHA CLASS🌴">
<meta property="og:title" content="Shop🛒 - ALOHA CLASS🌴">
<!-- 웹 페이지 타입 (웹사이트, 기사, 제품 등) -->
<meta property="og:type" content="website">
<!-- 검색어 -->
<meta name="keywords" content="쇼핑몰 프로젝트, 자바 웹개발, ALOHA CLASS, 알로하 클래스">
<meta name="robots" content="index, follow">
<!-- 사이트 맵 -->
<link rel="sitemap" href="<%= root %>/static/sitemap.xml">






<!-- bootstrap lib -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">

<!-- Noto Sans font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Noto+Sans:400,700&display=swap">

<!-- material design icon -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="<%= root %>/static/css/style.css" rel="stylesheet" />
</head>
<body>





	<nav class="navbar bg-dark navbar-expand-lg bg-body-tertiary"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="<%= root %>/">Home</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%= root %>/shop/products.jsp">Product</a></li>
				</ul>
				<ul class="navbar-nav d-flex align-items-center px-3">

					<!-- 로그인 시 -->
					<!--         <li class="nav-item"> -->

					<!--         </li> -->
					<li class="nav-item">
						<div class="dropdown">
							<a href="#"
								class="d-flex align-items-center link-body-emphasis text-decoration-none dropdown-toggle"
								data-bs-toggle="dropdown" aria-expanded="false"> <img
								src="https://github.com/mdo.png" alt="" width="32" height="32"
								class="rounded-circle me-2"> <strong>123</strong>
							</a>
							<ul class="dropdown-menu text-small shadow">
								<li><a class="dropdown-item" href="<%= root %>/user/index.jsp">마이
										페이지</a></li>
								<li><a class="dropdown-item" href="<%= root %>/user/update.jsp">회원정보
										수정</a></li>
								<li><a class="dropdown-item" href="<%= root %>/user/order.jsp">주문내역</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="<%= root %>/user/logout.jsp">로그아웃</a></li>
							</ul>
						</div>
					</li>


					<!--         <li class="nav-item"> -->

					<!--         </li> -->

					<li class="nav-item"><a class="nav-link position-relative"
						aria-current="page" href="<%= root %>/shop/cart.jsp"> <i
							class="material-symbols-outlined">shopping_bag</i> <span
							class="cart-count">0</span>
					</a></li>
				</ul>
				<form class="d-flex" role="search" action="<%= root %>/shop/products.jsp"
					method="get">
					<input class="form-control me-2" type="search" name="keyword"
						placeholder="Search" aria-label="Search" value="">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>





	<div class="px-4 py-5 my-5 text-center">
		<h1 class="display-5 fw-bold text-body-emphasis">상품 목록</h1>
		<div class="col-lg-6 mx-auto">
			<p class="lead mb-4">쇼핑몰 상품 목록 입니다.</p>
			<div class="d-grid gap-2 d-sm-flex justify-content-sm-center">

				<a href="<%= root %>/shop/add.jsp"
					class="btn btn-primary btn-lg px-4 gap-3">상품 등록</a> <a
					href="<%= root %>/shop/editProducts.jsp"
					class="btn btn-success btn-lg px-4 gap-3">상품 편집</a> <a
					href="<%= root %>/shop/cart.jsp"
					class="btn btn-warning btn-lg px-4 gap-3">장바구니</a>

			</div>
		</div>
	</div>

	<div class="container mb-5">
    <div class="row gy-4">
        <c:set var="productList" value="<%= productList %>"></c:set>
        
        <!-- 반복 돌려야함 -->
        <c:forEach var="product" items="${productList}" varStatus="status">
            <!-- 각 카드에 col-md-6 클래스 적용 -->
            <div class="col-md-6 col-xl-4 col-xxl-3">
                <div class="card p-3">
                    이미지 영역
                    <div class="img-content">
                        <img src="img?id=${product.productId}" class="w-100 p-2" />
                    </div>
                    컨텐츠 영역
                    <div class="content">
                        <h3 class="text-center">${product.name}</h3>
                        <p>${product.description}</p>
                        <p class="text-end price">₩ ${product.unitPrice}</p>
                        <p class="d-flex justify-content-between">
                            <a href="./cart_pro.jsp?id=P100001" class="btn btn-outline-primary">
                                <i class="material-symbols-outlined">shopping_bag</i>
                            </a> 
                            <a href="./product.jsp?id=${product.productId }" class="btn btn-outline-primary">
                                상세 정보
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
	

	<footer class="container p-5">
		<p>copyright Shop</p>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
	<!-- <script src="../static/js/validation.js"></script> -->
	<!-- 상대경로 -->
	<!-- 절대경로 -->
	<script src="<%= root %>/static/js/validation.js"></script>

</body>
</html>
