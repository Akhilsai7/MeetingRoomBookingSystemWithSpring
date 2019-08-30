<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<marquee direction="right" scrollamount="12" behavior="alternate">MEETING
	ROOM BOOKING SYSTEM</marquee>
<script type="text/javascript">
	function display() {
		var username = document.forms["form"]["username"].value;

		var idproof = document.forms["form"]["password"].value;

		document.getElementById('enter').innerHTML = "";

		document.getElementById('enter1').innerHTML = "";

		if (username == null || username == "") {

			
			alert("Enter Username");
			
			return false;
		} else if (idproof == null || idproof == "") {

			alert("Enter Password");

			return false;
		}
		return true;
	}
</script>

<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form name="form" style="text-align: center" method="post"
		action="control" onsubmit="return display();">
		<h2 align="center">Login</h2>
		<p>
			Username: <input type="text" name="username" />
		</p>
		<p id='enter'></p>
		<p>
			Password: <input type="password" name="password" />
		</p>
		<p id='enter1'></p>
		<input type="reset" name="index_clear" value="Clear"> <input
			type="submit" name="index_validate" value="submit">


	</form>
</body>
</html>