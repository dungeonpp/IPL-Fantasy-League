<%@page import="com.service.serviceimpl.BidderServiceImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">


<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<%=request.getContextPath()%>/resources/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<style type="text/css">
.container {
	/*background-image:url("<%=request.getContextPath()%>/resources/ground1.png");*/
	background-color: #f0f0f0;
}

input {
	text-align: center;
	font-family: Times New Roman;
	font-weight: bolder;
}

#mi {
	display: block;
	margin: auto;
}

#vs {
	display: block;
	margin-left: 100px;
}

#rcb {
	display: block;
	margin: auto;
}

#team1 {
	margin-left: auto;
}

#team2 {
	margin-left: auto;
}

#checkbox1 {
	margin-left: 80px;
}

#checkbox2 {
	margin-left: 100px;
}

#teamA {
	margin-left: 0px;
}

#teamB {
	margin-left: 0px;
}
</style>

<style>
/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 50px 0 310px;
	border: none;
	cursor: pointer;
	width: 10%;
}

button:hover {
	opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
	margin-left: 0px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 50%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}

.active {
	pointer-events: none;
	cursor: default;
}
</style>




<script type="text/javascript">
	function buttonChange() {
		var elem = document.getElementById("myButton1");
		elem.value = "Reschedule Match";
	}
</script>

<script>
	var myVar = setInterval(myTimer, 1000);
	function myTimer() {
		var d = new Date();
		document.getElementById("demo").innerHTML = d.toLocaleTimeString();
		var d1 = new Date();
		document.getElementById("demo1").innerHTML = d1.toLocaleTimeString();
	}
</script>



</head>

<body>
	<%@page import="com.model.* "%>
	<%@page import="com.service.* "%>
	<%@page import="java.util.* "%>

	<div id="wrapper">


		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">Admin Dashboard</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">



			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">


					<li class="divider"></li>
					<li><a href="index.html"><i class="fa fa-sign-out fa-fw"></i>
							Logout</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">

					<li><a href="admindashboard"><i
							class="fa fa-dashboard fa-fw"></i> Dashboard</a></li>
					<%-- <% ArrayList<Team> teamList =(ArrayList<Team>)request.getAttribute("team");
					if(teamList.size()!=0);
					{%>
						 --%>
					<li><a href="matchHistory"><i
							class="fa fa-dashboard fa-fw"></i> Previous Matches </a></li>

					<li><a href="endTournament"><i
							class="glyphicon glyphicon-ok-circle"></i> End Tournament</a></li>
				</ul>
			</div>
		</div>
		</nav>



		<div id="page-wrapper" style="background-color: #f0f0f0;">
			<!-- small container color -->


			<div class="container">


				<%
					ArrayList<Match> matchList = (ArrayList<Match>) request.getAttribute("matches");
					if (matchList.size() != 0)
						;
					{
						for (Match match : matchList) {
							if (!match.getMatchWinner().equalsIgnoreCase("Draw") && (match.getMatchWinner() != null))
								;
							{
				%>
				<div class="col-lg-9" style="margin-top: 50px; margin-left: 50px;">

					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="panel-title pull-left">Previous Matche's
								Results</div>
							<div class="panel-title pull-right">
								<p id="demo"></p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-4">
									<img
										src="<%=request.getContextPath()%>/resources/image/<%out.print(match.getTeam1().getTeamId());%>.jpg"
										class="img-circle" id="mi" width="200" height="150">
									<center>
										<h3>
											<%
												out.print(match.getTeam1().getTeamName());
											%>
										</h3>
								</div>

								<div class="col-lg-3">
									<img src="<%=request.getContextPath()%>/resources/image/vs.png"
										id="vs" width="50" height="50"
										style="margin-top: 50px; margin-right: 20px;">
								</div>
								<div class="col-lg-4">
									<img
										src="<%=request.getContextPath()%>/resources/image/<%out.print(match.getTeam2().getTeamId());%>.jpg"
										class="img-circle" id="rcb" width="200" height="130"> <br>
									<center>
										<h3>
											<%
												out.print(match.getTeam2().getTeamName());
											%>
										</h3>
								</div>
								<div class="col-lg-12">
									<center>
										<b><h3 style="color: blue;">
												<%
													out.print(match.getMatchWinner());
												%>,Won the Match
											</h3></b>
									</center>
								</div>
							</div>
						</div>



					</div>
				</div>
				<%
					}
						}
				%>
				<%
					if (matchList.size() == 0) {
				%>
				<h3>No Previous Matches Played</h3>

				<%
					}
					}
				%>

			</div>


		</div>

	</div>




	<div id="id01" class="modal">

		<form class="modal-content animate" action="MatchResult.html">


			<div class="col-lg-9" style="margin-top: 0px; margin-left: 70px;">
				<div class="panel panel-primary"></div>
			</div>



			<div class="col-lg-9" style="margin-top: 50px; margin-left: 100px;">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="panel-title pull-left">Declare winner Team of
							Match</div>

						<div class="panel-title pull-right"></div>
						<div class="clearfix"></div>
					</div>
					<div class="panel-body">

						<div class="row">
							<div class="col-lg-6">
								<!--   <img src="mi.jpg" class="img-circle" id="mi" width="200" height="150"> -->
								<input type="radio" name="Team1" id="checkbox1" value="Team1">
								<!-- name should be same for radio -->
								<input class="form-control" id="team1" type="text"
									value="Mumbai Indians" readonly="readonly">
							</div>




							<div class="col-lg-6 ">
								<!--  <img src="rcb.png" class="img-circle" id="rcb" width="200" height="150">  -->
								<input type="radio" name="Team1" id="checkbox2" value="Team2">
								<input class="form-control" id="team2" type="text"
									value="Royal Challengers Bangalore" readonly="readonly">
							</div>
						</div>
					</div>
					<div class="panel-footer" style="text-align: center;">
						<a href="declareWinner" class="btn btn-info btn-lg" role="button"
							style="width: 200px; background-color: green;">Select Winner
							Team</a>
					</div>

				</div>
			</div>




		</form>
	</div>

	<script>
		// Get the modal
		var modal = document.getElementById('id01');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/dist/js/sb-admin-2.js"></script>
</body>

</html>
