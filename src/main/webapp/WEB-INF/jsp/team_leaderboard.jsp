<!DOCTYPE html>
<html lang="en">

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



</head>

<body>

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
				<a class="navbar-brand" href="index.html">IPL Fantasy League</a>
			</div>
			<!-- /.navbar-header -->
			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i> User
								Profile</a></li>
						<li class="divider"></li>
						<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>
								Logout</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" id="getmatch"
									placeholder="Enter MatchDate/TeamName"> <span
									class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div> <!-- /input-group -->
						</li>
						<li><a href="bidder.html"><i
								class="fa fa-dashboard fa-fw"></i> Dashboard</a></li>
						<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
								Matches<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="today.html">Today's Match</a></li>
								<li><a href="upcoming.html">Upcoming Matches</a></li>
								<li><a href="reschedule.html">Rescheduled Matches</a></li>
								<li><a href="match_history.html">Match History</a></li>
							</ul> <!-- /.nav-second-level --></li>
						<li><a href="bidder_leaderboard.html"><i
								class="fa fa-table fa-fw"></i> Bidder Leaderboard</a></li>
						<li><a href="team_leaderboard.html"><i
								class="fa fa-table fa-fw"></i> Team Leaderboard</a></li>
		</nav>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h2 class="page-header">Team Leaderboard</h2>
				</div>
				<!-- /.col-lg-12 -->
			</div>

			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<div class="panel panel-primary">
					<div class="panel-heading"></div>
					<div class="panel-body">
						<table width="100%"
							class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<table class="table table-bordered table-hover">

								<table class="table table-bordered table-hover">
									<thead>
										<tr>
											<th id="tid">Team ID</th>
											<th id="tname">Team Name</th>
											<th id="tpoints">Team Points</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>ABC</td>
											<td>10</td>
										</tr>
										<tr>
											<td>2</td>
											<td>XYZ</td>
											<td>2</td>
										</tr>
										<tr>
											<td>3</td>
											<td>PQR</td>
											<td>14</td>
										</tr>
										<tr>
											<td>4</td>
											<td>LMN</td>
											<td>6</td>
										</tr>

									</tbody>
								</table>

								</div>


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
