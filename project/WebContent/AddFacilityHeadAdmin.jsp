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

<div style="width:50%; position:absolute; transform: translate(50%, 0%);">
    <div class="panel panel-info">
      <div class="panel-heading"><h3>Register a new Facility Head to Organization.</h3></div>
      <div class="panel-body">   
			<form action="FacilityHead" method="post">
			
				<div class="form-group">
    				<label for="empno">Employee No.:</label>
    				<input type="text" class="form-control" id="empno" aria-describedby="emailHelp" placeholder="Enter Employee no." name="empno" required>
  				</div>
  				
  				<div class="form-group">
    				<label for="name">Name:</label>
    				<input type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter name" name="name" required>
  				</div>
  				
  				<div class="form-group">
    				<label for="department">Department:</label>
    				<input type="text" class="form-control" id="department" aria-describedby="emailHelp" placeholder="Enter department" name="department" required>
  				</div>
  				
  				<div class="form-group">
    				<label for="specialization">Specialization:</label>
    				<input type="text" class="form-control" id="specialization" aria-describedby="emailHelp" placeholder="Enter specialization" name="specialization" required>
  				</div>
  				
  				<div class="form-group">
    				<label for="facility">Facility:</label>
    				<input type="text" class="form-control" id="facility" aria-describedby="emailHelp" placeholder="Enter facility" name="facility" required>
  				</div>
		
				<button type="submit" class="btn btn-success" value ="Add"><span class="glyphicon glyphicon-plus"></span> Add</button>
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