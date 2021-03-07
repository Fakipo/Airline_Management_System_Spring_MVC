<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
	response.setHeader("Pragma","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Expires","0");
	response.setDateHeader("Expires",-1	);
	session.invalidate();

%>   <title>login form</title>
<link href="/resources/cssFiles/loginstyle.css" rel="stylesheet">
</head>
<META Http-Equiv="Cache-Control" Content="no-cache">
<META Http-Equiv="Pragma" Content="no-cache">
<META Http-Equiv="Expires" Content="0">
<body>
<script>
	window.onload = function(){
		var error = "${errorLoggingIn}";
		if(!error == ""){
			alert(error);
			window.location.replace("/Loogin");
		}
	}
	</script>
	<script>
    function Validate() {
	    var email = document.getElementById('email').value;
	   
	   if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))
	      true;
	   else{
	      alert("You have entered an invalid email address!");
	      return false;
	    }
</script>

<a href="/Home2"><img src="/resources/images/BackButton.png" width="70px" border= "none";></a>

 <div class="loginBox">
	<!--<img src=" class="user" >-->
  
	<h2>Login</h2>
	<br>
	<br>
	<form id="loginForm" onsubmit="return Validate();" modelAttribute="login" action="loginProcess" method="get">
		<p>Email</p>
		<input type="email" path="email" name="email" placeholder="Enter Email" maxlength = "75">
		<p>Password</p>
		<input type="password" path="password" name="password" placeholder="Enter Password" maxlength = "25">
		<input type="submit" name="" value="Log In">
		<a href="#">Forget Password</a><br><br>
		<p align="center";>Are you new?<a href="#"> Sign Up</a></p>
	</form>
</div>
</body>
</html>