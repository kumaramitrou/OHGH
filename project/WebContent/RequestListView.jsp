<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <a class="navbar-brand" href="index.jsp">Help Desk and Grievance Handling.</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="index.jsp">Home</a></li>
      <li><a href="AboutUs.jsp">About Us </a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span>Log Out</a></li>
    </ul>
    <p class="navbar-text navbar-right">Welcome ${username}</p>
  </div>
</nav>

<div class="container">
  <h2><strong>Requests.</strong></h2>
  <c:forEach items="${requests}" var = "rq" >
  	<div class="panel panel-success">
      <div class="panel-heading"><strong>${rq.getSubject()} - ( ${rq.getId()} )</strong></div>
      <div class="panel-body">
      ${rq.getMessage()}
      <button id = "${rq.getTrackingId()}" type="button" class="btn btn-success" value ="View" style="float: right; margin: 10px;"><span class="glyphicon glyphicon-eye-open"></span><a style="color: inherit; text-decoration: none;" href="Show?trackingid=${rq.getTrackingId()}"> View</a></button>
      </div>
  	</div>
  </c:forEach>
<h3>${message}</h3>
      <%
      	request.removeAttribute("message");
      %>
</div>

<script>
	function getRequest(trackingId){
		alert(trackingId);
			fetch("Show" + "?trackingid=" + trackingId, {
				method: 'get'
			});
	}
</script>
</body>

</html>