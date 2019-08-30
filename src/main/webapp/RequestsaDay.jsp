<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>No of requests in a day</title>
</head>
<body>

	<form method="post" action="requestsaday">
		<h2 align="center">Requests Made on a Particular Day</h2>
		<table align="center">
			<tr>
				<td>Date(yyyy/mm/dd):</td>
				<td><input type="date" name="date" required></td>
			</tr>
			<tr>
				<td><input type="submit" name="SUBMIT" value="GET REQUESTS"></td>
			</tr>
		</table>
	</form>
</body>
</html>