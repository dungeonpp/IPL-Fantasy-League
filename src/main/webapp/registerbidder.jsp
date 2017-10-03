<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form class="myForm" name="userForm" action="registerBidder" method="POST">
Enter Bidder Name:<input type="text" placeholder="Enter name" name="bidderName" required><br>
Enter email: <input type="text" placeholder="Enter Email" name="email" required><br>
Enter password: <input type="password" placeholder="Enter password" name="password" required><br>
Enter mobile number: <input type="text" placeholder="Enter mobile number" name="mobile" required><br>
<button type="submit">Submit</button>

</form>
</body>
</html>