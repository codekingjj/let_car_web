<%@page import="java.util.ArrayList"%>
<%@page import="boardServer.board.model.BoardDao"%>
<%@page import="boardServer.board.model.Board"%>
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
	<div class="container">
	<div class="row">
	
	<table class="table-striped">
		<thead>
			<tr>
			 <th>제목</th>
			 <th>작성자</th>
			 <th>작성시간</th>
			</tr>
		</thead>
		<tbody>
			<%
			
				BoardDao boardDao= new BoardDao();
				ArrayList<Board> list = boardDao.getList();
				
				for(int i = 0; i < list.size(); i++) {
			%>
				<tr>
				<td><a href="/boardView?title=<%= list.get(i).getTitle() %>&boardId=<%= list.get(i).getBoardId()%>"><%= list.get(i).getTitle() %></a></td>
				<td><%= list.get(i).getBoardId() %></td>
				<td><%= list.get(i).getRegDate(). substring(0, 11) + list.get(i).getRegDate().substring(11, 13) + "시" + list.get(i).getRegDate().substring(14, 16) + "분" %></td>
				</tr>
			<% 
			
				}
			%>
			
		</tbody>
	</table>
	</div>
	</div>
	<c:choose>
			<c:when test="${user.adminCheck == 'Y'}">
				<button onclick="location.href='/writeNotice'">공지글 작성</button>
			</c:when>
	</c:choose>
	<button onclick="location.href='/writeBoard'">글쓰기</button>
</body>
</html>