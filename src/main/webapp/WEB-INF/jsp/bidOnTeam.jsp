<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form class="myForm" name="addBidForm" action="addBid" method="POST">
		Enter bidderId: <input type="text" placeholder="Enter bidderId"
			name="emailId" required><br> Enter matchId: <input
			type="text" placeholder="Enter matchId" name="matchId" required><br>
		Enter teamId: <input type="text" placeholder="Enter teamID"
			name="teamId" required><br>

		<button type="submit">Submit</button>
</body>
</html>