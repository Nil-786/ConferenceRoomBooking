<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>CONFERENCE ROOM BOOKING FORM</title>

 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

	 <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- jQuery CDN -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Bootstrap JS CDN -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

    <!-- CSS CDN for datetimepicker -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css" />

<link rel="stylesheet" href="../styles/index.css">
<!-- datetimepicker jQuery CDN -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"></script>
<script src="../js/conference_script.js"></script>

</head>
<body>
	<jsp:include page="cdn.jsp"></jsp:include>
	<section class="page">
		<div class="box">
			<div class="sidebar">
				<%@include file="sidebar.jsp"%>
			</div>
			<div class="view">
					<div class="container text ">

						<h1 class="text-center">Booking Form</h1>

						<!-- ACTUAL FORM-->

						<form class="form-horizontal border-form ">
							<!-- room id -->
							<div class="form-group">
								<!-- room id label -->
								<label class="control label col-sm-2" for="roomId">Room
									Id :</label>
								<!-- room id input  -->
								<div class="col-sm-10">
									<input type="text" class="form-control" id="roomId"
										placeholder="Enter Room Id">
								</div>
							</div>
							<!-- room id close -->


							<!-- emp id -->
							<div class="form-group">
								<!-- emp id label -->
								<label class="control label col-sm-2" for="empId">Employee
									Id :</label>
								<!-- emp id input  -->
								<div class="col-sm-10">
									<input type="text" class="form-control" id="empId"
										placeholder="Enter Employee Id">
								</div>
							</div>
							<!-- emp id close -->



							<!-- emp name -->
							<div class="form-group">
								<!-- emp name  label -->
								<label class="control label col-sm-2" for="empName">Employee
									Name :</label>
								<!-- emp id input  -->
								<div class="col-sm-10">
									<input type="text" class="form-control" id="empName"
										placeholder="Enter Employee Name">
								</div>
							</div>
							<!-- emp name close -->

							<!-- start time -->
							<div class="form-group">
								<!-- start time  label -->
								<label class="control label col-sm-2" for="startTime">Start
									Date and Time :</label>
								<!-- start time input  -->
								<div class="col-sm-10">
									<input type="text" class="datetimepicker form-control "
										id="startTime">
								</div>
							</div>
							<!-- start time close -->


							<!-- end  time -->
							<div class="form-group">
								<!-- end time  label -->
								<label class="control label col-sm-2" for="endTime">End
									Date and Time :</label>
								<!-- end time input  -->
								<div class="col-sm-10">
									<input type="text" class="datetimepicker form-control "
										id="endTime">
								</div>
							</div>
							<!-- end time close -->



							<!-- event title -->
							<div class="form-group">
								<!-- event title  label -->
								<label class="control label col-sm-2" for="eventTitle">Event
									Title :</label>
								<!-- event title input  -->
								<div class="col-sm-10">
									<input type="text" class="form-control" id="eventTitle"
										placeholder="Enter Event Title">
								</div>
							</div>
							<!-- event title close -->



							<!-- book button -->
							<div class="form-group">
								<button id="bookButton"
									class="form-control btn btn-primary btn-block">Book
									Conference Room</button>

							</div>
							<!-- book button close -->



						</form>


					</div>
				</div>
		</div>
	</section>
</body>
</html>