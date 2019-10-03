<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	    
	    
<form action="Student" method="post">
	 	<label for="rollno">Roll No.:</label>
		<input type="text" name="rollno" required><br/>
		
		<label for="name">Name:</label>
		<input type="text" name="name" required><br/>
		
		<label for="batch">Batch:</label>
		<input type="text" name="batch" required><br/>
		
		<label for="stream">Stream:</label>
		<input type="text" name="stream" required><br/>
		
		${message}
		<%
		request.removeAttribute("message");
		%>
		
		<input type="submit" value="Add">
</form>
</body>
</html>