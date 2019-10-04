<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/style.css" type="text/css"/>
<title>Online Help Desk.</title>
</head>
<body>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	//for Http 1.0
	response.setHeader("Pragma", "no-cache");

	response.setHeader("Expires", "0");//Proxies
	if(session.getAttribute("username")!=null)
	{
		response.sendRedirect((String)session.getAttribute("landingpage"));
	}
%>

<header>
	<img alt="HelpDesk" src="IMAGES/homeImage.jpg" height="58" width="58">
	<h1>Online Help Desk and Grievance Handling System.</h1>
</header>
<h1>Login Page</h1>
<form class="login">
		
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