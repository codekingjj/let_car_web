<%@page import="util.DBManager"%>
<%@page import="boardServer.car.CarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		DBManager dbManager = new DBManager();
		
		CarDao car = new CarDao();
		car.getCarInfo();
		
	%>
</body>
</html>