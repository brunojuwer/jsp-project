<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Error</title>
	</head>
<body>
	<h1>Error, please contact the support team!</h1>
	
	<%
		out.print(request.getAttribute("msg"));
	%>	
</body>
</html>