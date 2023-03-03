<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home - JSP</title>
</head>
<body>
	<h1>Welcome</h1>
	<form action="/Projeto-jsp/Login" method="post">
		<input name="nome" type="text"/>
		<input name="idade" type="number"/>
		<input type="submit" value="Enviar"/>
	</form>
</body>
</html>