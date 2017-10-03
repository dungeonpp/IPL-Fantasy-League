<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<script
	src="http://cdn.jsdelivr.net/timepicker.js/latest/timepicker.min.js"></script>
<link
	href="http://cdn.jsdelivr.net/timepicker.js/latest/timepicker.min.css"
	rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>



<style type="text/css">
input {
	text-align: center;
	font-family: Times New Roman;
	border: 2px solid gray;
	font-size: 20px;
	font-weight: bold;
}

#mi {
	display: block;
	margin: auto;
}

#vs {
	display: block;
	margin-left: 80px;
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

<script>
            var myVar = setInterval(myTimer ,1000);
            function myTimer() {
                var d = new Date();
                document.getElementById("demo").innerHTML = d.toLocaleTimeString();
                var d1 = new Date();
                document.getElementById("demo1").innerHTML = d1.toLocaleTimeString();
            }
          
    </script>
</head>

<body ng-app="">
	<%@page import="com.model.* "%>
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
						<li><a href="matchHistory"><i
								class="fa fa-dashboard fa-fw"></i> Previous Matches </a></li>

						<li><a href="endTournament"><i
								class="glyphicon glyphicon-ok-circle"></i> End Tournament</a></li>
					</ul>
				</div>
			</div>
		</nav>




		<div id="page-wrapper">


			<div class="container">
				<% ArrayList<Match> matchList = (ArrayList<Match>)request.getAttribute("matches");
					for (Match match : matchList) { %>
				<div class="col-lg-9" style="margin-top: 20px; margin-left: 50px;">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="panel-title pull-left">Reshedule Match Time</div>
							<div class="panel-title pull-right">
								<p id="demo"></p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="panel-body">
							<div class="row"
								style="width: 300px; margin: auto; display: block;">
								<input type="text" id="matchId" value="1"
									style="visibility: hidden">
								<!--  MatchId insert here  -->
								<input class="form-control" id="team1" type="text"
									value="<%out.print(match.getMatchDateTime());%>"
									readonly="readonly">

							</div>
							<div class="row">
								<div class="col-lg-4">
									<img
										src="<%=request.getContextPath()%>/resources/image/<%out.print(match.getTeam1().getTeamId());%>.jpg"
										class="img-circle" id="mi" width="200" height="150"> <input
										class="form-control" id="team1" type="text"
										value="<%out.print(match.getTeam1().getTeamName());%>"
										readonly="readonly">
								</div>



								<div class="col-lg-3">
									<img src="<%=request.getContextPath()%>/resources/image/vs.jpg"
										id="vs" width="50" height="50"
										style="margin-top: 50px; margin-right: 20px;">
								</div>
								<div class="col-lg-4">
									<img
										src="<%=request.getContextPath()%>/resources/image/<%out.print(match.getTeam2().getTeamId());%>.jpg"
										class="img-circle" id="rcb" width="200" height="130"> <br>
									<input class="form-control" id="team2" type="text"
										value="<%
												out.print(match.getTeam2().getTeamName());
											%>"
										readonly="readonly">
								</div>

								<br />

								<div class="col-lg-4"></div>
								<div class="col-lg-3">
									<% request.setAttribute("id",match.getMatchId()); %>
									<form name="dateForm" action="updateMatch" method="get">
										`
										<!-- <fieldset> -->
										<div class="form-group reschedule-time"
											style="display: block;">
											<input id="rescheduleMatch" class="form-control" name="date"
												ng-model="date" type="text"
												placeholder="Insert new Time here" required> <span
												ng-show="changeDateForm.date.$touched && changeDateForm.date.$dirty && changeDateForm.date.$error.required"><p
													style="color: red;">Please enter Rescheduled Time</p></span>
										</div>

										<button class="btn waves-effect waves-light right"
											type="submit" name="update" style="width: 200px;">Update</button>
										<!-- </fieldset> -->
									</form>
								</div>

							</div>
						</div>
					</div>
					<%} %>
				</div>


			</div>

		</div>

		<script type="text/javascript">


   
var timepicker = new TimePicker('rescheduleMatch', {
  lang: 'en',
  theme: 'dark'
});
timepicker.on('change', function(evt) {
  
  var value = (evt.hour || '00') + ':' + (evt.minute || '00');
  evt.element.value = value;

});

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
