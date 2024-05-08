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
	session.removeAttribute("user");
%>
	로그아웃 되었습니다.
	<button onclick ="location.href='/home'">홈페이지 바로가기</button>
</body>
</html>