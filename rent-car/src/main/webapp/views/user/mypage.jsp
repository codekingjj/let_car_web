<%@page import="boardServer.user.model.UserResponseDto"%>
<%@page import="boardServer.user.model.User"%>
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
	<h1>${user.name}님 환영합니다!</h1>
		<button onclick="location.href='/updateUser'">회원정보 수정</button>
		<button onclick="location.href='/deleteUser'">회원 탈퇴</button>
		<button onclick="location.href='/home'">홈페이지 바로가기</button>
</body>
</html>