<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>Booking Form</title>
	<script>
	function validate() {
	    var from = document.getElementById("from");
	    var fromText = from.options[from.selectedIndex].text;
	    var destination = document.getElementById("destination");
	    var destinationText = destination.options[destination.selectedIndex].text;


    var result = fromText.localeCompare(destinationText);
    if(result == 0)	{
    	alert("cannot have same values in both from and to"); 
		return false;
    }else{    	
    	return true;
    }
    }
	
	function errorHandling(){
		var errorHandling = "$errorHandling";
		if(errorHandling != "null")	{
			alert("There seems to be some problem, please try again");
		}
	}
	  window.onload = function() {
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
	

	</script>
	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=PT+Sans:400" rel="stylesheet">

	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css" />

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="/resources/cssFiles/flightSearchStyle.css" />

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>	
<form id="searchflights" onsubmit="return validate();" action="searchFlights" method="get">
	<div id="booking" class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="booking-form">
						<form>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<span class="form-label">Flying from</span>
										<select class="form-control" name = "from" id="from" >
											<c:forEach items="${cityNameList}" var="name">
												   <option value="${name}">${name}</option>
											</c:forEach>					
										</select>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<span class="form-label">Flying to</span>
										<select class="form-control" name = "destination" id="destination" >
											<c:forEach items="${cityNameList}" var="name">
												   <option value="${name}">${name}</option>
											</c:forEach>						
										</select>			
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<span class="form-label">Departing</span>
										<input class="form-control" name="flightDate" type="date" id = "theDate" min = "2020-8-24" required>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">
									<div class="form-btn">
										<button class="submit-btn" >Show flights</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>