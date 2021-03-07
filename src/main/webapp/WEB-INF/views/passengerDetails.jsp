<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Search Results</title>
<link type="text/css" rel="stylesheet" href="/resources/cssFiles/passengerStyle.css" />

    <script type="text/javascript"> 
        function preventBack() { 
            window.history.forward();  
        } 
        setTimeout("preventBack()", 0); 
        window.onload = function () { null }; 
    </script> 
</head>


 <script>
  function validate(){
	  var firstnamebooker = document.getElementById("firstnamebooker");
	  var lastnamebooker = document.getElementById("lastnamebooker");
	  var email = document.getElementById("email");
	  var firstnamebooker = document.getElementById("firstnamebooker");
	  var c = /^[a-zA-Z]+$/; 
	    
	    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))
		      true;
		   else{
		      alert("You have entered an invalid email address!");
		      return false;
		   }
	    if(firstnamebooker.match(c)){
		      alert("You have entered invalid booker first name");
		     true ;
	    }else{
	    	return false;
	    }if(lastnamebooker.match(c)){
		      alert("You have entered invalid booker last name");
		     true ;
	    }else{
	    	return false;
	    }
}

   </script>
<body>
<h1>Passenger Details</h1>



	<form id="passengerDetails"  action="createPassenger" method="get">
		<div class = "container">
			<div class = "Airline name">
				<h1>Passenger 1:	</h1>
			</div>
				<div class = "Flight Price">
					
				</div>
				
				<div class = "firstnamebooker">
					<input id="firstnamebooker" name= "firstnamebooker" maxlength="255" size="8" value=""/>
					<label>First </label>
				</div>
				<div class = "lastnamebooker">
					<input id="lastnamebooker" name= "lastnamebooker" maxlength="255" size="14" required>
					<label>Last</label>
				</div>
				<div class = "email">
					<input id="email" name="email" type="email" maxlength="255" required> 
					<label>Email</label>
				</div> 
				<div class = "address">
					<input id="address" name="address" type="text" maxlength="110" required> 
					<label>address</label>
				</div> 
				<div class = "mobile">
					<input id="mobile" name="mobile" type="text" required maxlength = "15" minlength = "10"> 
					<label>mobile</label>
				</div> 
				<div class = "passportbooker">
					<input id="passportbooker" name="passportbooker" class="element text medium" type="text" maxlength="255" value=""/> 
					<label>passportno (for Int. flight)</label>
				</div>				
				<input type="hidden" id="flightid" name="flightid" value="${flightbean.getFlightId()}" >
				
				
	<c:forEach  var="passengernumber" begin="1" end = "${noOfPassengers-1}">
				<h1>Passenger ${passengernumber+1}:</h1>
				<div class = "firstname">
					<input id="firstname" name= "firstname${passengernumber}" maxlength="45" minlength = "1" value="" required >
					<label>First </label>
				</div>
				<div class = "lastname">
					<input id="lastname" name= "lastname${passengernumber}" maxlength="45" minlength = "1" value="">
					<label>Last</label>
				</div>
				<div class = "passportno">
					<input id="passport" name="passport${passengernumber}" class="element text medium" type="text" maxlength="255" value="" required> 
					<br>
					<label>passportno (for Int. flight)</label>
				</div>
	</c:forEach>
	
				<input type="hidden" id="flightcharge" name="flightCharge" value="${flightbean.getFlightCharge()}" >
				<input type="hidden" id="flightId" name="flightId" value="${flightbean.getFlightId()}" >
				<input type="hidden" id="noOfSeats" name="noOfSeats" value="${flightbean.getAeroplaneBean().getNoofSeats()}" >
				<input type="hidden" id="destAirportName" name="destAirportName" value="${flightbean.getDestinationAirport().getAirportName()}" >
				<input type="hidden" id="fromAirportName" name="fromAirportName" value="${flightbean.getFromAirport().getAirportName()}" >
				<input type="hidden" id="aeroplaneId" name="aeroplaneId" value="${flightbean.getAeroplaneId()}" >
				<input type="hidden" id="noOfPassengers" name="noOfPassengers" value="${noOfPassengers}" >
				
	
					<div class = "FlightTime Time">						
				</div>
				<div class="form-btn">
						<button class="submit-btn" >Book</button>
				</div>
		</div>
	</form>

</body>
</html>