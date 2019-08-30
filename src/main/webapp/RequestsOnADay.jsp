<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="FMFunctionalities.jsp"%>
	<br>
	<br>
	<%
		String count = (String) request.getAttribute("status");
		out.println("The no of requests on day are:" + count);
	%>
</body>
</html>