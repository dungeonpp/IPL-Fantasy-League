<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>


<head>
<meta charset="utf-8" />
<title>IPL Fantasy League</title>

<meta content="" name="author" />
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<link
	href="<%=request.getContextPath()%>/resources/assets/css/material/styles.min.css"
	rel="stylesheet" type="text/css">
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/assets/css/material/styles.min.css"
	rel="stylesheet" type="text/css">




</head>
<body class="preload" ng-app="">
	<nav class="homenav">
		<div class="nav-wrapper home-width">
			<div class="row">
				<div class="col m6 l6">
					<a href="addMatch" class="brand-logo hm-logo"> <!-- <img src="assets/images/material/logo.png" alt="Daily Fantasy Cricket | The Best Fantasy Cricket Website"> -->
						<h3>
							IPL |<span style="color: #4FA812;"> Fantasy |</span> League
						</h3>
					</a>
				</div>
				<div class="col m6 l6">
					<form method="post" action="dashboard">
						<div class="row">
							<div class="hm-login">
								<div class="input-field col m5 4">
									<input id="email" placeholder="Email/Username" type="text"
										name="email" value="">
								</div>
								<div class="input-field col m5 5">
									<input id="password" placeholder="Password" autocomplete="off"
										name="password" value="" type="password" required>
								</div>
								<%-- <%if((request.getAttribute("loginResult")=="true") &&(request.getAttribute("loginResult")!=null));{%>
									 <p>Login Failed </p>
									<%}%> --%>

								<div class="input-field col m2 1">
									<button class="btn waves-effect waves-light right"
										type="submit" name="action">LOGIN</button>
								</div>
							</div>
						</div>
						<h5>
							<br>
							<%
								if (request.getAttribute("message") != null)
									out.println(request.getAttribute("message"));
							%>
							
					
						</h5>
						<div class=" row hm-login-rme">
							<div class="col m6 l5">
								<p>
									<input type="checkbox" name="remember" value="1"
										class="filled-in" id="remember" />

								</p>
							</div>
							<div class="col m6 l7"></div>
						</div>
					</form>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</nav>
	<section class="home-first-section">
		<div class="home-width">
			<div class="row">
				<div class="col m6 l7">
					<h1>
						PLAY FANTASY League <br> <span>And experience the
							thrill!</span>
					</h1>

				</div>
				<div class="col m6 l5">
					<div class="hm-register-holder">
						<section class="auth-box">
							<form method="post" action="registerBidder" name="regForm">
								<input type="hidden" name="dfc_csrf"
									value="d31274394a5199f4f9ba449246ab1c3a">
								<div class="auth-right">
									<h5>Register here and</h5>
									</br>
									<h5>Play instantly</h5>
									<div class="row auth-social-login"></div>

									<div class="input-field">
										<input id="user_name_r" type="text" value="" name="bidderName"
											autocomplete="off" required> <label for="user_name_r">
											Name *</label>

									</div>

									<div class="input-field">
										<input id="user_email_r" type="email" name="email" value=""
											autocomplete="off"
											ng-pattern="/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i"
											ng-model="email" required> <label for="user_email_r">Email
											*</label> <span
											ng-show="regForm.email.$touched && regForm.email.$error.required"><p
												style="color: red;">Please enter email Id</p></span> <span
											ng-show="regForm.email.$error.pattern"><p
												style="color: red;">Please Enter a valid Email-ID
												containing '@' and '.'</span>
									</div>

									<div class="input-field">
										<input id="user_password_r" name="password" value=""
											type="password" autocomplete="off" required> <label
											for="user_password_r">Password *</label>
									</div>

									<div class="input-field">
										<input id="user_password_r" name="mobile" value="" type="text"
											ng-model="mobile" ng-pattern="/^[7-9]{1}[0-9]{9}$/"
											autocomplete="off" required> <label
											for="user_password_r">Mobile *</label> <span
											ng-show="regForm.mobile.$touched && regForm.mobile.$error.required"><p
												style="color: red;">Please enter mobile</p></span> <span
											ng-show="regForm.mobile.$touched && regForm.mobile.$error.pattern"><p
												style="color: red;">Invalid mobile number</p> </span>
									</div>

									<div class="reg-captcha">
										<div class="g-recaptcha"
											data-sitekey="6LefOxAUAAAAALt6tt7droXB3gri9fBnSBRyJ6NS"
											style="transform: scale(0.60); -webkit-transform: scale(0.60); transform-origin: 0 0; -webkit-transform-origin: 0 0;">
										</div>
									</div>
									<div class="reg-agree">
										<p>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												name="termsCondition" value="1" />
										</p>
									</div>

									<div class="row">
										<div class="col s12 m12 l12">
											<button class="btn waves-effect waves-light right"
												type="submit" name="action" style="width: 100%">REGISTER</button>
										</div>
									</div>


								</div>
							</form>
						</section>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!--Import jQuery before materialize.js-->
	<script
		src="<%=request.getContextPath()%>/resources/assets/js/jquery-1.8.3.min.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/assets/js/material/dfcscript.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/assets/js/flipclock.js"></script>
	<script type="text/javascript">
		var clock;

		$(document).ready(function() {
			clock = $('.clock').FlipClock(65482, {
				countdown : true
			});
		});
	</script>
	<script type="text/javascript">
		window.onload = function() {
			setInterval(function() {
				$(".loader").fadeOut("slow");
				$("body").removeClass("preload");
				//$("preload").css("display", "none");
			}, 100);
		};
	</script>
</html>

