<%@page import="shop.dao.ProductRepository"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cartId = request.getParameter("cartId");
	ProductRepository productDAO = new ProductRepository();
	if(cartId.equals("0")){
		productDAO.resetQuantityToZero();
	}
	else{
		productDAO.resetQuantityToZeroById(cartId);
		
	}
	response.sendRedirect("cart.jsp");

%>