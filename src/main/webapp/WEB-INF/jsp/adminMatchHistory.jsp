<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">


    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath()%>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <style type="text/css">
        input{text-align:center;font-family: Times New Roman; font-weight: bolder;}
        #mi{display:block;margin: auto;}
        #vs{display: block;margin-left:100px;}
        #rcb{display:block;margin:auto;}
        #team1{margin-left: auto;}
        #team2{margin-left: auto;}
        #win{color:green;}
    </style>

</head>

<body>


    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Admin Dashboard</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                
                
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        
                        
                        <li class="divider"></li>
                        <li><a href="index.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        
                        <li>
                            <a href="admin_index.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                         <li>
                            <a href="addTeam.html"><i class="glyphicon glyphicon-plus"></i> Add Teams</a>
                        </li>
                         <li>
                            <a href="addMatch.html"><i class="glyphicon glyphicon-plus"></i> Add Match</a>
                        </li>
                        <li>
                            <a href="#"><i class="glyphicon glyphicon-list"></i> Matches<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                               
                                <li>
                                    <a href="upcomingMatch.html">Upcoming Matches</a>
                                </li>
                                
                                <li>
                                    <a href="adminMatchHistory.html"> Match History</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="addTeam.html"><i class="glyphicon glyphicon-ok-circle"></i> End Tournament</a>
                        </li>
                    </ul>
                </div> 
            </div>                
       </nav>




 <div id="page-wrapper">
            

            <div class="container">
    
                <div class="col-lg-9" style="margin-top: 50px;margin-left: 50px; ">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="panel-title pull-left">
                                 Match History
                             </div>
                            <div class="panel-title pull-right"></div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="panel-body">
                           <div class = "row" style="width: 300px;margin:auto;display: block;">
                                <input type="text" id="matchId" value="1" style="visibility:hidden">  <!--  MatchId insert here  -->
                                <input class="form-control" id="team1" type="text" value="September 30, 2017  20:15" readonly="readonly">

                            </div>
                            <div class = "row">
                                <div class ="col-lg-4">
                                    <img src="<%=request.getContextPath()%>/resources/image/1.jpg" class="img-circle" id="mi" width="200" height="150">
                                    <input class="form-control" id="team1" type="text" value="Mumbai Indians" readonly="readonly">
                                </div>
                                
                            
                            
                                <div class = "col-lg-3">
                                     <img src="<%=request.getContextPath()%>/resources/image/vs.jpg" id="vs" width="50" height="50" style="margin-top: 50px;margin-right: 20px;">
                                </div>
                                <div class = "col-lg-4">
                                     <img src="<%=request.getContextPath()%>/resources/image/2.jpg" class="img-circle" id="rcb" width="200" height="130"> 
                                     <br>
                                     <input class="form-control" id="team2" type="text" value="Royal Challengers Bangalore" readonly="readonly">
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer" style="text-align: center;">
                                <input class="form-control" id="win" type="text" value="Mumbai Indians won the match" readonly="readonly"> 
                        </div> 

                    </div>
                </div>


                  <div class="col-lg-9" style="margin-top: 0px;margin-left: 50px; ">
                    <div class="panel panel-primary">
                        <!-- <div class="panel-heading">
                            <div class="panel-title pull-left">
                                 
                             </div>

                            <div class="panel-title pull-right"><p id="demo1"></p></div>
                            <div class="clearfix"></div>
                        </div> -->
                        <div class="panel-body">
                            <div class = "row" style="width: 300px;margin:auto;display: block;">
                                <input type="text" id="matchId" value="2" style="visibility:hidden;">  <!--  MatchId insert here  -->             <input class="form-control" id="team1" type="text" value="September 30, 2017  20:15" readonly="readonly">
                            </div>
                            <div class = "row">
                                <div class ="col-lg-4">
                                    <img src="<%=request.getContextPath()%>/resources/image/1.jpg" class="img-circle" id="mi" width="200" height="150">
                                    <input class="form-control" id="team1" type="text" value="Mumbai Indians" readonly="readonly">
                                </div>
                                
                            
                            
                                <div class = "col-lg-3">
                                     <img src="<%=request.getContextPath()%>/resources/image/vs.jpg" id="vs" width="50" height="50" style="margin-top: 50px;margin-right: 20px;">
                                </div>
                                <div class = "col-lg-4">
                                     <img src="<%=request.getContextPath()%>/resources/image/2.jpg" class="img-circle" id="rcb" width="200" height="130"> 
                                     <br>
                                     <input class="form-control" id="team2" type="text" value="Royal Challengers Bangalore" readonly="readonly">
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer" style="text-align: center;">
                             <input class="form-control" id="win" type="text" value="Mumbai Indians won the match" readonly="readonly">
                        </div> 

                    </div>
                </div>

                
            </div>
    </div>
       
  </div>

</div>

<!-- jQuery -->
    <script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/dist/js/sb-admin-2.js"></script>

</body>

</html>
