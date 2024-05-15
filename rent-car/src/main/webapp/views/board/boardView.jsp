<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="boardServer.board.model.BoardDao"%>
<%@page import="boardServer.board.model.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<%
	if(session.getAttribute("user") == null) {
		response.sendRedirect("/login");		
	}
	
	String title = "";
	String boardId = "";
	if (request.getParameter("title") != null) {
		title = request.getParameter("title");
	}
	if (request.getParameter("boardId") != null) {
		boardId = request.getParameter("boardId");
	}
	
	Board board = new BoardDao().getContent(title, boardId);
	request.setAttribute("board", board);	
	%>
	<table class="table-striped">
		<thead>
			<tr>
				<th>게시판 글 보기</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>글 제목</td>
				<td colspan="2">${board.title }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${board.boardId}</td>
			</tr>
			<tr>
				<td>작성일자</td>
				<td>${board.regDate }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${board.content }</td>
			</tr>
		</tbody>
	</table>

	<button onclick="location.href='/board'">목록</button>
		<c:choose>
			<c:when test="${user.id == board.boardId}">
            <button onclick="location.href='/updateBoard?title=${board.title }&boardId=${board.boardId}'">게시글 수정</button>
            <button onclick="location.href='/deleteBoard?title=${board.title }&boardId=${board.boardId}'">게시글 삭제</button>
         </c:when>
         </c:choose>
</body>
</html>