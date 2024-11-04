<%@page import="shop.dao.ProductRepository"%>
<%@page import="shop.dto.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	String productId = request.getParameter("productId");		// 상품ID
	String name = request.getParameter("name");			// 상품명
	String unitPrice = request.getParameter("unitPrice");		// 가격(단가)
	String description = request.getParameter("description");		// 설명
	String manufacturer= request.getParameter("manufacturer");		// 제조 업체
	String category = request.getParameter("category");			// 카테고리
	String unitsInStock = request.getParameter("unitsInStock");		// 재고 수
	String condition = request.getParameter("condition");		// 상태
	String file = request.getParameter("file");
	file = "/static/img/"+file;
	

	 Product product = Product.builder()
								.productId(productId)
								.name(name)
								.unitPrice(Integer.parseInt(unitPrice))
								.description(description)
								.manufacturer(manufacturer)
								.category(category)
								.unitsInStock(Long.parseLong(unitsInStock))
								.condition(condition)
								.file(file)
								.build();
	
	ProductRepository productDAO = new ProductRepository();
	int result = productDAO.insert(product);
	
	if(result > 0){
		response.sendRedirect("products.jsp");
	}
	else{
		response.sendRedirect("add.jsp?error=0");
	}
	
	
%>