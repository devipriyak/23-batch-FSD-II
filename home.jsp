<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    
	//🔒 Disable caching so that user cannot go back after logout
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	response.setDateHeader("Expires", 0); // Proxies

    String user = null;

    if (session != null) {
        user = (String) session.getAttribute("username");
    }

    if (user == null) {
        response.sendRedirect("login.jsp?error=Please+login+first");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>Welcome, <%= user %>!</h2>
    <p>You are successfully logged in.</p>
    <a href="logout.jsp">Logout</a>
</body>
</html>
