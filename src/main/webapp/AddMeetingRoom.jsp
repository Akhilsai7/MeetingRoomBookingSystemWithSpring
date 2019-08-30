<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Meeting Room</title>
</head>
<body>
	<%@include file="FMFunctionalities.jsp"%>
	<form name="NewUser" style="text-align: center" method="post"
		action="addmeetingroom" >
		<h2 align="center">Adding meeting Room</h2>
		<table align="center">
			<tr>
				<td>ID:</td>
				<td><input type="text" name="meetingroomid" required></td>
				
			</tr>
			
			<tr>
				<td>MeetingRoom name:</td>
				<td><input type="text" name="meetingroomname" required></td>
				
			</tr>
			<tr>
				<td><input type="reset" name="index_clear" value="Clear"></td>
				<td><input type="submit" name="index_validate" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>