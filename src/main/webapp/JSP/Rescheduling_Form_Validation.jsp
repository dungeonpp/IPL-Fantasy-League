<!DOCTYPE html>
<head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">

      <link href="build/css/bootstrap-datetimepicker.css" rel="stylesheet">
      <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.4/moment.min.js"></script>
      <script src="build/js/bootstrap-datetimepicker.min.js"></script>
      <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
      <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

      <script src="BookingForm.js" type="text/javascript"></script>
      <link rel="stylesheet" href="BookingForm.css">

            <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>


</head>

<body ng-app="">
{{2+2}}

<div class="container">

    <ul class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">Reschedule Match</a></li>
      <!-- <li><a data-toggle="tab" href="#menu1">OUTSTATION</a></li>
      <li><a data-toggle="tab" href="#menu2" id="field3">RENTAL CAB</a></li> -->
    </ul>

    <div class="tab-content">

        <div id="home" class="tab-pane fade in active" >
                        
                        <form class="form-inline" name="rescheduleForm">
                  <div class="col-md-12">
                      <div class="input-group add-on" style="width: 305px;">
                          <input type="text" class="form-control" id="srch-term1" name="matchId" ng-model="matchId" placeholder=" Enter Match Id" required />
                          <span ng-show="rescheduleForm.matchId.$touched && rescheduleForm.matchId.$error.required"><p style="color: red;">Please enter matchId</p></span>

                         <!--  <span class="input-group-addon">
                                <span class="glyphicon-map-marker glyphicon"></span>
                            </span> -->
                      </div>
                  </div>

                  <div class="col-md-12">
                      <div class="input-group add-on" style="width: 305px;">
                          <input type="text" class="form-control" id="srch-term2" name="team1" ng-model="team1" placeholder="Team 1" required />
                           <span ng-show="rescheduleForm.team1.$touched && rescheduleForm.team1.$error.required"><p style="color: red;">Please enter team 1</p></span>

                          <span class="input-group-addon">
                                <span class="glyphicon-circle-arrow-left glyphicon"></span>
                            </span>
                       </div>
                  </div>


                  <div class="col-md-12">
                      <div class="input-group add-on" style="width: 305px;">
                          <input type="text" class="form-control" id="srch-term3" name="team2" ng-model="team2" placeholder="Team 2" required />
                            <span ng-show="rescheduleForm.team2.$touched && rescheduleForm.team2.$error.required">
                            <p style="color: red;">Please enter team 2</p></span>   
                          <span class="input-group-addon">
                                <span class="glyphicon-circle-arrow-left glyphicon"></span>
                            </span>
                       </div>
                  </div>

                  


                  <div class="col-md-12"> 
                      <div class="dropdown" name="schedulelater" id="schedulelater" > 
                          <div class="input-group add-on">
                              <span class="input-group-addon">Reschedule</span>
                                  <div class="input-group date" id="datetimepicker1">
                                      <input type="text" class="form-control" name="datetimechange" ng-model="datetimechange" placeholder="schedule date time" id="currentDateTime" required /> 
                                            <span ng-show="rescheduleForm.datetimechange.$touched && rescheduleForm.datetimechange.$error.required">
                                            <!-- <p style="color: red;">Please enter updated date and time</p> --></span>

                                          <span class="input-group-addon">
                                              <span class="glyphicon-calendar glyphicon"></span>
                                          </span>
                                  </div>
                          </div>
                      </div>
                  </div>

                  <div class="col-md-12">
                      <button type="button" class="btn btn-primary btn-lg btn-block" onclick="validateDate();">Reschedule Match
                       </button>
                  </div>
                  </form>
        </div>

</div>

<!-- 
      <style type="text/css">
    .form-inline input.ng-invalid.ng-touched
    {

      border="1px solid gray";  
    }
    .form-inline input.ng-valid.ng-touched
    {
      background-color: green;
    }
    
    
  </style>
 -->
 

</body>
</html>