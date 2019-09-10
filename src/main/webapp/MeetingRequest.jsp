<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.mrbs.booking.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Requesting Meeting Room</title>
<link rel="stylesheet" href="User.css">
</head>
<body>
	<%@include file="UserFunctionalities.jsp"%>
	<form name="Newrequest" style="text-align: center" method="post"
		action="requestmeeting">
		<h2 align="center">Request A Meeting Room</h2>
		<table align="center">
			<tr>
				<td>Start Date:</td>
				<td><input type="date" name="startdate" required></td>
			</tr>
			<tr>
				<td>End Date:</td>
				<td><input type="date" name="enddate" required></td>
			</tr>
			<tr>
				<td>Start time:</td>
				<td><input type="time" name="starttime" required></td>
			</tr>
			<tr>
				<td>End time:</td>
				<td><input type="time" name="endtime" required></td>
			</tr>
			<td>Meeting Room No:</td>
			<td><select name="Meetingroom_name" required>

					<%
						ArrayList<String> meetingrooms = (ArrayList<String>) request.getAttribute("meetingrooms");
						for (String meeting : meetingrooms) {
					%>
					<option>
						<%=meeting%>
					</option>
					<%
						}
					%>
			</select></td>
			</tr>


			<td>Resource No:</td>
			<td><select name="Resource_name" required>s

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
</body>
</html>