<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Requests<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">View All</a></li>
          <li><a href="#">View Open</a></li>
          <li><a href="#">Raise New</a></li>
        </ul>
      </li>      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Grievance<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">View All</a></li>
          <li><a href="#">View Open</a></li>
          <li><a href="#">Raise New</a></li>
        </ul>
      </li>
      <li><a href="#">Updates<span class="badge" id="update">${update}</span></a></li>
      <li><a href="#">Notification<span class="badge" id="notif">${notif}</span></a></li>
      <li><a href="#">Change Password</a></li>
      <li><a href="AboutUs.jsp">About Us </a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span>Log Out</a></li>
    </ul>
    <p class="navbar-text navbar-right">Welcome ${username}</p>
  </div>
</nav>


<h1>Student</h1>
</body>
</html>