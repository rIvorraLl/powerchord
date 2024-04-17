<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/components/form.css">
<link rel="stylesheet" type="text/css"
	href="css/layouts/centered-form.css">
</head>
<body>
	<main>
		<h2 class="form-register-title">Login</h2>
		<form action="UserLoginServlet" method="post">
			<label for="name">Username:</label> <input type="text" id="name"
				class="form-input" name="name" required> <br> <label
				for="password">Password:</label> <input type="password"
				id="password" class="form-input" name="password" required> <br>
			<div class="form-submit-container">
				<input class="form-submit" type="submit" value="Login">
			</div>
		</form>
	</main>
</body>
</html>