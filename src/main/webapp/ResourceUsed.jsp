<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.mrbs.booking.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resource times</title>
<link rel="stylesheet" href="Fm.css">
</head>
<body>
	<form name="Newrequest" style="text-align: center" method="post"
		action="resourcetimes">
		<h2 align="center">Resource Usage</h2>
		<table align="center">
			<td>Resource No:</td>
			<td><select name="resourcename">

					<%
						ArrayList<String> resources = (ArrayList<String>) request.getAttribute("resources");
						for (String resource : resources) {
					%>
					<option>
						<%=resource%>
					</option>
					<%
						}
					%>
			</select></td>
			</tr>




		</table>
		<input type="submit" name="SUBMIT" value="submit">
	</form>
</html>