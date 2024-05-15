<%@page import="boardServer.reservation.model.ReservationResponseDto"%>
<%@page import="boardServer.user.model.User"%>
<%@page import="boardServer.reservation.model.ReservationDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%
	if(session.getAttribute("user") == null) {
		response.sendRedirect("/login");		
	}
	User user = (User)request.getAttribute("user");
	String id = user.getId();
	ReservationResponseDto reservation = new ReservationDao().findReservationById(id);
	if(reservation != null) {
		
	%>
	
	<%
	}
	%>
	
	
	
	
</body>
</html>