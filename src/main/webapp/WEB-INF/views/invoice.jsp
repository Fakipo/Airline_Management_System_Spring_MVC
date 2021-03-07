<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
   <title>Invoice</title>
   <link rel="stylesheet" href="/resources/cssFiles/invoiceStyle.css">
</head>
<body>

 <div class="Invoicebox">
	
  
	<h2><u>Invoice</u></h2>
	<p></p>
	
	<form onsubmit="myFunction()" action = "theend">
	
	  <b>Email &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;	</b><label id="l1" name="l1">&ensp; ${email}</label><br><br>
	  <b>from    &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</b><label id="l2" name="l2">&nbsp;&nbsp;&nbsp;&nbsp;${fromairport}</label><br><br>
	  <b>to. &ensp;&ensp;&ensp;&ensp;&nbsp;&nbsp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</b>   <label id="l3" name="l3">&ensp; ${toairport}</label><br><br>
	  <b>Booking Date  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><label id="l4" name="l4">&nbsp; ${bookingdate}</label><br><br><br><br>
	  <b>Flight Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>   <label id="l5" name="l5">&ensp; ${flighttime} IST</label><br><br>
	  <b>Flight no. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>   <label id="l6" name="l6">&ensp; ${18700000 + flightId}</label><br><br>
	  <b>Seat No. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>   <label id="l7" name="l7">&ensp; ${seatno}</label><br><br>
	  <b>Total amnt. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>   <label id="l8" name="l8">&ensp; $${totalamount}</label><br>
		<input type="submit" name="" value="Print">
		
	</form>
</div>
<script>
function myFunction() {
  window.print();
}
</script>
</body>
</html>