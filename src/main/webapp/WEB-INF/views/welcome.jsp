<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcoome</h1>

	<%
		String c = (String) request.getAttribute("fullname");
	%>

	<%
		String d = (String) request.getAttribute("message");
	%>
	${fullname}
	<br> ${message} Your full name is
	<%=c%>
	<br> Your message is
	<%=d%>


</body>
</html>