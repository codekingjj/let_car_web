<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/board.css">
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<%
	if(session.getAttribute("user") == null) {
		response.sendRedirect("/login");		
	}
	%>
	<h1>게시판</h1>
	<c:choose>
			<c:when test="${user.adminCheck == 'Y'}">
				<button onclick="location.href='/writeNotice'">공지글 작성</button>
			</c:when>
	</c:choose>
	<button onclick="location.href='/writeBoard'">글쓰기</button>
</body>
</html>