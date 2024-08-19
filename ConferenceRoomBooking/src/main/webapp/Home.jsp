<%@page import="com.confRoomBooking.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.1.0/main.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.1.0/main.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
</head>
<body>
	<%!User user = new User();%>

	<%
	user = (User) request.getSession().getAttribute("user");
	%>
	<section class="page">
		<div class="d-flex justify-content-between">
			<div class="sidebar">
				<jsp:include page="jsp/sidebar.jsp">
					<jsp:param value="<%=user.getUserName()%>" name="uName" />
				</jsp:include>
			</div>
			<div class="view mx-auto w-100 mt-5">
				<div id="calendar" class="overflow-auto" style="max-height: 80vh;"></div>
			</div>
		</div>

	</section>
</body>


<script>
$(document).ready(function() {
    $.ajax({
        type: 'GET',
        url: '/ConferenceRoomBooking/webapi/event/get',
        dataType: 'json',
        encode: true,
        success: function(response) {
        	
            const events = response.map(event => ({
                title: event.title,
                start: event.start + ":00",
                end: event.end + ":00",
                url:'/ConferenceRoomBooking/jsp/eventDet.jsp?title='+event.title+'&start='+event.start+'&end='+event.end+'&userName='+event.username+'&uCode='+event.empCode+'&confRoomName='+event.confRoomName
            }));
			console.log(events);
            // Initialize FullCalendar after fetching events
            const calendarEl = $('#calendar')[0];
            const calendar = new FullCalendar.Calendar(calendarEl, {
                initialView: 'dayGridMonth',
                headerToolbar: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'dayGridMonth,timeGridWeek,timeGridDay'
                },
                events: events // Pass the fetched events here
            });
            calendar.render();
        },
        error: function(error) {
            console.log('Fetching events failed:', error);
        }
    });
});

</script>
</html>