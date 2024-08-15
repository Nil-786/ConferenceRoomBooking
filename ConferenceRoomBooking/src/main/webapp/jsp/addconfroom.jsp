<%@page import="com.confRoomBooking.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Conference Room</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- jQuery CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Bootstrap JS CDN -->
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../styles/index.css">
<!-- External JS -->
<script src="../js/super_admin_script.js"></script>

</head>
<body>

	<jsp:include page="cdn.jsp"></jsp:include>
	<%!User user = new User();%>

	<%
	user = (User) request.getSession().getAttribute("user");
	%>
	<section class="page">
		<div class="box">
			<jsp:include page="sidebar.jsp">
				<jsp:param value="<%=user.getUserName()%>" name="uName" />
			</jsp:include>
			<div class="view">
				<div class="container " style="margin-top: 60px">
					<h1 class="text-center">Add Conference Room Form</h1>
					<!--  only for image -->
					
					
			<form id="uploadForm">
    <input type="file" name="photos" id="photo" accept="image/*" multiple />
    <button type="submit" id="addImage">Add Photos</button>
</form>
					</div>
					
					<!-- Actual Form -->
					<form class="form-horizontal align-self-center" id="addDetails">
						<!-- Room ID -->
						<div class="row mb-3">
							<label class="col-sm-2 col-form-label" for="addroomId">Room
								name :</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="name"
									placeholder="Enter Room name" name="name">
							</div>
						</div>

						<!-- Capacity -->
						<div class="row mb-3">
							<label class="col-sm-2 col-form-label" for="capacity">Enter
								Capacity :</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="capacity"
									placeholder="Enter Capacity" name="capacity">
							</div>
						</div>

						<!-- Photos -->


						<!-- Add More Image Button -->
						<!--  <div class="row mb-3">
							<div class="col-sm-10 offset-sm-2">
								<button type="button" class="btn btn-primary" id="addMore">Add
									More Image</button>
							</div>
						</div>-->


						<!-- Add Conference Room Button -->
						<div class="row">
							<div class="col-sm-12">
								<button id="addButton"
									class="form-control  btn btn-primary mt-3">Add
									Conference Room</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#addDetails').submit(function(event) {
				event.preventDefault();

				var formData = {
					name : $('#name').val(),
					capacity : $('#capacity').val()
				};

				$.ajax({
					type : 'POST',
					url : '/ConferenceRoomBooking/webapi/conf/add',
					data : JSON.stringify(formData),
					contentType : 'application/json',
					encode : true,
					success : function(response) {
						console.log('conf added', response);
					},
					error : function(error) {
						console.log('failed:', error);
					}
				});
			});

			/*$('#addImage').submit(function(event) {
				event.preventDefault();

				var formData = {
					data : $('#photo').val()
				};

				$.ajax({
					type : 'POST',
					url : '/ConferenceRoomBooking/webapi/conf/addPhoto',
					data : formData,
					dataType : 'json',
					encode : true,
					success : function(response) {
						console.log('conf added', response);
					},
					error : function(error) {
						console.log('unsuccessful:', error);
					}
				});
			});*/
			
			$('#uploadForm').submit(function(event) {
			    event.preventDefault();

			    var formData = new FormData();
			    var files = $('#photo')[0].files;
			    var byteArrayList = [];

			    /*function convertFileToByteArray(file, callback) {
			        var reader = new FileReader();
			        reader.onload = function(event) {
			            var byteArray = new Uint8Array(event.target.result);
			            callback(byteArray);
			        };
			        reader.readAsArrayBuffer(file);
			    }*/

			    $.each(files, function(i, file) {
			       // convertFileToByteArray(file, function(byteArray) {
			         //   byteArrayList.push(byteArray);

			            formData.append('photos', file);
			       });
			            //console.log('Byte array for file ' + file.name + ':', byteArray);

			          /*  if (byteArrayList.length === files.length) {
			                $.ajax({
			                    type: 'POST',
			                    url: '/ConferenceRoomBooking/webapi/conf/upload', // Match your API endpoint
			                    data: formData,
			                    processData: false,
			                    contentType: false,
			                    dataType: 'json',
			                    cache: false,
			                    success: function(response) {
			                        console.log('Upload response:', response);
			                        if (response.status === 'success') {
			                            console.log('Files uploaded successfully');
			                        } else {
			                            console.log('Upload failed:', response.message);
			                        }
			                    },
			                    error: function(error) {
			                        console.log('Error:', error);
			                    }
			                });
			            }
			        });*/
			    $.ajax({
			        type: 'POST',
			        url: '/ConferenceRoomBooking/webapi/conf/upload', 
			        data: formData,
			        processData: false,  // Prevent jQuery from processing the data
			        contentType: false,  // Prevent jQuery from setting content type
			        dataType: 'json',
			        cache: false,        // Prevent caching
			        success: function(response) {
			            console.log('Photos added successfully', response);
			        },
			        error: function(error) {
			            console.log('Error:', error);
			        }
			    });
			    });
			});




		
	</script>
</body>
</html>