<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><h4>---- 세션 삭제하기 전 ----</h4></p>
    <%
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("passowrd");
        out.println("설정된 세션 속성 username : " + username + "<br>");
        out.println("설정된 세션 속성 passowrd : " + password + "<br>");
        // 세션 속성 제거
        session.removeAttribute("username");
        session.removeAttribute("password");
    %>
    <p><h4>---- 세션을 삭제한 후 ----</h4></p>
    <%
        username = (String) session.getAttribute("username");
        password = (String) session.getAttribute("passowrd");
        out.println("설정된 세션 속성 username : " + username + "<br>");
        out.println("설정된 세션 속성 passowrd : " + password + "<br>");
    %>
    <div>
    <a href="<%= request.getContextPath() %>/session06.jsp">session06jsp</a>
    </div>
</body>
</html>