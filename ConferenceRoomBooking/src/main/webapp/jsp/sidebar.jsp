<<<<<<< HEAD
<%@page import="com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param"%>
=======
>>>>>>> b205dd3d8a2c977455e19359ef6381b5f4065297
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">


<link href="https://cdn.lineicons.com/4.0/lineicons.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="../styles/index.css">
</head>
<body>
	<div class=" p-0 m-0 ">
		<main class="offcanvas-md offcanvas-start py-3  " data-bs-backdrop="false"
			id="sidebar" style="width: fit-content;height:100vh;" tabindex="1" >
			<div class="d-flex flex-column flex-shrink-0  px-2 h-100 bg-body-tertiary open"
			id="section"
<<<<<<< HEAD
			style="width:250px;"
				>
				<div class="d-flex justify-content-between" id="brand">
					<a href="/ConferenceRoomBooking/Home.jsp"
=======
			style="width:240px;"
				>
				<div class="d-flex justify-content-between" id="brand">
					<a href="/"
>>>>>>> b205dd3d8a2c977455e19359ef6381b5f4065297
						class="d-flex align-items-center justify-content-center gap-2 mb-3  link-body-emphasis text-decoration-none ">
						<i class="lni lni-apartment fs-2 text-center"></i> <span class="fs-4 content">Sidebar</span>
					</a>
					<button type="button" class="btn-close d-md-none" data-bs-toggle="offcanvas" data-bs-target="#sidebar"
						aria-label="Close"></button>
					<button class="border-0 bg-transparent  fw-bold d-none d-md-inline" onclick="toggleSidebar()"><i class="lni lni-arrow-left fs-4 link" id="toggle-icon"></i></button>
				</div>

				<hr>
				<ul class="nav nav-pills flex-column mb-auto justify-content-evenly">
<<<<<<< HEAD
					<li class="nav-item"><a href="/ConferenceRoomBooking/jsp/listEvents.jsp" class="d-flex gap-2 align-items-center nav-link active"
						aria-current="page"> <i class="lni lni-calendar fs-5 link "></i>
							<span class="content">My Events</span>
					</a></li>
					<li><a href="/ConferenceRoomBooking/jsp/listConferenceRooms.jsp"
						class="nav-link link-body-emphasis gap-2  d-flex align-items-center"> <i
							class="lni lni-apartment link fs-5"></i><span class="content">View conference rooms</span>
					</a></li>
					<li><a href="/ConferenceRoomBooking/jsp/addconfroom.jsp"
						class="nav-link link-body-emphasis gap-2  d-flex align-items-center"> <i
							class="lni lni-apartment link fs-5"></i><span class="content">Add conference room</span>
=======
					<li class="nav-item"><a href="/event" class="d-flex gap-2 align-items-center nav-link active"
						aria-current="page"> <i class="lni lni-calendar fs-5 link "></i>
							<span class="content">Events</span>
					</a></li>
					<li><a href="/conference.html"
						class="nav-link link-body-emphasis gap-2  d-flex align-items-center"> <i
							class="lni lni-apartment link fs-5"></i><span class="content">Conference room</span>
>>>>>>> b205dd3d8a2c977455e19359ef6381b5f4065297
					</a></li>
				</ul>
				<hr>
				<div class="dropdown position-relative profile">
					<a href="#"
						class="d-flex align-items-center  link-body-emphasis text-decoration-none dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false"> <img src="https://api.dicebear.com/7.x/pixel-art/svg"
<<<<<<< HEAD
						alt="" width="32" height="32" class="rounded-circle me-2"> <strong class="content">${param.uName}</strong>
					</a>
					<ul class="dropdown-menu text-small shadow ">
						<li><a class="dropdown-item " href="/ConferenceRoomBooking/webapi/user/logout">Sign out</a></li>
=======
						alt="" width="32" height="32" class="rounded-circle me-2"> <strong class="content">mdo</strong>
					</a>
					<ul class="dropdown-menu text-small shadow ">
						<li><a class="dropdown-item " href="#">Sign out</a></li>
>>>>>>> b205dd3d8a2c977455e19359ef6381b5f4065297
					</ul>
				</div>
			</div>
		</main>
		<a class="fs-5 link-body-emphasis d-md-none text-decoration-none"
			data-bs-toggle="offcanvas"  data-bs-target="#sidebar"
			aria-controls="sidebar"> <i class="lni lni-list fs-3"></i></a>
	</div>
<<<<<<< HEAD




=======
	
	

	
>>>>>>> b205dd3d8a2c977455e19359ef6381b5f4065297
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js">
    </script>
<script>
<<<<<<< HEAD
function toggleSidebar() {
	event.preventDefault();
=======

function toggleSidebar() {
	event.preventDefault();

>>>>>>> b205dd3d8a2c977455e19359ef6381b5f4065297
	if($('#section').hasClass("open")) {
		$('.content').hide();
		$('#section').width('fit-content');
		$('.link').addClass("fs-5 py-1");
		$('#toggle-icon').removeClass("lni-arrow-left");
		$('#toggle-icon').addClass("lni-menu");
		$('#brand').addClass("flex-column-reverse align-items-center gap-2");
		$('#section').removeClass("open");
		$('#section').addClass("close");
	} else if($('#section').hasClass("close")) {
		$('.content').show();
		$('#section').width('240px');
		$('.link').removeClass("fs-5  py-1");
		$('#toggle-icon').removeClass("lni-menu");
		$('#toggle-icon').addClass("lni-arrow-left");
		$('#brand').removeClass("flex-column-reverse justify-content-center gap-2");
<<<<<<< HEAD
		$('#section').removeClass("close");
		$('#section').addClass("open");
	}
}
=======

		$('#section').removeClass("close");
		$('#section').addClass("open");
	}



}

>>>>>>> b205dd3d8a2c977455e19359ef6381b5f4065297
</script>
</html>