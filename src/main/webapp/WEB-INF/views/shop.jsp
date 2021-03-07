<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/resources/cssFiles/shopstyle.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  </head>
  <body>
  <form id="totalTicketInitial" action="totalTicketInitial" method="POST">
    <div class="container">
	 
      <div class="pricing-table table1">
        <div class="pricing-header">
          <div class="price"><span>$</span>10</div>
          <div class="title">EyeCover</div>
        </div>
		
		<div class= "noOfItem1">
			Total number
		<br>
		<select class="form-control" name = "eyecoverno">
			<option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
		</select>
		  </div>
      <img src="/resources/images/eyecover.jpg" alt="Smiley face" height="250" width="300">
      </div>
		
      <div class="pricing-table table2">
        <div class="pricing-header">
          <div class="price"><span>$</span>20</div>
          <div class="title">Neck-Pillow</div>
        </div>
		
		<div class= "noOfItem2">
		Total number
			<br>
			<select class="form-control2" name = "neckpillowno">
				<option value="0">0</option>			
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
			</select>
		  </div>
      <img src="/resources/images/neckpillow.png" alt="Smiley face" height="250" width="300">
      </div>
		
      <div class="pricing-table table3">
        <div class="pricing-header">
          <div class="price"><span>$</span>10</div>
          <div class="title">SLippers</div>

        </div>
				 <div class= "noOfItem3">
				Total number
				<br>
				<select class="form-control3" name = "slippersno">
					<option value="0">0</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					</select>
		  </div>
        <img src="/resources/images/slippers.jpg" alt="Smiley face" height="250" width="300">
        
      </div>
      <input type="hidden" id="flightcharge" name="flightCharge" value="${flightbean.getFlightCharge()}" >
	  <input type="hidden" id="flightId" name="flightId" value="${flightbean.getFlightId()}" >
   	  <input type="hidden" id="noOfSeats" name="noOfSeats" value="${flightbean.getAeroplaneBean().getNoofSeats()}" >
	  <input type="hidden" id="destAirportName" name="destAirportName" value="${flightbean.getDestinationAirport().getAirportName()}" >
   	  <input type="hidden" id="fromAirportName" name="fromAirportName" value="${flightbean.getFromAirport().getAirportName()}" >
	  <input type="hidden" id="aeroplaneId" name="aeroplaneId" value="${flightbean.getAeroplaneId()}" >
	  <input type="hidden" id="noOfPassengers" name="noOfPassengers" value="${noOfPassengers}" >
	  <input type="hidden" id="passengerId" name="passengerId" value="${passengerId}" >
	  		
	  <input type = "submit">
	 
    </div>
    
	</form>
  </body>
</html>
