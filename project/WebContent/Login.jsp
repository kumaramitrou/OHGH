<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="icon" href="./IMAGES/homeImage.jpg">
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

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Help Desk and Grievance Handling.</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="index.jsp">Home</a></li>
      <li><a href="AboutUs.jsp">About Us </a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="SignUp.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
    </ul>
  </div>
</nav>

<br>
<div style="width:50%; position:fixed; transform: translate(50%, 0%);">
<div class="panel panel-info">
      <div class="panel-heading"><h3>Login Here</h3></div>
      <div class="panel-body">
      	<form action="Login">
  			<div class="form-group">
    			<label for="uname">User Name:</label>
    			<input type="text" class="form-control" id="uname" aria-describedby="emailHelp" placeholder="Enter username" name="uname">
  			</div>
  			<div class="form-group">
    			<label for="pwd">Password:</label>
   				<input type="password" class="form-control" id="pwd" placeholder="Password" name="pass">
  			</div>
  			<button type="submit" class="btn btn-primary">Login</button>
  					<span style="color: red">${message}</span>
					<%
						request.removeAttribute("message");
					%>
		</form>
      </div>
    </div>
   </div>



</body>
</html>