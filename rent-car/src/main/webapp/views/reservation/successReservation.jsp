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
	if(session.getAttribute("user") == null) {
		response.sendRedirect("/login");		
	}
	%>
<h2>예약이 완료되었습니다.</h2>
<button onclick="location.href='/checkReservation?id=${user.id}'">예약 확인하기</button>
</body>
</html>