<%@page import="boardServer.car.model.CarDao"%>
<%@page import="boardServer.car.model.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/reservation.css">
</head>
<body>
	<%
		int carCode = 0;
		if (request.getParameter("carCode") != null) {
			carCode = Integer.parseInt(request.getParameter("carCode"));
		}
		Car car = new CarDao().getCar(carCode);
		request.setAttribute("car", car);
	%>
	<form method="POST" action="/ReservationAction" class="reservationForm">
		<img src="${car.image }">
		<input type="hidden" name ="carCode" value="${car.code }">
		<input type="hidden" name ="car" value="${car.car }">
		<input type="hidden" name = "id" value="${user.id }">
		<div>
		차종 : <input type="text" value="${car.car }" disabled>
		</div>
		<div>
		색상 : <input type="text" value="${car.color }" disabled>
		</div>
		<div>
		탑승 가능 인원 : <input type="number" value="${car.pax }" disabled>
		</div>
		<div>
		연료 : <input type="text" value="${car.fuel }" disabled>
		</div>
		<div>
		1일 이용 요금 : <input type="number" value="${car.fee }" disabled>
		</div>
		<div>
			대여 시작일 : <input type="date" name="startDate" id="startDate">
		</div>
		<div>
			대여 종료일 : <input type="date" name="endDate" id="endDate">
		</div>
		<div>
			<input type="submit" value="예약 하기">
		</div>
	</form>
</body>
</html>