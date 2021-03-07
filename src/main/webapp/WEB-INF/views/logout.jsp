<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <script type="text/javascript"> 
        function preventBack() { 
            window.history.forward();  
        } 
        setTimeout("preventBack()", 0); 
        window.onload = function () { null }; 
    </script> 
</head>
<body>
CLICK HERE TO COMPLETE LOGOUT PROCESS <a href="Home2"> Home</a>
<br>
<%
session.invalidate();
%>
</body>
</html>