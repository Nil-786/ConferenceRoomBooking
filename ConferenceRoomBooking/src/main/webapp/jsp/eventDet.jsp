<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="d-flex justify-content-between">
		<jsp:include page="sidebar.jsp"></jsp:include>
		<div class="container mt-5 w-50">
			<h2>Event details</h2>
			<form class=" border border-primary rounded p-2" id="bookingForm">
				<div>
					<label for="eventTitle" class="form-label">Room Name</label> <input
						type="text" class="form-control" id="eventTitle"
						placeholder="Enter event title" value="${param.confRoomName }"
						disabled="disabled">
				</div>
				<div class="mb-3">
					<label for="employeeId" class="form-label">Employee ID</label> <input
						type="number" class="form-control" id="employeeId"
						placeholder="Enter Employee ID" value="${param.uCode}"
						disabled="disabled">
					<div id="error-employeeId"></div>
				</div>
				<div class="mb-3">
					<label for="employeeName" class="form-label">Employee Name</label>
					<input type="text" class="form-control" id="employeeName"
						placeholder="Enter Employee Name" value="${param.userName }"
						disabled="disabled">
					<div id="error-employeeName"></div>
				</div>
				<div class="mb-3">
					<label for="startTime" class="form-label">Start Time</label> <input
						type="datetime-local" class="form-control" id="startTime" min=""
						max="" value="${param.start }" disabled="disabled">
					<div id="error-startTime"></div>
				</div>
				<div class="mb-3">
					<label for="endTime" class="form-label">End Time</label> <input
						type="datetime-local" class="form-control" id="endTime" min=""
						max="" value="${param.end }" disabled="disabled">
					<div id="error-endTime"></div>
				</div>
				<div>
					<label for="eventTitle" class="form-label">Event Title</label> <input
						type="text" class="form-control" id="eventTitle"
						placeholder="Enter event title" value="${param.title }"
						disabled="disabled">
				</div>
			</form>
		</div>
	</div>
</body>
</html>