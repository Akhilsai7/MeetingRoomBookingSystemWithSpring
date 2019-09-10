<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accept Request</title>
<link rel="stylesheet" href="Fm.css">
</head>
<body>
	<form action="acceptorreject" method="post">
		<table align="center">
			<tr>
				<td><input type="number" name="requestid" required></td>
			</tr>
			<tr>
				<td><input type="submit" name="operation"
					value="approverequest"></td>
			</tr>
			<tr>
				<td><input type="submit" name="operation" value="rejectrequest"></td>
			</tr>
		</table>
	</form>

</body>
</html>