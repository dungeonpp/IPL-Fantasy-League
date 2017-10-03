<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>BidderIndex</title>

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
}

#mi {
	display: block;
	margin: auto;
}

#vs {
	display: block;
	margin: auto;
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
</style>
</head>

<body ng-app="" >
	<%@page import="com.model.* "%>
	<%@page import="java.util.* "%>



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
			<a class="navbar-brand" href="bidderDashboard">IPL Fantasy League</a>
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

					<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>
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
					<li>
						<!-- /.nav-second-level -->
					</li>
					<li><a href="showLeaderBoard"><i class="fa fa-table fa-fw"></i>
							Bidder Leaderboard</a></li>
	</nav>



	<div id="page-wrapper">
		<div class="row">


			<div class="col-lg-8" style="margin-top: 50px;">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<i class="fa fa-bell fa-fw"></i> <b>TEAM STANDINGS</b>
					</div>

					<div class="row">

						<div class="col-lg-12">
							<div class="panel panel-default">


								<div class="panel-body" style="overflow-y: auto; height: 350px;">
									<div class="table-responsive">

										<table class="table table-striped table-bordered table-hover">

											<thead>
												<tr>

													<th>Team</th>
													<th>Points</th>
												</tr>
											</thead>

											<tbody>
												<% ArrayList<Team> teamsList = (ArrayList<Team>)request.getAttribute("teamsList"); 
									   for (Team team: teamsList) { %>
												<tr>
													<td>
														<% out.print(team.getTeamName()); %>
													</td>
													<td>
														<% out.print(team.getTeamPoint()); %>
													</td>

												</tr>
												<% } %>
											</tbody>
										</table>
									</div>

								</div>

							</div>

						</div>

					</div>

				</div>





			</div>


			<form method="post" action="bidOnMatch" name="userForm">


				<%
					ArrayList<Match> matchList = (ArrayList<Match>) request.getAttribute("matches");
					for (Match match : matchList) {
				%>

				<div class="col-lg-8" style="margin-top: 50px;">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="panel-title pull-left">
								<p class="fa fa-calendar"> Schedule Matche's</p>
							</div>
							<div class="panel-title pull-right">Timer</div>
							<div class="clearfix"></div>


						</div>

						<div class="panel-body">
							<div class="row"
								style="display: block; margin: auto; width: 200px;">

								<input class="form-control" type="text"
									value="September 30, 2017 20:15" readonly="readonly">

							</div>
							<div class="row">
								<div class="col-lg-4">
									<img
										src="<%=request.getContextPath()%>/resources/image/<%out.print(match.getTeam1().getTeamId()); %>.jpg"
										class="img-circle" id="mi" width="200" height="150"> <a
										href="bidOnMatch?teamId=<%out.print(match.getTeam1().getTeamId());%>&id=<%out.print(match.getMatchId());%>"
										class="btn btn-info btn-lg" style="float: center"
										role="button"> <%out.print(match.getTeam1().getTeamName()); %>
									</a>

								</div>



								<div class="col-lg-3">
									<img src="<%=request.getContextPath()%>/resources/image/vs.jpg"
										id="vs" width="50" height="50"
										style="margin-top: 50px; margin-right: 20px;">
								</div>
								<div class="col-lg-4">
									<img
										src="<%=request.getContextPath()%>/resources/image/<%out.print(match.getTeam2().getTeamId()); %>.jpg"
										class="img-circle" id="rcb" width="200" height="130"> <br>
									<a
										href="bidOnMatch?teamId=<%out.print(match.getTeam2().getTeamId());%>&id=<%out.print(match.getMatchId());%>"
										class="btn btn-info btn-lg" style="float: center"
										role="button"> <%out.print(match.getTeam2().getTeamName()); %>
									</a> <br>

								</div>
							</div>
						</div>

					</div>

				</div>
				<%
					}
				%>
			
		</div>


		</form>


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
