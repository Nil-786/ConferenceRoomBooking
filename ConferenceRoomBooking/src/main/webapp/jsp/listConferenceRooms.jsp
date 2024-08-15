<%@page import="com.confRoomBooking.models.ConferenceRoom"%>
<%@page import="java.util.List"%>
<%@page import="com.confRoomBooking.services.confService"%>
<%@page import="com.confRoomBooking.services.confServiceImpl"%>
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
	<jsp:include page="cdn.jsp"></jsp:include>
	<%!User user = new User();
		confServiceImpl confSer = new confService();%>
	<%
	user = (User) request.getSession().getAttribute("user");
	%>

	<jsp:include page="sidebar.jsp">
		<jsp:param value="<%=user.getUserName()%>" name="uName" />
	</jsp:include>

	<%
		List<ConferenceRoom> confList  = confSer.getAllConf();
		for(ConferenceRoom conf:confList){
	%>
		<jsp:include page="confRoomCard.jsp">
			<jsp:param value="<%= conf.getName() %>" name="name"/>
			<jsp:param value="<%= conf.getCapacity() %>" name="capacity"/>
			<jsp:param value="<%= conf.getId() %>" name="id"/>
		</jsp:include>
	<%
		}
	%>
</body>
</html>