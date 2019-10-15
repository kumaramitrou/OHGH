<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ohdgh.db.FacilityHeadDao" %>
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
	
	FacilityHeadDao facilityDao = new FacilityHeadDao();
	request.setAttribute("facilities", facilityDao.listFacilities());
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

<div style="width:50%; position:absolute; transform: translate(50%, 0%);">
    <div class="panel panel-info">
      <div class="panel-heading"><h3>Raise Grievance.</h3></div>
      <div class="panel-body">   
			<form action="Grievance" method="post">
			
				<div class="form-group">
    				<label for="subject">Subject:</label>
    				<input type="text" class="form-control" id="subject" aria-describedby="emailHelp" placeholder="subject" name="subject" required>
  				</div>
  				
  				<div class="form-group">
    				<label for="content">Complaint:</label>
    				<textarea class="form-control" rows="5" id="content" placeholder="Content" name="content" required></textarea>
  				</div>
  			
  				
  				<div class="form-group">
  					<label for="content">Facility:</label>
  					<div class="dropdown">
  						<select name="facility" class="btn btn-info dropdown-toggle" data-toggle="dropdown" required>
  							<option value="">None</option>
  							<c:forEach items="${facilities}" var = "ft">
  								<option value = "${ft}">${ft}</option>
  							</c:forEach>
						</select>
					</div>
  				</div>
  				
  				<hr>
  				
				<button type="submit" class="btn btn-success" value ="Save" style="float: right;"><span class="glyphicon glyphicon-floppy-disk"></span> Save</button>
				${message}
				<%
				request.removeAttribute("message");
				%>
			</form>
		</div>
	</div>
</div>

</body>
</html>