<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<marquee direction="right" scrollamount="12" behavior="scroll" bgcolor="silver">MEETING
	ROOM BOOKING SYSTEM</marquee>
<head>
<meta charset="UTF-8">
<title>USER FUNCTIONALITIES</title>
<link rel="stylesheet" href="User.css">
</head>
<body align="center">
	<h2 align="center">User Functionalities</h2>
	<form action="meetingrequest" method="post">
		<h3>
			<input type="submit" name="operation" value="request">

		</h3>
		<h3>
			<input type="submit" name="operation" value="cancel">
		</h3>

	</form>
</body>
<form action="Login.jsp">
	<input type="submit" value="LOGOUT"> <br> <br>
</form>
</html>