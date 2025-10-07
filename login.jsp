<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h2>Login</h2>
        <form method="post" action="loginvalidate.jsp">
            <input type="text" name="username" placeholder="Username" required><br>
            <input type="password" name="password" placeholder="Password" required><br>
            <input type="submit" value="Login">
        </form>
        <%
            String errorMsg = request.getParameter("error");
            if (errorMsg != null) {
        %>
            <p style="color:red;"><%= errorMsg %></p>
        <% } %>
</body>
</html>