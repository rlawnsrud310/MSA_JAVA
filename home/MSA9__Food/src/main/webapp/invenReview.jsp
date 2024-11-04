<%@page import="food.DTO.Review"%>
<%@page import="food.Service.ReviewServiceImpl"%>
<%@page import="food.Service.ReviewService"%>
<%@page import="java.util.List"%>
<%@page import="com.alohaclass.jdbc.dto.PageInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();
ReviewService reviewService = new ReviewServiceImpl();

// 페이지 번호 설정
String pageStr = request.getParameter("page");
int pageNo = 1;
if (pageStr != null) {
    pageNo = Integer.parseInt(pageStr);
}

// 서비스 호출
PageInfo<Review> pageInfo = reviewService.page(pageNo);
List<Review> reviewList = pageInfo.getList();
%>
<c:set var="pageInfo" value="<%=pageInfo%>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/invenBrand1.css">
    <link rel="stylesheet" href="./css/invenBrand2.css">

    <style>
        a, button, input, select, h1, h2, h3, h4, h5, * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            border: none;
            text-decoration: none;
            background: none;
            -webkit-font-smoothing: antialiased;
        }
        menu, ol, ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        .pagination {
            display: flex;
            justify-content: center;
        }
        .pagination a {
            margin: 0 5px;
            padding: 10px;
            border: 1px solid #ccc;
            color: #000;
        }
        .pagination a.active {
            background-color: #007bff;
            color: white;
        }
        .pagination a:hover {
            background-color: #ddd;
        }
    </style>

    <title>Document</title>
</head>
<body>
    <div class="div">
        <div class="sidebar">
            <button class="user" onclick="location.href='./admin/user/delete.jsp'">
                <div class="user2">User</div>
                <img class="frame" src="./invenBrand_img/frame0.svg" />
            </button>
            <div class="review">
                <div class="review2">Review</div>
                <img class="frame2" src="./invenBrand_img/frame1.svg" />
            </div>
            <div class="restaurant">
                <div class="restaurant2">Restaurant</div>
                <img class="frame3" src="./invenBrand_img/frame2.svg" />
            </div>
            <div class="restaurant3">
                <div class="reservation">Reservation</div>
                <img class="frame4" src="./invenBrand_img/frame3.svg" />
            </div>
            <div class="div2">사이트명</div>
            <img class="_1" src="./invenBrand_img/_10.png" />
        </div>
        <div class="review-list">
            <div class="div3">
	            <div class="pagenumber">
	                <!-- 페이지네이션 -->
	                <div class="pagination">
	                    <a href="?page=${pageInfo.page.prev}" class="prev">&laquo;</a>
	                    <c:forEach var="page" begin="${pageInfo.page.start}" end="${pageInfo.page.end}">
	                        <a href="?page=${page}" class="${page == pageInfo.page.page ? 'active' : ''}">${page}</a>
	                    </c:forEach>
	                    <a href="?page=${pageInfo.page.next}" class="next">&raquo;</a>
	                </div>
	            </div>
                <div class="div4">작성자</div>
                <div class="div5">매장명</div>
                <div class="div6">내용</div>
                <div class="div7">작성일자</div>
                <div class="div8">평점</div>
                <div class="div9">삭제</div>
                <img class="vector-1" src="./invenBrand_img/vector-10.svg" />
                
                <!-- 리스트 생성 -->
                <c:set var="reviewList" value="<%=reviewList%>" />
                <div class="frame-31">
                    <c:forEach var="review" items="${reviewList}" varStatus="status">
                        <form action="ReviewDelete_pro.jsp" method="post">
                            <div class="group-55">
                                <input type="hidden" name="review_id" value="${review.review_id}" />
                                <input class="h" type="text" name="searchname" value="${brand.name}" />
                                <div class="_13">${review.userId }</div>
                                <div class="div12">${review.name}</div>
                                <div class="_010-1111-1234">${review.regdate}</div>
                                <div class="_123-123">${review.content}</div>
                                <div class="rectangle-40">${review.rating }</div>
                                <input class="rectangle-39" type="submit" value="삭제"/>
                            </div>
                        </form>
                    </c:forEach>
                </div>
            </div>


        </div>
        <div class="sidebar-title">
            <img class="frame7" src="./invenBrand_img/frame6.svg" />
            <div class="restaurant-list">RestaurantList</div>
            <div class="rectangle-35"></div>
            <img class="frame8" src="./invenBrand_img/frame7.svg" />
            <div class="hi">Hi, 관리자님</div>
        </div>
    </div>

</body>
</html>
