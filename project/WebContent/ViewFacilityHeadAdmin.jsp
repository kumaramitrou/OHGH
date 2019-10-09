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
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Student<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="Student">View</a></li>
          <li><a href="AddStudentAdmin.jsp">Add</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Facility Head<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="FacilityHead">View</a></li>
          <li><a href="AddFacilityHeadAdmin.jsp">Add</a></li>
        </ul>
      </li>
      <li><a href="AboutUs.jsp">About Us </a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span>Log Out</a></li>
    </ul>
    <p class="navbar-text navbar-right">Welcome ${username}</p>
  </div>
</nav>



<div class="container">
<h2 style="color:#07C2B4"> Facility Heads.</h2>
<hr>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Employee No.</th>
				<th>Name</th>
				<th>Department</th>
				<th>Specialization</th>
				<th>Facility</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${facilityheads}" var="fh" >
					<tr  id = "${fh.getId()}">
						<td>${fh.getEmpNo()}</td>
						<td>${fh.getName()}</td>
						<td>${fh.getDepartment()}</td>
						<td>${fh.getSpecialization()}</td>
						<td>${fh.getFacility()}</td>
						<td>
							<button type="button" class="btn btn-danger" onclick="callDelete(${fh.getId()})"><span class="glyphicon glyphicon-remove"></span> Remove</button>
						</td>
					</tr>	
			</c:forEach>
		</tbody>
	</table>
</div>
		<script>
		function callDelete(id){
				var flag = confirm("Facility Head will be removed permanently!");
				if(flag == true){
					fetch("FacilityHead" + "?id=" + id, {
					    method: 'delete'
					  });
					var element = document.getElementById(id);
					element.parentNode.removeChild(element);
				}
		}
		</script>
</body>
</html>