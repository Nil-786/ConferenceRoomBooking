<%@page import="java.time.LocalDateTime"%>
<%@page import="com.confRoomBooking.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Room Booking Form</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
	integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
	crossorigin="anonymous"></script>



</head>
<body>

	<section class="page">
		<div class="box">
			<div class="sidebar">
				<%@include file="sidebar.jsp"%>
			</div>
			<div class="view overflow-auto" style="height: 98vh;">
				<div class="container mt-2" >
					<h2 class=" mb-5">Conference Room Booking</h2>
					<form id="bookingForm">
						<div class="mb-3">
							<label for="roomId" class="form-label">Room ID</label> <input
								type="text" class="form-control" id="roomId"
								placeholder="Enter Room ID" required>
							<div id="error-roomId"
								class=" error text-danger fs-6 fw-semibold"></div>
						</div>
						<div class="mb-3">
							<label for="employeeId" class="form-label">Employee ID</label> <input
								type="number" class="form-control" id="employeeId"
								placeholder="Enter Employee ID" required>
							<div id="error-employeeId"
								class=" error text-danger fs-6 fw-semibold"></div>
						</div>
						<div class="mb-3">
							<label for="employeeName" class="form-label">Employee
								Name</label> <input type="text" class="form-control" id="employeeName"
								placeholder="Enter Employee Name" required>
							<div id="error-employeeName"
								class="error text-danger fs-6 fw-semibold"></div>
						</div>
						<div class="mb-3">
							<label for="startTime" class="form-label">Start Time</label> <input
								type="datetime-local" class="form-control" id="startTime" min=""
								max="" required>
							<div id="error-startTime"
								class="error text-danger fs-6 fw-semibold"></div>
						</div>
						<div class="mb-3">
							<label for="timeSlots" class="from-label ">Select Time
								Slot</label>
							<div id="timeslots" class="d-flex flex-wrap align-items-center">
								<input type="number" class="form-control me-2" max="60" min="0"
									style="width: 60px" id="time" step="10">
								<div>
									<select class="form-control" id="timeunits">
										<option value="minutes">Minutes</option>
										<option value="hour">hour</option>
									</select>
								</div>
							</div>
						</div>
						<div class="mb-3">
							<label for="endTime" class="form-label">End Time</label> <input
								type="datetime-local" class="form-control" id="endTime" min=""
								max="" required>
							<div id="error-endTime"
								class="error text-danger fs-6 fw-semibold"></div>
						</div>
						<div class="mb-3">
							<label for="eventTitle" class="form-label">Event Title</label> <input
								type="text" class="form-control" id="eventTitle"
								placeholder="Enter event title" required>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>

				</div>
			</div>
		</div>
	</section>


</body>
<script src="../js/booking_script.js" type="text/javascript"></script>
</html>
