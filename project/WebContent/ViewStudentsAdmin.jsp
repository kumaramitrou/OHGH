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
		<table>
			<thead>
				<tr>
					<th>Roll No.</th>
					<th>Name</th>
					<th>Batch</th>
					<th>Stream</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="st" >
					<tr>
						<td>${st.getRollNo()}</td>
						<td>${st.getName()}</td>
						<td>${st.getBatch()}</td>
						<td>${st.getStream()}</td>
						<td>
							<input type="button" value = "Delete" id = "${st.getId()}" onclick="callDelete(${st.getId()})">
						</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
		<script>
			function callDelete(id){
				fetch("Student", {
				    method: 'delete'
				  });
				alert("called "+ id);
			}
		</script>
</body>
</html>