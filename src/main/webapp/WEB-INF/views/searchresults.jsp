<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
<link type="text/css" rel="stylesheet" href="/resources/cssFiles/flightSearchResultStyle.css" />
</head>


<script>
	  window.onload = function() {
	  var result = "${flightdetails.getFlightId()}";
	  if("${flightBeanList.isEmpty()}" == "true"){
	  window.location.replace("/searchFlightsInitial");
	  alert("No flights found for the enteries");
	  }
	}
 </script>
<body>
<h1>SEARCH RESULTS</h1>


	<c:forEach items="${flightBeanList}" var="flightdetails">
	<form id="searchresults" modelAttribute="flightdetails" action="checkPassengersInitial" method="get">
		<div class = "container">
			<div class = "airline-picture">
				<img src="/resources/images/aeroe.jpg" alt="picture Aeroplane" width="200" height="100">
			</div>
			<div class = "Flight-Price">
					  <h3>Flight charge = $${flightdetails.getFlightCharge()}</h3>
					 <input type="hidden" id="flightcharge" name="flightCharge" value="${flightdetails.getFlightCharge()}" >
					 <input type="hidden" id="flightId" name="flightId" value="${flightdetails.getFlightId()}" >
					 <input type="hidden" id="noOfSeats" name="noOfSeats" value="${flightdetails.getAeroplaneBean().getNoofSeats()}" >
					 <input type="hidden" id="destAirportName" name="destAirportName" value="${flightdetails.getDestinationAirport().getAirportName()}" >
					 <input type="hidden" id="fromAirportName" name="fromAirportName" value="${flightdetails.getFromAirport().getAirportName()}" >
					 <input type="hidden" id="aeroplaneId" name="aeroplaneId" value="${flightdetails.getAeroplaneId()}" >
			</div>
				<div class = "company-name">
					<h1 class = "Airline-header"> ${flightdetails.getAeroplaneBean().getCompany()}</h1>
				</div>
				<div class = "FlightTime Time">						
					<h3>Take OFF Time - ${flightdetails.getArrivalDateTime()}</h3>
				</div>
						
				<div class="form-group">
					<span class="form-label"><b>No. Of Passengers</b></span>
					<select class="form-control" name = "noOfPassengers">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
					<span class="select-arrow"></span>
				</div>
				
				
				<div class="form-btn">
						<button class="submit-btn" >Book</button>
				</div>
				
				<div class = "from-from">
					<h3>From</h3>
					<h3>${flightdetails.getFromAirport().getAirportCity().toUpperCase()}</h3>
					
				</div>

				<div class = "to-to">
					<h3>To</h3>
					<h3>${flightdetails.getDestinationAirport().getAirportCity().toUpperCase()}</h3>
				</div>
		</div>
	</form></br>
	</c:forEach>

</body>
</html>