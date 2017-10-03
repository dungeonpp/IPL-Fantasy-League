
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Bid Match</title>

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
input {
	text-align: center;
	font-family: Times New Roman;
	font-weight: bolder;
}

#mi {
	display: block;
	margin-left: 70px;
}

#vs {
	display: block;
	margin-left: 100px;
}

#rcb {
	display: block;
	margin-left: 200px;
}

#team1 {
	margin-left: 50px;
}

#team2 {
	margin-left: 200px;
}

#checkbox1 {
	margin-left: 180px;
}

#checkbox2 {
	margin-left: 300px;
}
</style>
</head>

<body>



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
			<a class="navbar-brand" href="bidder_index.html">IPL Fantasy
				League</a>
		</div>
		<!-- /.navbar-header -->
		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="userProfile"> <i
					class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="userProfile"><i class="fa fa-user fa-fw"></i>
							User Profile</a></li>
					<li class="divider"></li>
					<li><a href="index"><i class="fa fa-sign-out fa-fw"></i>
							Logout</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<!-- <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Enter MatchDate/TeamName" > 
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                           
                        </li> -->
					<li><a href="bidderDashboard"><i
							class="fa fa-dashboard fa-fw"></i> Dashboard</a></li>
					<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
							Matches<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="bidderDashboard">Upcoming Matches</a></li>
							<!--             <li>
                                    <a href="matchHistory.html">Match History</a>
                                </li> -->

						</ul> <!-- /.nav-second-level --></li>
					<li><a href="bidderLeaderBoard"><i
							class="fa fa-table fa-fw"></i> Bidder Leaderboard</a></li>
	</nav>


	<div id="page-wrapper"
		style="background-image: url('<%=request.getContextPath()%>/resources/image/bg2.jpg');">
		<!-- small container color -->


		<div class="container">

			<div class="col-lg-9"
				style="margin-top: 0px; margin-left: 50px; height: 0px;">
				<!-- height- if two matches -->
				<div class="panel panel-primary"></div>
			</div>



			<div class="col-lg-9" style="margin-top: 100px; margin-left: 50px;">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="panel-title pull-left">Select your team</div>

						<div class="panel-title pull-right">
							<p id="demo1"></p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="panel-body">
						<form name="form1" method="POST">
							<div class="row">
								<div class="col-lg-4">
									<img src="<%=request.getContextPath()%>/resources/image/1.jpg"
										class="img-circle" id="mi" width="200" height="150"> <input
										type="radio" name="Team1" id="checkbox1"
										value="Mumabai Indians"> <input class="form-control"
										id="team1" type="text" value="Mumbai Indians"
										readonly="readonly">
								</div>




								<div class="col-lg-4">
									<img src="<%=request.getContextPath()%>/resources/image/2.jpg"
										class="img-circle" id="rcb" width="200" height="150"> <input
										type="radio" name="Team1" id="checkbox2"
										value="Royal Challengers Bangalore"> <input
										class="form-control" id="team2" type="text"
										value="Royal Challengers Bangalore" readonly="readonly">
								</div>
							</div>
							<div class="panel-footer" style="text-align: center;">
								<a href="bidderDashboard" class="btn btn-info btn-lg"
									role="button" onclick="myFunction()"
									style="width: 200px; background-color: green;">Confirm</a>
							</div>
						</form>
					</div>


				</div>
			</div>



		</div>
	</div>

	<script type="text/javascript">
function myFunction()
{
var group = document.form1.Team1;
for (var i=0; i<group.length; i++) {
if (group[i].checked)
break;
}
if (i==group.length)
return alert("No radio button is checked");
alert("Radio Button " + (i+1) + " is checked.");
}
</script>


	<script src="../vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../dist/js/sb-admin-2.js"></script>
</body>

</html>