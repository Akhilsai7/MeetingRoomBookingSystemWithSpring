<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Cancel Meeting Room</title>
</head>
<body>


	<form name="Newrequest" style="text-align: center" method="post"
		action="cancelmeeting">
		<h2 align="center">Cancel Your Meeting Request</h2>
		<table align="center">
			<tr>
				<td>ID:</td>
				<td><input type="number" name="requestid" required></td>
			</tr>
			<tr>
				<td><input type="submit" name="SUBMIT" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>