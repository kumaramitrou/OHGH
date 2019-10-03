<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Sign Up Page.</h1>
<form action = "SignUp" method = "post">
Name: <input type="text" required="required" name="name"><br/>
Password: <input type="password" required="required" name="pass" id="pass"><br/>
Confirm Password: <input type="password" required="required" name="cpass" id="cpass" oninput="check(this)"><br/>
<script language='javascript' type='text/javascript'>
    function check(input) {
    	console.log("print");
        if (input.value != document.getElementById('pass').value) {
            input.setCustomValidity('Password Must be Matching.');
        } else {
            // input is valid -- reset the error message
            input.setCustomValidity('');
        }
    }
</script>
Email: <input type="email" name="email"><br/>
Security Question: <input type="text" name="seqques"><br/>
Security Answer: <input type="text" name="seqans"><br/>
User Name: <input type="text" name="uname"><br/>
<input type="radio" name="usertype" value="student" checked/>Student<br/>
<input type="radio" name="usertype" value="facilityhead"/>Facility Head<br/>
<input type="submit" value="Sign Up">
</form>
</body>
</html>