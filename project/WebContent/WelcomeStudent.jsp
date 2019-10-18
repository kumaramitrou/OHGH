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
          <li><a href="Request?id=viewall">View All</a></li>
          <li><a href="Request?id=viewopen">View Open</a></li>
          <li><a href="RequestNew.jsp">Raise New</a></li>
        </ul>
      </li>      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Grievance<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="Grievance">View All</a></li>
          <li><a href="GrievanceNew.jsp">Raise New</a></li>
        </ul>
      </li>
      <li><a href="Update">Updates<span class="badge" id="update">${update}</span></a></li>
      <li><a href="Notification">Notifications<span class="badge" id="notif">${notif}</span></a></li>
      <li><a href="ChangePassword.jsp">Change Password</a></li>
      <li><a href="AboutUs.jsp">About Us </a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span>Log Out</a></li>
    </ul>
    <p class="navbar-text navbar-right">Welcome ${username}</p>
  </div>
</nav>



<div class="container">
  <h2 style="color:#07C2B4">Student</h2>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="./IMAGES/student001.jpg" alt="Conference Room" style="width:100%;">
      </div>

      <div class="item">
        <img src="./IMAGES/student002.jpg" alt="Computer Lab" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="./IMAGES/student003.jpg" alt="Excited Student" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>


</body>
</html>