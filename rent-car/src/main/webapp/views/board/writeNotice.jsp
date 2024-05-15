<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("/login");
	}
	%>
	<h1>공지글쓰기</h1>
	<form method="POST" action="/WriteNoticeAction">
		<input type="text" name="title" id="title">
		<input type="text" name="content" id="content">
		<input type="hidden" id="board_id" name="board_id" value="${user.id }">
		<input type="submit" value="저장">
	</form>
</body>
</html>