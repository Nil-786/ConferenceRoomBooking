<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<title>Login</title>
<link rel="stylesheet" type="text/css" href="../styles/index.css">
</head>
<body>
	<h3 class="text-secondary text-center pt-5">Login</h3>
	<form class="container mx-auto mt-4 p-5 form border  rounded shadow-sm needs-validation" >
		<div data-mdb-input-init class="form-outline mb-4">
			<label class="form-label" for="username">Username<span class="m-1 text-danger">*</span></label> 
			
			<input type="text" id="username" class="form-control " required />
			<div class="invalid-feedback">Please enter username!!</div>
		</div>

		<div data-mdb-input-init class="form-outline mb-4">
			<label class="form-label" for="password">Password<span class="m-1 text-danger">*</span></label> 
			<input type="password" id="password" class="form-control" required />
			<div class="invalid-feedback">Please enter password!!</div>
		</div>

		<button type="submit" data-mdb-button-init data-mdb-ripple-init
			class="btn btn-primary btn-block mb-4">Sign in</button>


	</form>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</html>