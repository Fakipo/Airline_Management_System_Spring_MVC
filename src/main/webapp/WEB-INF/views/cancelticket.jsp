<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="/resources/cssFiles/freightInfoStyle.css" />

<script>

window.onload = function() {		  	
	if("${fullname}" == "null" || "${fullname}" == ""){
		alert("You need to login first");
	}
}</script>
<script>
	
	function validate(){
	var email = document.getElementById("email").value;
	var flightid = document.getElementById("flightid").value;
	
   	if ((flightid.match(/^\d+$/)))
   		true;
   	else{
   		alert("Enter correct flightid");
   		return false;
   	}
   	
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(recepientEmail))
	       true;
	else
	    {
	      alert("You have entered an invalid Email address!");
	      return false;
	  	}
    }
</script>
</head>
<body>

<form  id="cancelTicket" onsubmit="return validate();" action = "cancelTickets" method ="GET">
	<div class = "flightid">
		<h2>All the seats for the flight with respective email will be cancelled </h2>
		<input type="text" id="flightid" name="flightid" value="" maxlength="3" required>
		<label>FLightid</label>
	</div>
	
	<div class = "email">
	 	<input type="email" id="email" name="email" placeholder="${email}" maxlength="80" disabled>
	 	<label>registered email</label>
	</div>
	
			<div class="form-btn">
			<button class="submit-btn">Confirm Deletion</button>
	</div>
</form>
</body>
</html>