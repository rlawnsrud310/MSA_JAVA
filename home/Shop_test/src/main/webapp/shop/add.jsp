<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String root = request.getContextPath(); %>



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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<!-- Noto Sans font -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Noto+Sans:400,700&display=swap">

<!-- material design icon -->
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="<%= root %>/static/css/style.css" rel="stylesheet" />
</head>
<body>  
	


    

<nav class="navbar bg-dark navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="<%= root %>/">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%= root %>/shop/products.jsp">Product</a>
        </li>
      </ul>
       <ul class="navbar-nav d-flex align-items-center px-3">
       	
        <!-- 로그인 시 -->
<!--         <li class="nav-item"> -->

<!--         </li> -->
        <li class="nav-item">
        <div class="dropdown">
	      <a href="#" class="d-flex align-items-center link-body-emphasis text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
	        <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
	        <strong>123</strong>
	      </a>
	      <ul class="dropdown-menu text-small shadow">
	        <li><a class="dropdown-item" href="<%= root %>/user/index.jsp">마이 페이지</a></li>
	        <li><a class="dropdown-item" href="<%= root %>/user/update.jsp">회원정보 수정</a></li>
	        <li><a class="dropdown-item" href="<%= root %>/user/order.jsp">주문내역</a></li>
	        <li><hr class="dropdown-divider"></li>
	        <li><a class="dropdown-item" href="<%= root %>/user/logout.jsp">로그아웃</a></li>
	      </ul>
	    </div>
        </li>
        
        
<!--         <li class="nav-item"> -->

<!--         </li> -->
        
        <li class="nav-item">
	        <a class="nav-link position-relative" aria-current="page" href="<%= root %>/shop/cart.jsp">
	        	<i class="material-symbols-outlined">shopping_bag</i>
	        	<span class="cart-count">0</span>
	        </a>
        </li>
      </ul>
      <form class="d-flex" role="search" action="<%= root %>/shop/products.jsp" method="get">
        <input class="form-control me-2" type="search" name="keyword" placeholder="Search" aria-label="Search"
        		value="">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>





	<div class="px-4 py-5 my-5 text-center">
		<h1 class="display-5 fw-bold text-body-emphasis">상품 등록</h1>
		<div class="col-lg-6 mx-auto">
			<p class="lead mb-4">Shop 쇼핑몰 입니다.</p>
		</div>
	</div>
	
	<!-- 상품 등록 입력 화면 -->
	<div class="container shop">
		<!-- [NEW] enctype 추가 -->
		<form name="product" action="./add_pro.jsp" method="post">
			
			<!-- [NEW] 파일 입력 추가 -->
			<div class="input-group mb-3 row">
				<label class="input-group-text col-md-2" id="">상품 이미지</label>
				<input type="file" class="form-control col-md-10" name="file">
			</div>	
		
			<div class="input-group mb-3 row">
				<label class="input-group-text col-md-2" id="">상품 코드</label>
				<input type="text" class="form-control col-md-10" name="productId">
			</div>
			
			<div class="input-group mb-3 row">
				<label class="input-group-text col-md-2" id="">상품명</label>
				<input type="text" class="form-control col-md-10" name="name">
			</div>
			
			<div class="input-group mb-3 row">
				<label class="input-group-text col-md-2" id="">가격</label>
				<input type="number" class="form-control col-md-10" name="unitPrice">
			</div>
			<div class="input-group mb-3 row">
				<label class="input-group-text w-100" id="">상세 정보</label>
				<textarea class="form-control" name="description" 
						  style="height: 200px !important;"></textarea>
			</div>
			<div class="input-group mb-3 row">
				<label class="input-group-text col-md-2" id="">제조사</label>
				<input type="text" class="form-control col-md-10" name="manufacturer">
			</div>
			<div class="input-group mb-3 row">
				<label class="input-group-text col-md-2" id="">분류</label>
				<input type="text" class="form-control col-md-10" name="category">
			</div>
			<div class="input-group mb-3 row">
				<label class="input-group-text col-md-2" id="">재고 수</label>
				<input type="number" class="form-control col-md-10" name="unitsInStock">
			</div>
			<div class="input-group mb-3 row">
				<div class="col-md-2 p-0">
					<label class="input-group-text" id="">상태</label>
				</div>
				<div class="col-md-10 d-flex align-items-center">
					<div class="radio-box d-flex">
						<div class="radio-item mx-5">
							<input type="radio" class="form-check-input" name="condition" value="NEW" id="condition-new"> 
							<label for="condition-new">신규 제품</label>
						</div>
						
						<div class="radio-item mx-5">
							<input type="radio" class="form-check-input " name="condition" value="OLD" id="condition-old"> 
							<label for="condition-old">중고 제품</label>
						</div>
						
						<div class="radio-item mx-5">
							<input type="radio" class="form-check-input " name="condition" value="RE" id="condition-re"> 
							<label for="condition-re">재생 제품</label>
						</div>
					</div>
				</div>
			</div>
			
			<div class="d-flex justify-content-between mt-5 mb-5">
				<a href="./products.jsp" class="btn btn-lg btn-secondary">목록</a>
				<input type="submit" class="btn btn-lg btn-primary" value="등록" />
			</div>
		
		</form> 
	
	</div>
	
	
	
<footer class="container p-5">
	<p>copyright Shop</p>
</footer>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<!-- <script src="../static/js/validation.js"></script> -->			<!-- 상대경로 -->
	<!-- 절대경로 -->
<script src="<%= root %>/static/js/validation.js"></script>





	
</body>
</html>













