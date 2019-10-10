<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
   <script src="SCRIPT/script.js"></script>
  <link rel="icon" href="./IMAGES/homeImage.jpg">
<title>Online Help Desk.</title>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	//for Http 1.0
	response.setHeader("Pragma", "no-cache");

	response.setHeader("Expires", "0");//Proxies
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("Login.jsp");
	}
%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="<%= (String)session.getAttribute("landingpage") %>">Help Desk and Grievance Handling.</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="<%= (String)session.getAttribute("landingpage") %>">Home</a></li>      
      <li><a href="AboutUs.jsp">About Us </a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span>Log Out</a></li>
    </ul>
    <p class="navbar-text navbar-right">Welcome ${username}</p>
  </div>
</nav>

<div style="width:50%; position:absolute; transform: translate(50%, 0%);">
    <div class="panel panel-warning">
      <div class="panel-heading"><h3>Change Password</h3></div>
      <div class="panel-body">
      	<form action = "Password" method = "get">
      		<div class="form-group">
    			<label for="opass">Old Password:</label>
    			<input type="password" class="form-control" id="opass" aria-describedby="emailHelp" placeholder="Old Password" name="opass" required>
  			</div>
  			<div class="form-group">
    			<label for="pass">New Password:</label>
    			<input type="password" class="form-control" id="pass" aria-describedby="emailHelp" placeholder="New password" name="pass" required>
  			</div>
  			<div class="form-group">
    			<label for="cpass">Confirm password:</label>
    			<input type="password" class="form-control" id="cpass" aria-describedby="emailHelp" placeholder="Confirm Password" name="cpass" required="required" oninput="check(this)">
  			</div>
  			<input type="submit" value="Submit" class="btn btn-primary">
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