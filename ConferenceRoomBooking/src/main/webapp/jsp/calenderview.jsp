<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events</title>
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar/index.global.min.js'></script>


</head>
<body>

	<section class="page">
		<div class="box">
			<div class="sidebar">
				<%@include file="sidebar.jsp"%>
			</div>
			<div class="view">			
				<div id="calendar"  class="w-100"></div>
			</div>
		</div>
	</section>
</body>


<script>
	$(document).ready(function() {

		const calendarEl = $('#calendar')[0];
		const calendar = new FullCalendar.Calendar(calendarEl, {
			initialView : 'dayGridMonth',
			headerToolbar: {
		          left: 'prev,next today',
		          center: 'title',
		          right: 'dayGridMonth,timeGridWeek,timeGridDay'
		        },
		        events: [
		          {
		            title: 'Nilesh Day Event',
		            start: '2024-08-03'
		          },
		          {
		            title: 'Long Event',
		            start: '2024-08-07',
		            end: '2024-08-10'
		          },
		          {
		            groupId: '999',
		            title: 'Repeating Event',
		            start: '2024-08-09T16:00:00'
		          },
		          {
		            groupId: '99',
		            title: 'Repeating Event',
		            start: '2024-08-16T16:00:00'
		          },
		          {
		            title: 'Conference',
		            start: '2024-08-11',
		            end: '2024-08-13'
		          },
		          {
		            title: 'Meeting',
		            start: '2024-08-12T10:30:00',
		            end: '2024-08-12T12:30:00'
		          }]
		});
		calendar.render();
	});
</script>
</html>