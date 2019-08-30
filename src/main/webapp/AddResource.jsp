<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Resource</title>
</head>
<body>
	<%@include file="FMFunctionalities.jsp"%>
	<form name="NewUser" style="text-align: center" method="post"
		action="addresource">
		<h2 align="center">Adding Resource</h2>
		<table align="center">
			<tr>
				<td>Resource ID:</td>
				<td><input type="text" name="resourceid" required></td>
			</tr>
			<tr>
				<td>Resource Name:</td>
				<td><input type="text" name="resourcename" required></td>
			</tr>
			<tr>
				<td><input type="reset" name="index_clear" value="Clear"></td>
				<td><input type="submit" name="index_validate" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>