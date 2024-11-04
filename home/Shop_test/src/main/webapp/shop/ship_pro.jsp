<%@page import="shop.dao.OrderRepository"%>
<%@page import="shop.dto.Ship"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String shippingDate = request.getParameter("shippingDate");
	String country = request.getParameter("country");
	String zipCode = request.getParameter("zipCode");
	String addressName = request.getParameter("addressName");
	String phone = request.getParameter("phone");
	
	String price = request.getParameter("price");
	String user_id = request.getParameter("user_id");
	
	Ship ship = new Ship();
	
	ship.setShipName(name);
	ship.setDate(shippingDate);
	ship.setCountry(country);
	ship.setZipCode(zipCode);
	ship.setAddress(addressName);
	ship.setPhone(phone);
	
	OrderRepository orderDAO = new OrderRepository();
	int result = orderDAO.insert(ship,user_id,price);
	
	if(result > 0){
		response.sendRedirect("../user/order.jsp");
	}
	
%>