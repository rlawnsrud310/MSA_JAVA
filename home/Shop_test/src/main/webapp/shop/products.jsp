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
	String keyword = request.getParameter("keyword");
	System.out.println("키워드는 : " + keyword);
	List<Product> productList =  productDAO.list();		
	List<Product> productList2 =  productDAO.list(keyword);		
	
	/* if( keyword == null ){
		System.out.println("키워드 별과 : true");	
	}
	else{
		System.out.println("키워드 별과 : flate");			
	} */
 	
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





	<jsp:include page="/layout/header.jsp" />





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
        <c:set var="productList2" value="<%= productList2 %>"></c:set>
        
        <!-- keyword 있는지 없는지 조건문 -->
		<%  if(keyword != null  || !keyword.equals("") ) { %>
        <!-- 반복 돌려야함 -->
        <c:forEach var="product" items="${productList2}" varStatus="status">
            <!-- 각 카드에 col-md-6 클래스 적용 -->
            <div class="col-md-6 col-xl-4 col-xxl-3">
                <div class="card p-3">
                    <div class="img-content">
                        <img src="img?id=${product.productId}" class="w-100 p-2" />
                    </div>
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
        <!-- keyword 없을때 -->
		<%  }  else {	%>
		
		<c:forEach var="product" items="${productList}" varStatus="status">
            <!-- 각 카드에 col-md-6 클래스 적용 -->
            <div class="col-md-6 col-xl-4 col-xxl-3">
                <div class="card p-3">
                    <div class="img-content">
                        <img src="img?id=${product.productId}" class="w-100 p-2" />
                    </div>
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
        <% } %>
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
