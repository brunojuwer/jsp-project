<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link href="./index.css" rel="stylesheet"/>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
	</head>
	<body>
		<header>
			<h1>Login</h1>
		</header>
	
		<form action="/Projeto-jsp/Login" method="post">
			<input name="username" type="text" placeholder="Username"/>
			<input name="password" type="password" placeholder="Password"/>
			<input type="submit" value="Submit"/>
			<p>${msg}</p>
		</form>
	</body>
</html>