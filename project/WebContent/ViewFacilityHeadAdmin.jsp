<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/navbar.css"/>
<title>Insert title here</title>
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
<h1>Admin's Landing Page.</h1>
<form action="Logout">
<input type="submit" value="Log Out">
</form>
<h4>Welcome ${username}</h4>

		<nav id="menu">
			<ul>
				<li class="menuitem"><a href="<%= (String)session.getAttribute("landingpage") %>">Home</a></li>
				<li class="dropdown">
					<a href="javascript:void(0)" class="dropbtn">Students</a>
					<div class="dropdown-content">
      					<a href="Student">View</a>
      					<a href="AddStudentAdmin.jsp">Add</a>
    				</div>
				</li>
				<li class="dropdown">
					<a href="javascript:void(0)" class="dropbtn">Facility Head</a>
					<div class="dropdown-content">
      					<a href="FacilityHead">View</a>
      					<a href="AddFacilityHeadAdmin.jsp">Add</a>
    				</div>
				</li>
				<li class="menuitem"><a href="AboutUs.jsp">About Us</a></li>
			</ul>
	    </nav>
<h1>Views List of all Facility Head and Students who can register for this website in an organization.</h1>
		<table width="500">
			<thead>
				<tr>
					<th>Employee No.</th>
					<th>Name</th>
					<th>Department</th>
					<th>Specialization</th>
					<th>Facility</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${facilityheads}" var="fh" >
					<tr>
						<td>${fh.getEmpNo()}</td>
						<td>${fh.getName()}</td>
						<td>${fh.getDepartment()}</td>
						<td>${fh.getSpecialization()}</td>
						<td>${fh.getFacility()}</td>
						<td>
							<input type="button" value = "Delete" id = "${fh.getId()}" onclick="callDelete(${fh.getId()})">
						</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
		<script>
		function callDelete(id){
				var flag = confirm("Facility Head will be removed permanently!");
				if(flag == true){
					fetch("FacilityHead" + "?id=" + id, {
					    method: 'delete'
					  });
				}
		}
		</script>
</body>
</html>