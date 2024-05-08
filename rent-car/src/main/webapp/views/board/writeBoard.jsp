<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/writeBoardForm.css">
</head>
<script src="/resources/script/validation-boardWrite.js"></script>
<jsp:include page="/header"></jsp:include>
<body>
	<c:choose>

	</c:choose>
	<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("/login");
	}
	%>
	<h1>게시판 글쓰기</h1>
	<form method="POST" action="/WriteBoardAction">
		<input type="text" name="title" id="title">
		<input type="text" name="content" id="content">
		<input type="text" id="board_id" name="board_id" value="${user.id }" disabled>
	</form>
</body>
</html>