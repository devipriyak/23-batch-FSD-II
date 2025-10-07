<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // ✅ Simple hardcoded validation (you can replace with DB check)
    if ("admin".equals(username) && "admin123".equals(password)) {
        session.setAttribute("username", username);
        response.sendRedirect("home.jsp");
    } else {
        response.sendRedirect("login.jsp?error=Invalid+Username+or+Password");
    }
%>
