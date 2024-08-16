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
    
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>



</head>
<body>
    <div class="container mt-5">
        <h2>Room Booking Form</h2>
        <form id="bookingForm">
            <div class="mb-3">
                <label for="roomId" class="form-label">Room ID</label>
                <input type="text" class="form-control" id="roomId" placeholder="Enter Room ID">
                <div id="error-roomId"></div>
            </div>
            <div class="mb-3">
                <label for="employeeId" class="form-label">Employee ID</label>
                <input type="number" class="form-control" id="employeeId" placeholder="Enter Employee ID">
                <div id="error-employeeId"></div>
            </div>
            <div class="mb-3">
                <label for="employeeName" class="form-label">Employee Name</label>
                <input type="text" class="form-control" id="employeeName" placeholder="Enter Employee Name">
                <div id="error-employeeName"></div>
            </div>
            <div class="mb-3">
                <label for="startTime" class="form-label">Start Time</label>
                <input type="datetime-local" class="form-control" id="startTime" min="" max="">
                <div id="error-startTime"></div>
            </div>
            <div class="mb-3">
                <label for="endTime" class="form-label">End Time</label>
                <input type="datetime-local" class="form-control" id="endTime" min="" max="">
                <div id="error-endTime"></div>
            </div>
              <div class="mb-3">
                <label for="eventTitle" class="form-label">Event Title</label>
                <input type="text" class="form-control" id="eventTitle" placeholder="Enter event title">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        
    </div>
    <script>
        // Function to format date to 'yyyy-MM-ddTHH:mm'
        const formatDate = (date) => {
        	if (!date) return '';
            const isoString = date.toISOString();
            return isoString.substring(0, 16);
        };

        // Set min and max date for the date inputs
        const today = new Date();
        const minDate = new Date(today);
        const maxDate = new Date(today);
        maxDate.setDate(today.getDate() + 7);

        console.log('Min Date:', formatDate(minDate));
        console.log('Max Date:', formatDate(maxDate));
        
        
        document.getElementById('startTime').min = formatDate(minDate);
        document.getElementById('startTime').max = formatDate(maxDate);
        document.getElementById('endTime').min = formatDate(minDate);
        document.getElementById('endTime').max = formatDate(maxDate);
        
        $('#bookingForm').on('submit', function(event) {
        	event.preventDefault();
        	
	         const id = $('#roomId').val();
	         const startDate = $('#startTime').val();
	         const endDate = $('#endTime').val();
	         
	         console.log(Date.parse(startDate).getTime());
	         
	         if(Date.parse(startDate).getTime() > Date.parse(endDate).getTime()) {
	        	 $('#error-endTime').text("end time is less than start time ");
	        	 return;
	         } else if(Date.parse(startDate).getTime() === Date.parse(endDate).getTime()) {
	        	 $('#error-startTime').text("both start and end time are equal");
	        	 $('#error-endTime').text("both start and end time are equal");
	        	 return;
	         }
	         
	         $.ajax({
	             type: 'GET',
	             url: "http://localhost:8080/ConferenceRoomBooking/webapi/event/1/add?employeeName="+$('#employeeName').val()+"&employeeId="+$('#employeeId').val()+"&startTime="+$('#startTime').val()+"&endTime="+$('#endTime').val()+"&eventTitle="+$('#eventTitle').val(),
	             success: function(response) {
	                 alert('Event submitted successfully!');
	             },
	             error: function(error) {
	                 alert('Error submitting event.');
	             }
	         });
        	
        	
        })

        
    </script>
    
</body>
</html>
