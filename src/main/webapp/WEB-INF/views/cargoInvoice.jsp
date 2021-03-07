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
	
	
	  <b>Receiver Email &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</b><label id="l1">&ensp; ${receiveremail}</label><br><br>
	  <b>Loading Date    &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&nbsp</b><label id="l2">&nbsp;&nbsp;&nbsp;&nbsp; ${loadingDate}</label><br><br>
	  <b>Delivery Address &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>   <label id="l1">&ensp; ${destaddress}</label><br><br>
	  <b>Total amnt. &nbsp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</b>   <label id="l1">&ensp; $${totalprice}</label><br>
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