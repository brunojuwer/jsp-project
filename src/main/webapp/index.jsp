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
		<!--  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">-->
		
		<style type="text/css">
			charset "UTF-8";
			
			* {
				padding: 0;
				margin: 0;
				box-sizing: border-box;
				font-family: 'Roboto', sans-serif;
			}
			
			header {
				width: 100%;
				text-align: center;
				padding: 20px;
			}
			
			form {
				display: flex;
				flex-direction: column;
				gap: 10px;
				
				max-width: 300px;
				width: 100%;
				
				margin: 0 auto;
			}
			
			input[type=submit] {
				cursor: pointer;
				align-self: center;
				padding: 0 10px;
			}
			
			p {
				text-align: center;
				color: red;
			}
		</style>
	</head>
	<body>
		<header>
			<h1>Login</h1>
		</header>
	
		<form action="/Projeto-jsp/Login" method="post">
			<input type="hidden" value="<%= request.getParameter("url")%>" name="url"/>
			<input name="username" type="text" placeholder="Username"/>
			<input name="password" type="password" placeholder="Password"/>
			<input type="submit" value="Submit"/>
			<p>${msg}</p>
		</form>
	</body>
</html>