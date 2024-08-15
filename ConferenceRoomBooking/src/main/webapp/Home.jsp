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
		const calendarEl = $('#calendar')[0];
		const calendar = new FullCalendar.Calendar(calendarEl, {
			initialView : 'dayGridMonth',
			headerToolbar : {
				left : 'prev,next today',
				center : 'title',
				right : 'dayGridMonth,timeGridWeek,timeGridDay'
			},
			events : [ {
				title : 'Nilesh Day Event',
				start : '2024-08-03'
			}, {
				title : 'Long Event',
				start : '2024-08-07',
				end : '2024-08-10'
			}, {
				groupId : '999',
				title : 'Repeating Event',
				start : '2024-08-09T16:00:00'
			}, {
				groupId : '99',
				title : 'Repeating Event',
				start : '2024-08-16T16:00:00'
			}, {
				title : 'Conference',
				start : '2024-08-11',
				end : '2024-08-13'
			}, {
				title : 'Meeting',
				start : '2024-08-12T10:30:00',
				end : '2024-08-12T12:30:00'
			} ]
		});
		calendar.render();
	});
</script>
</html>