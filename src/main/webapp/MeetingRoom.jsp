<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.mrbs.booking.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="Newrequest" style="text-align: center" method="post"
		action="meetingtimes">
		<h2 align="center">MeetingRoom Usage</h2>
		<table align="center">
			<td>Meeting Room No:</td>
			<td><select name="Meetingroomname" required>
					<option value="">Choose</option>
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
		</table>
		<input type="submit" name="SUBMIT" value="submit">
	</form>
</body>
</html>