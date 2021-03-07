<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>
</head>
<script>
	
function Validate() {
	

    var c = /^[a-zA-Z ]+$/; 
    var cardValidate= /^\d{16}$/;
    var addValidate = /^[a-zA-Z0-9\s, '-]*$/;
    var fullname = document.getElementById("fname").value;
    var email = document.getElementById("email").value;
    var address = document.getElementById("address").value;
    var nameoncard = document.getElementById("cname").value;
	var city = document.getElementById("city").value;
	var cardnum = document.getElementById("cardnum").value;
	var cvv = document.getElementById("cvv").value;
	var expiryyear = document.getElementById("expyear").value;
    if(fullname.match(c))
	      true ;
    else
   	{
	  alert("Enter a valid name");
	  return false ;
	}
    
    if(nameoncard.match(c))
	      true ;
    else
   	{
	  alert("Enter a valid card holder name");
	  return false ;
	}
    
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))
	       true;
	   else
	   {
	      alert("You have entered an invalid email address!");
	      return false;
	  }
    
    if(address.match(addValidate))
    	true;
    else{
	      alert("You have entered an invalid address!");
	      return false;
    }


    if(city.match(c))
    	 true;
    else{
	    alert("You have entered an invalid city!");
    	return false;
    }	
    if(city.match(c))
    	 true;
    else{
	    alert("You have entered an invalid state!");
    	return false;
    }	
    	
   	if ((cardnum.match(cardValidate)))
   			true;
   	else{
    	alert("card no. is not valid!!");
    	return false;
   	}	    	
   	if ((expiryyear.match(/^\d{4}$/)))
   		true;
   	else{
    	alert("enter valid expiry year");
		return false;
	}

   	if ((cvv.match(/^\d{3}$/)))
		true;
   	else{
   		alert("cvv must be three digit only");
   		return false;
   	}
}r

</script>
<body>

<h2>Responsive Checkout Form</h2>
<form onsubmit="return Validate();" action = "invoiceInitial" method="POST">
<div class="row">
  <div class="col-75">
    <div class="container">      
        <div class="row">
          <div class="col-50">
            <h3>Billing Address</h3>
            <label for="fname"><i class="fa fa-user"></i> Full Name</label>
            <input type="text" id="fname" name="firstname" placeholder="" maxlength="50" required>
            <label for="email"><i class="fa fa-envelope"></i> Email</label>
            <input type="text" id="email" name="emaill" placeholder="" maxlength="80"  required>
            <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
            <input type="text" id="address" name="address" placeholder="" maxlength="125"  required>
            <label for="city"><i class="fa fa-institution"></i> City</label>
            <input type="text" id="city" name="city" placeholder="" required maxlength="50" >


          </div>

          <div class="col-50">
            <h3>Payment</h3>
            <label for="fname">Accepted Cards</label>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>
            <label for="cname">Name on Card</label>
            <input type="text" id="cname" name="cardname" placeholder="John More Doe">
            <label for="ccnum">Credit card number</label>
            <input type="text" id="cardnum" name="cardnumber" placeholder="" maxlength = "16" minlength = "16" required>
            <div class="row">
              <div class="col-50">
                <label for="expyear">Exp Year</label>
                <input type="text" id="expyear" name="expyear" placeholder="2018" maxlength = "4" minlength = "4" required>
              </div>
              <div class="col-50">
                <label for="cvv">CVV</label>
                <input type="text" id="cvv" name="cvv" placeholder="352" maxlength = "3" minlength = "3" required>
              </div>
            </div>
          </div>
      <input type="hidden" id="flightcharge" name="flightCharge" value="${flightbean.getFlightCharge()}" >
	  <input type="hidden" id="flightId" name="flightId" value="${flightbean.getFlightId()}" >
   	  <input type="hidden" id="noOfSeats" name="noOfSeats" value="${flightbean.getAeroplaneBean().getNoofSeats()}" >
	  <input type="hidden" id="destAirportName" name="destAirportName" value="${flightbean.getDestinationAirport().getAirportName()}" >
   	  <input type="hidden" id="fromAirportName" name="fromAirportName" value="${flightbean.getFromAirport().getAirportName()}" >
	  <input type="hidden" id="aeroplaneId" name="aeroplaneId" value="${flightbean.getAeroplaneId()}" >
	  <input type="hidden" id="noOfPassengers" name="noOfPassengers" value="${noOfPassengers}" >
	  <input type="hidden" id="passengerId" name="passengerId" value="${passengerId}" >
	  <input type="hidden" id="totalamount" name="totalamount" value="${flightprice + slipperprice + eyecoverprice + neckpillowprice}" >
        </div>
        <label>
          <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
        </label>
        <input type="submit" value="Continue to checkout" class="btn">
    </div>
  </div>
  <div class="col-25">
    <div class="container">
      <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b>4</b></span></h4>
      <p><a href="#">Ticket Price</a> <span class="price">$${flightprice}</span></p>
      <p><a href="#">Slippers Price</a> <span class="price">$${slipperprice}</span></p>
      <p><a href="#">Eye cover price</a> <span class="price">$${eyecoverprice}</span></p>
      <p><a href="#">Neck Pillow Price</a> <span class="price">$${neckpillowprice}</span></p>
      <hr>
      <p>Total <span class="price" style="color:black"><b>$${flightprice + slipperprice + eyecoverprice + neckpillowprice}</b></span></p>
    </div>
  </div>
</div>
</form>

</body>
</html>
