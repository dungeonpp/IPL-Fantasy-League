<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <style type="text/css">
      p{color:red;}  
    </style>
    <title>Update Profile </title>

    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    .panel{width: 50%;margin-right: 100px;margin-left: 400px;margin-top:100px;}
    </style>

</head>

<body ng-app="">
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                          <h3><b>Bidder Registration Form</b></h3> 
                        </div>
                        <div class="panel-body">
                        <form class="myForm" name="userForm">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="BidderRegistrationProcess.jsp" method="POST">
                                        <div class="form-group">
                                            <label>Bidder Name</label>
                                            <input class="form-control" name="bidderName" ng-model="bidderName" placeholder="Enter name" required>
                                            <span ng-show="userForm.bidderName.$touched && userForm.bidderName.$error.required"><p>Please enter username</p></span>
                                        </div>

                                        <div class="form-group">
                                            <label>Email</label>
                                            <input class="form-control" type="email" name="emailId" ng-model="emailId" placeholder="Enter email" required="">
                                            <span ng-show="userForm.emailId.$touched && userForm.emailId.$error.required"><p>Please enter email</p></span>
                                            <span ng-show="userForm.emailId.$touched && userForm.emailId.$error.email"><p>Invalid email</p></span>
                                        </div>

                                        <div class="form-group">
                                            <label>Password</label>
                                            <input class="form-control" type="password" name="password" ng-model="password" placeholder="Enter password" ng-minlength="6" ng-maxlength="10" required>
                                            <span ng-show="userForm.password.$touched && userForm.password.$error.required"><p>Please enter password</p></span>
                                            <span ng-show="userForm.password.$touched && userForm.password.$error.minlength"><p>password length invalid</p></span> 
                                            <span ng-show="userForm.password.$touched && userForm.password.$error.maxlength"><p>password length invalid</p></span>
                                        </div>

                                        <div class="form-group">
                                            <label>Mobile</label>
                                            <input class="form-control" type="number" name="mobile" ng-model="mobile" placeholder="Enter contact number" ng-pattern="/^[0-9]{10}$/" required>
                                            <span ng-show="userForm.mobile.$touched && userForm.mobile.$error.required"><p>Please enter mobile</p></span>
                                            <span ng-show="userForm.mobile.$touched && userForm.mobile.$error.pattern"><p>Invalid mobile</p> 
                                            </span>
                                        </div>
                                        <div>
                                            <button type="submit" class="btn btn-primary">Submit</button>
                                            <button type="reset" class="btn btn-primary" >Reset</button>
                                        </div>
                                        
                                        </form>
                                
                            
                        </div>
                    </div>
                </div>
            </div>
            
</body>
</html>

                                    