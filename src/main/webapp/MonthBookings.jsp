<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.mrbs.booking.bean.*"%>
<!DOCTYPE html>
<html>
<marquee direction="right" scrollamount="12" behavior="scroll">MEETING
	ROOM BOOKING SYSTEM</marquee>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Fm.css">
</head>
<body>

	<%
		ArrayList<MeetingRequest> meetingrequests = (ArrayList<MeetingRequest>)request.getAttribute("list");
	%>
	<table border="1" align="center">
		<thead>
			<tr>
				<th>ID</th>
				<th>START DATE</th>
				<th>END DATE</th>
				<th>START TIME</th>
				<th>ENDTIME</th>
				<th>USER</th>
				<th>MRNAME</th>
				<th>RESOURCE</th>
				<th>STATUS</th>
			</tr>
		</thead>
		<tr>
			 <%
				for (MeetingRequest meetingrequest : meetingrequests) {
					%>
					<tr>
					<td> <%=meetingrequest.getID()%></td>
					<td><%=meetingrequest.getStartdate() %></td>
					<td><%=meetingrequest.getEnddate() %></td>
					<td><%=meetingrequest.getStarttime() %></td>
					<td><%=meetingrequest.getEndtime() %></td>
					<td><%=meetingrequest.getUser() %></td>
					<td><%=meetingrequest.getMrname() %></td>
					<td><%=meetingrequest.getResource() %></td>
					<td><%=meetingrequest.getStatus() %></td>
					</tr>
				<% }
			%>
		</tr>
	</table>
	<br>
	<br>
	<a href="FMFunctionalities.jsp">Back</a>
</body>
</html>