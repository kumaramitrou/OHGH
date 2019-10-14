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
  <h2><strong>Request.</strong></h2>
  <c:forEach items="${requesthistory}" var = "rqh" >
  	<div class="${rqh.getDesign()}" id="${rqh.getId()}">
      <div class="panel-heading"><strong>${rqh.getSubject()} - ( ${rqh.getSerialNo()} )</strong></div>
      <div class="panel-body">
      ${rqh.getMessage()}
      </div>
  	</div>
  </c:forEach>
  <form action="Reply?trackingid=${rq.getTrackingId()}" method="get">
  <div class="panel panel-info" <%= request.getAttribute("divVisibility") %>>
  	<div class="panel-heading">
    	<label for="subject">Subject:</label>
    	<input type="text" class="form-control" id="subject" aria-describedby="emailHelp" placeholder="subject" name="subject" required>
  	</div>
  				
  	<div class="panel-body">
    	<label for="content">Content:</label>
    	<textarea class="form-control" rows="5" id="content" placeholder="Content" name="content" required></textarea>
  	</div>
  	<button type="submit" class="btn btn-success" value ="Reply" style="float: right; margin: 10px;"><span class="glyphicon glyphicon-pencil"></span> Reply</button>
  	<button type="submit" class="btn btn-success" value ="Solution" style="float: right; margin: 10px;" formnovalidate="formnovalidate"><span class="glyphicon glyphicon-ok"></span> <a style="color: inherit; text-decoration: none;" href="Solution?trackingid=4d8b74f1-7cfd-4034-a493-8c5dad4f8187"> Mark as Solution</a></button>
  </div>
</form>
  <div <%= request.getAttribute("solutionVisibility") %>> <h3 style="color: green;"> Marked as Solution </h3></div>
<h3>${message}</h3>
      <%
      	request.removeAttribute("message");
      %>
</div>


</body>

</html>