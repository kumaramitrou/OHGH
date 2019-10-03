<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login Page</h1>
<form>
		
		<label for="uname">Username:</label>
		
		<input type="text" name="uname">
		
		<label for="uname">Password:</label>
		
		<p><a href="#">Forgot your password?</a>
		
		<input type="password" name="pass">
		
		<div id="lower">
		
		<input type="submit" value="Login" onclick="form.action='Login';"/>
		
		<input type="submit" value="Signup" onclick="form.action='SignUp.jsp';"/>		
		
		</div>
		
		</form>
		${message}
		<%
		request.removeAttribute("message");
		%>
</body>
</html>