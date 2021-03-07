

<!DOCTYPE html>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1"> <!--- This is used so that website is usable on mobile phones -->
  <!--- Gonna make ajax, cdn and bootstrap imports -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="/resources/cssFiles/Home2Style.css" rel="stylesheet">
<title>GET WINGS</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
			<!--<a class="navbar-brand" href="#"><img src="logo.png" width="00" height="100" alt="Hereimg"></a>-->
			<a class="navbar-brand" href="#"><span class="glyphicon glyphicon-plane"></span> GET WINGS</a>
			</div>
			<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home </a><li>
			<li> <a href="#">Book Flight</a><li>
			<li> <a href="#">View Schedule</a><li>		
			<li> <a href="#">Current Status</a><li>			
			<li> <a href="#">Transport Cargo</a><li>
			</ul>
			<ul class = "nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-earphone"></span> Contact Us</a></li>
			<li><a href="Home1"> Sign Up</a></li>
			<li><a href="welcome.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			<li><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span>
			<span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="#">View My Bookings</a></li>
				<li><a href="#">Cancel Ticket</a></li>
				<li><a href="#">Edit ticket details</a></li>
				<li><a href="#">Update Contact Details</a></li>
				<li><a href="#">Edit Shipment details</a></li>
				<li><a href="#">LogOut</a></li>
				</li>
			</ul>
			</ul>
		</div>
	</nav>
	<h3>Secrets hiding in a webpage</h3>

<div class="container">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>
    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="/resources/images/carou1.jpg" alt="Chicago" style="width:100%; height: 550px;">
		<div class="carousel-caption">
		<h1 class="display-1">Faster Delivery</h1>
		</div>
      </div>

      <div class="item">
        <img src="/resources/images/carou2.jpg" alt="Chicago" >
		<div class="carousel-caption">
		<h1 class="display-2" id="1ees">Unmatchable Service</h1>
		</div>
      </div>
    
      <div class="item">
        <img src="/resources/images/carou3.jpg" alt="Chicago" style="width:100%; height: 550px;">
		<div class="carousel-caption">
		<h1 class="reet" id="2ees">Get Today</h1>
		</div>
      </div>
	  
	  <div class="item">
		<img src="/resources/images/carou4.jpg" alt="Chicago" style="width:100%; height: 550px;">
		<div class="carousel-caption">
		<h1 class="display-4" id="3ees">Fly to the places</h1>
		</div>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<div class ="container-fluid">
<div class = "row jumbotron">
	<div class = "col xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
		<p class = "lead"> WE are a better website in terms of response and additional features such as Transport and merchandise purchase</p>
	</div>
	<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
		<a href = "#"><button type = "button" class = "btn btn-outline-secondary btn-lg">Fly Now</button></a>
	</div>
</div>
</div>
<footer>
<div class = "container-fluid padding">
<div class = "row text-center">
	<div class = "col-md-4">
		<img src="/resources/images/Product.jpeg" style="height: 90px;">
		<hr class = "light">
		<p>555-555-5555</p>
		<p>email@yemail.com</p>
		<p>100 street home</p>
		<p>city, state, 00000</p>
	</div>
	<div class = "col-md-4">
		<hr class = "light">
		<h5> Our Hours</h5>
		<hr class = "light">
		<p> Monday: 9am - 5 pm</p>
		<p> Saturday: 10am - 4 pm</p>
		<p> Sunday: closed</p>
	</div>	
		<div class = "col-md-4">
		<hr class = "light">
		<h5> Our Hours</h5>
		<hr class = "light">
		<p> city, state, 00000</p>
		<p> city, state, 00000</p>
		<p> city, state, 00000</p>
		<p> city, state, 00000</p>
	</div>	
	<div class="col-12">
		<hr class = "light">
		<h5>&copy: GetWings.com</h5>
	</div>	
</div>
</div>		
</body>
</html>