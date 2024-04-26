<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<link rel="stylesheet" type="text/css" href="../css/components/form.css">
<link rel="stylesheet" type="text/css"
	href="../css/layouts/centered-form.css">
</head>
<body>
	<main>
		<h2 class="form-register-title">Register</h2>
		<form action="../UserRegistrationServlet" method="post">
			<label for="name">Name:</label><br> <input class="form-input"
				type="text" id="name" name="name" required><br> <label
				for="email">Email:</label><br> <input class="form-input"
				type="email" id="email" name="email" required><br> <label
				for="password">Password:</label><br> <input class="form-input"
				type="password" id="password" name="password" required><br>
			<div class="form-submit-container">
				<input class="form-submit" type="submit" value="Register">
			</div>
		</form>
	</main>
	<script src="js/registerFormValidation.js"></script>
</body>
</html>
