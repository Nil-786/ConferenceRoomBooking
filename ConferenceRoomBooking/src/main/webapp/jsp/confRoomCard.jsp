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
	<div class="card" style="width: 18rem;">
		<img src="..." class="card-img-top" alt="...">
		<div class="card" style="width: 18rem;">
			<img src="..." class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">Title: <strong>${param.name}</strong></h5>
				<h6 class="card-title">Capacity: <strong>${param.capacity}</strong></h6>
				<!--<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
				-->
				<input type="hidden" name="id" id="id" value="${param.id}">
				<a href="#" class="btn btn-primary">Book room</a>
			</div>
		</div>
	</div>
</body>
</html>