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
	if(session.getAttribute("username")!=null)
	{
		response.sendRedirect((String)session.getAttribute("landingpage"));
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
      <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

<div style="width:50%; position:absolute; transform: translate(50%, 0%);">
    <div class="panel panel-primary">
      <div class="panel-heading"><h3>Sign Up here.</h3></div>
      <div class="panel-body">
      	<form action = "SignUp" method = "post">
      		<div class="form-group">
    			<label for="uname">Name:</label>
    			<input type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Firstname Lastname" name="name" required>
  			</div>
  			<div class="form-group">
    			<label for="pass">Password:</label>
    			<input type="password" class="form-control" id="pass" aria-describedby="emailHelp" placeholder="Password" name="pass" required>
  			</div>
  			<div class="form-group">
    			<label for="cpass">Confirm password:</label>
    			<input type="password" class="form-control" id="cpass" aria-describedby="emailHelp" placeholder="Confirm Password" name="cpass" required="required" oninput="check(this)">
  			</div>
  			
  			<div class="form-group">
    			<label for="cpass">Email:</label>
    			<input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Email" name="email" required>
  			</div>
  			<div class="form-group">
    			<label for="sques">Security Question:</label>
    			<input type="text" class="form-control" id="cpass" aria-describedby="emailHelp" placeholder="Security question" name="secques" required>
  			</div>
  			<div class="form-group">
    			<label for="sans">Security Answer:</label>
    			<input type="text" class="form-control" id="cpass" aria-describedby="emailHelp" placeholder="Security answer" name="secans" required>
  			</div>
  			<div class="form-group">
    			<label for="cpass">User Name:</label>
    			<input type="text" class="form-control" id="uname" aria-describedby="emailHelp" placeholder="Username" name="uname" required>
  			</div>
  			<div class="form-group">
    			<label for="uid">Roll No. or Employee Id:</label>
    			<input type="text" class="form-control" id="uid" aria-describedby="emailHelp" placeholder="Student's Roll No/Faculty's Id" name="uid" required>
  			</div>
  			<div class="form-group">
  				<input type="radio" name="usertype" value="WelcomeStudent.jsp" checked/>Student
				<input type="radio" name="usertype" value="WelcomeFacilityHead.jsp"/>Facility Head
  			</div>
  			<input type="submit" value="Sign Up" class="btn btn-primary">
  			<span style="color: red">${message}</span>
			<%
				request.removeAttribute("message");
			%>
  		</form>
      </div>
    </div>
</div>
</body>
</html>