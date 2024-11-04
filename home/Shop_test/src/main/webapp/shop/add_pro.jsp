<%@page import="shop.dao.ProductRepository"%>
<%@page import="shop.dto.Product"%>
<%@page import="java.util.UUID"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<% 
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String root = request.getContextPath();
	
    String fileUploadPath = "C:/jun/Temp/MSA_JAVA/home/Shop_test/src/main/webapp/static/img";
    File uploadDir = new File(fileUploadPath);
    if (!uploadDir.exists()) {
        uploadDir.mkdir(); // 디렉토리 생성
    }

    	DiskFileUpload upload = new DiskFileUpload();
        // 요청을 파싱하여 FileItem 리스트 생성
        List<FileItem> items = upload.parseRequest(request);
        String productId = null;
        String name = null;
        String unitPrice = null;
        String description = null;
        String manufacturer = null;
        String category = null;
        String unitsInStock = null;
        String condition = null;
        String fileName = null; // 파일 이름 저장용

        for (FileItem item : items) {
            if (item.isFormField()) { // 일반 폼 필드인 경우
                String fieldName = item.getFieldName(); // 필드 이름
                String fieldValue = item.getString("UTF-8"); // 필드 값

                // 필드 이름에 따라 값 저장
                switch (fieldName) {
                    case "productId":
                        productId = fieldValue;
                        break;
                    case "name":
                        name = fieldValue;
                        break;
                    case "unitPrice":
                        unitPrice = fieldValue;
                        break;
                    case "description":
                        description = fieldValue;
                        break;
                    case "manufacturer":
                        manufacturer = fieldValue;
                        break;
                    case "category":
                        category = fieldValue;
                        break;
                    case "unitsInStock":
                        unitsInStock = fieldValue;
                        break;
                    case "condition":
                        condition = fieldValue;
                        break;
                }
            } else { // 파일인 경우
                fileName = item.getName(); // 파일 이름 가져오기
                File uploadedFile = new File(uploadDir, fileName);
                item.write(uploadedFile); // 파일 저장
            }
        }

        // Product 객체 생성
        Product product = Product.builder()
                                .productId(productId)
                                .name(name)
                                .unitPrice(Integer.parseInt(unitPrice))
                                .description(description)
                                .manufacturer(manufacturer)
                                .category(category)
                                .unitsInStock(Long.parseLong(unitsInStock))
                                .condition(condition)
                                .file("/static/img/" + fileName) // 저장된 파일 경로
                                .build();
        
        out.println(product);
		
		
	ProductRepository productDAO = new ProductRepository();
	int result = productDAO.insert(product);
	
	if(result > 0){
		response.sendRedirect("products.jsp?keyword=");
	}
	else{
		response.sendRedirect("add.jsp?error=0");
	}
%>
