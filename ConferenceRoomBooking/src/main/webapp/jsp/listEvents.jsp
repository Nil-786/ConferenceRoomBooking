<%@page import="com.confRoomBooking.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!User user = new User();%>

	<%
	user = (User) request.getSession().getAttribute("user");
	%>
	<jsp:include page="sidebar.jsp">
		<jsp:param value="<%=user.getUserName()%>" name="uName" />
	</jsp:include>
</body>
</html>