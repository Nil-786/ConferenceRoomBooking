<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="cdn.jsp"></jsp:include>
	<h3 class="text-secondary text-center pt-5">Login</h3>
	<form id="loginForm" action="webapi/user/login" method="get"
		class="container w-50 mx-auto mt-4 p-5 form border  rounded shadow-sm needs-validation">
		<div data-mdb-input-init class="form-outline mb-4">
			<label class="form-label" for="username">Username<span
				class="m-1 text-danger">*</span></label> <input type="text" id="uName"
				name="uName" class="form-control " required />
			<div class="invalid-feedback">Please enter username!!</div>
		</div>

		<div data-mdb-input-init class="form-outline mb-4">
			<label class="form-label" for="password">Password<span
				class="m-1 text-danger">*</span></label> <input type="password" id="pass"
				name="pass" class="form-control" required />
			<div class="invalid-feedback">Please enter password!!</div>
		</div>

		<button type="submit" data-mdb-button-init data-mdb-ripple-init
			class="btn btn-primary btn-block mb-4 w-100">Sign in</button>
	</form>
</body>
</html>