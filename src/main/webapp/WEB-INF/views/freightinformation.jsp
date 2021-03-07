<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">	
	  window.onload = function() {		  	
			var fullname = "${fullname}";
			if(!fullname){
				alert("You need to login first");
				window.location.replace("/Home2");
			}
			
			var date = new Date();

			var day = date.getDate();
			var month = date.getMonth() + 1;
			var year = date.getFullYear();

			if (month < 10) month = "0" + month;
			if (day < 10) day = "0" + day;

			var today = year + "-" + month + "-" + day;       
			document.getElementById("theDate").value = today;
			
			var today1 = new Date().toISOString().split('T')[0];

			document.getElementById("theDate")[0].setAttribute('min', today1);
		}	
	
	function validate() {
		var recepientName = document.getElementById("recepientName").value;
		var recepientEmail = document.getElementById("recepientEmail").value;
		var recepientMobile = document.getElementById("recepientMobile").value;
		var recepientAddress = document.getElementById("recepientAddress").value;
		var senderName = document.getElementById("senderName").value;
		var senderMobile = document.getElementById("senderMobile").value;
		
	    var c = /^[a-zA-Z ]+$/; 
	    var addValidate = /^[a-zA-Z0-9\s, '-]*$/;

		
		
	    var from = document.getElementById("from");
	    var fromText = from.options[from.selectedIndex].text;
	    var destination = document.getElementById("destination");
	    var destinationText = destination.options[destination.selectedIndex].text;
	    
	    var result = fromText.localeCompare(destinationText);

	    if(result == 0)	{
	    	alert("cannot have same values in both from and to"); 
			return false;
	    }else{    	
	    	 true;
		}
	    
	    if(recepientName.match(c))
		      true ;
	    else
	   	{
		  alert("Enter a valid RecepientName");
		  return false ;
		}
	    
	    
	    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(recepientEmail))
		       true;
		   else
		   {
		      alert("You have entered an invalid Recepient Email address!");
		      return false;
		  }
	    
	    
	   	if ((recepientMobile.match(/^\d+$/)))
			true;
	   	else{
	   		alert("RecepientMobile should be between 10-12 digits only");
	   		return false;
	   	}
	   	

	   	
	    if(recepientAddress.match(addValidate))
	    	true;
	    else{
		      alert("You have entered an invalid address!");
		      return false;
	    }

	    
	    if(senderName.match(c))
		      true ;
	    else
	   	{
		  alert("Enter a valid SenderName");
		  return false ;
		}

	    
	    
	   	if ((senderMobile.match(/^\d+$/)))
			true;
	   	else{
	   		alert("SenderMobile should be between 10-12 digits only");
	   		return false;
	   	}
	    

}
</script>
<meta charset="ISO-8859-1">
<title>Freight Information</title>
<link type="text/css" rel="stylesheet" href="/resources/cssFiles/freightInfoStyle.css" />
</head>
<body>
<form  id="freightbooking" onsubmit="return validate();" modelAttribute="freightbooking" action = "freightInfo" method ="GET">
	<h1>Freight Information</h1>
	<input type="hidden" id="fullname" name="fullname" value="${fullname}" >
	<input type="hidden" id="userid" name="userid" value="${userid}" >
	<input type="hidden" id="email" name="email" value="${email}" >
	
	<div class = "recepient-name">
		<h2>Cargo Shipping charges = $50</h2>
		<input type="text" id="recepientName" name="recepientName" value="" maxlength="50" required>
		<label>Recepient Name</label>
	</div>
	
	<div class = "recepient-email">
	 	<input type="email" id="recepientEmail" name="recepientEmail" value="" maxlength="80" required>
	 	<label>Recepient Email</label>
	</div>

	<div class = "recepient-mobile">
	 	<input type="text" id="recepientMobile" name="recepientMobile" value="" minlength="10" maxlength="13" required>
	 	<label>Recepient Contact</label>
	</div>

	<div class = "recepient-address">
	 	<input type="text" id="recepientAddress" name="recepientAddress" value="" maxlength="125"  required>
	 	<label>Recepient Address</label>
	</div>

	<div class = "sendername">
		<input type="text" id="senderName" name="senderName" value=""  maxlength="50" required>
		<label>Sender Name</label>
	</div>

	<div class = "sendermobile">
		<input type="text" id="senderMobile" name="senderMobile" value="" minlength="10" maxlength="13" required>
		<label>Sender mobile no.</label>
	</div>

	<div class = "cargosize">
		<input type="checkbox" id="cargoSize" name="cargoSize" value="Bike">
		<label>weight more than 10kg</label>
	</div>
	<div>
		<span class="form-label">Deliver From Airport<span>
		<select class="form-controller" name = "from" id="from" >
			<c:forEach items="${cityNameList}" var="name">
				<option value="${name}">${name}</option>
			</c:forEach>					
		</select>			
	</div>
		
		<div>
		<span class="form-label">Deliver To Airport<span>
		<select class="form-controller" name = "destination" id="destination" >
				<c:forEach items="${cityNameList}" var="name">
					   <option value="${name}">${name}</option>
				</c:forEach>						
		</select>			
		</div>
		<div class="date">
			<span class="form-label">Date of Supply</span>
			<input class="form-control" name="flightDate" type="date" id = "theDate" min = "2020-8-24" required>
		</div>		
		<div class="form-btn">
			<button class="submit-btn">Confirm Booking</button>
		</div>
</form>


</body>