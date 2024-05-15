<%@page import="boardServer.car.model.Car"%>
<%@page import="java.util.ArrayList"%>
<%@page import="boardServer.car.model.CarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/carInfo.css">
<title>Insert title here</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<%
	if(session.getAttribute("user") == null) {
		response.sendRedirect("/login");		
	}
	%>
	<h1>차량 목록</h1>
	<div class="container">
			<%
			
				CarDao carDao= new CarDao();
				ArrayList<Car> list = carDao.getList();
		
				for(int i = 0; i < list.size(); i++) {
			%>
				<div class="car">
				<a href="/reservation?carCode=<%= list.get(i).getCode() %>"><img src="<%= list.get(i).getImage()%>"></a>
				차종 : <%= list.get(i).getCar() %><br>
				색상 : <%= list.get(i).getColor()%><br>
				탑승 가능 인원 : <%= list.get(i).getPax() %><br>
				연료 종류 : <%= list.get(i).getFuel() %><br>
				차 분류 : <%= list.get(i).getSize() %><br>
				1일 이용료 : <%= list.get(i).getFee() %>원
				<button onclick="location.href='/reservation?carCode=<%= list.get(i).getCode() %>'">예약하러 가기</button>
				
				</div>
				
			<% 
			
				}
			%>
			</div>
</body>
</html>