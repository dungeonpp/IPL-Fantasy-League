<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<style type="text/css">
.panel {
	width: 50%;
	margin-right: 100px;
	margin-left: 400px;
	margin-top: 100px;
}

p {
	color: red;
}
</style>
<title>Edit Profile</title>

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
</style>

</head>

<body ng-app="">
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
					<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
							Matches<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="bidderDashboard">Upcoming Matches</a></li>


						</ul> <!-- /.nav-second-level --></li>
					<li><a href="showLeaderBoard"><i class="fa fa-table fa-fw"></i>
							Bidder Leaderboard</a></li>
	</nav>
	<div id="page-wrapper"
		style="background-image: url('<%=request.getContextPath()%>/resources/image/bg2.jpg');">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-primary"
					style="margin: auto; margin-top: 30px;">
					<div class="panel-heading">
						<h3>
							<b>Edit Profile</b>
						</h3>
					</div>
					<div class="panel-body">
						<form class="myForm" name="userForm" role="form"
							ng-init="myName = 'Ronn';myEmail = 'ronmatt11@gmail.com';myMobile = 9890786788"
							action="editProfile" method="POST">
							<div class="row">
								<div class="col-lg-9">
									<div class="form-group">
										<label>Bidder Name</label> <input class="form-control"
											type="text" name="bidderName" ng-model="myName" required />
										<span
											ng-show="userForm.bidderName.$touched && userForm.bidderName.$error.required"><p>Please
												enter username</p></span>
									</div>

									<div class="form-group">
										<label>Email</label> <input class="form-control" type="email"
											name="emailId" ng-model="myEmail" ng-init="abc@gmail.com"
											required /> <span
											ng-show="userForm.emailId.$touched && userForm.emailId.$error.required"><p>Please
												enter email</p></span> <span
											ng-show="userForm.emailId.$touched && userForm.emailId.$error.email"><p>Invalid
												email</p></span>
									</div>

									<div class="form-group">
										<label>Password</label> <input class="form-control"
											type="password" name="password" ng-model="password"
											placeholder="Enter password" ng-minlength="6"
											ng-maxlength="10" required> <span
											ng-show="userForm.password.$touched && userForm.password.$error.required"><p>Please
												enter password</p></span> <span
											ng-show="userForm.password.$touched && userForm.password.$error.minlength"><p>Please
												enter min 8 characters</p></span> <span
											ng-show="userForm.password.$touched && userForm.password.$error.maxlength"><p>Password
												is too long</p></span>
									</div>

									<div class="form-group">
										<label>Mobile</label> <input class="form-control" type="text"
											name="mobile" ng-model="myMobile" ng-pattern="/^[0-9]{10}$/"
											required> <span
											ng-show="userForm.mobile.$touched && userForm.mobile.$error.required"><p>Please
												enter mobile number</p></span> <span
											ng-show="userForm.mobile.$touched && userForm.mobile.$error.pattern"><p>Invalid
												mobile</p> </span>
									</div>
									<div>
										<a href="userProfile">
											<button type="button" class="btn btn-primary"
												ng-disabled="userForm.$invalid">Save</button>
										</a>&nbsp;
										<button type="reset" class="btn btn-primary">Reset</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>

