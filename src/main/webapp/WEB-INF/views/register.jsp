<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<%
	response.setHeader("Pragma","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Expires","0");
	response.setDateHeader("Expires",-1	);
	session.invalidate();

%>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
   <title>Signup form</title>
<link href="/resources/cssFiles/Signupstyle.css" rel="stylesheet">
</head>

 <script>
	window.onload = function(){
		var error = "${error}";
		if(!error == ""){
			alert(error);
			window.location.replace("/register");
		}
	}

  
    function Validate() {
	    var c = /^[a-zA-Z ]+$/; 
	    var fullname = document.getElementById("fullname").value;
	    var phoneNo = document.getElementById('mobile').value;
	    var email = document.getElementById('email').value;
	    if(fullname.match(c))
	      true ;
	    else
	   	{
		  alert("Enter a valid name");
		  return false ;
		}
	    if(b.match(c))
	      true ;
		else
		{
			  alert("Enter a valid name");
			  return false ;
		}
	    if ((phoneNo.value.length > 12)) {
	        alert("Mobile No. is not valid, Please Enter a valid Mobile No.");
	        return false;
	    }
	    else
	    	 true;
	    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))
	      true;
	   else{
	      alert("You have entered an invalid email address!");
	      false;
	  }
        var password = document.getElementById("p1").value;
        var confirm_Password = document.getElementById("p2").value;
        if (password != confirm_Password) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
		
    }
   </script>
   
	  
	  
<body>
   <a href="#"><img src="/resources/images/BackButton.png" width="70px" border= "none";></a>
 <div class="signupBox">
	
	<h2>Sign up for free</h2>
	
	<form onsubmit="return Validate();" modelAttribute="user" action="registerProcess" method="post">
	    <p>Full Name</p>
		<input type="text" name="fullName" path="fullName" id="fullname" placeholder="Enter Full name" required >
		<p>Mobile (With Country Code)</p>
		<input type="text" name="mobile" path="mobile" id="mobile" placeholder="Enter your mobile" required maxlength = "15" minlength = "10">
		<p>Email</p>
		<input type="email" name="email" path = "email" placeholder="Enter Email" required>
		<p>County</p>
		<select class="form-control" name = "destination" id="destination" >
				   <option value="India">India</option>						
				   <option value="China">China</option>						
				   <option value="US">US</option>						
		</select>		
		<p>Password</p>
		<input type="password" path = "password" id="p1" name="password" placeholder="" minlength = "6" maxlength = "25" required >
		<p>Confirm Password</p>
		<input type="password" name="" id="p2" placeholder="" minlength = "6" maxlength = "25" required ><br>
		<input type="submit" name="" value="Sign Up"><br><br>
		<p>Already have an account?<a href="#"> LOG IN</a>
	</form>
</div>
</body>