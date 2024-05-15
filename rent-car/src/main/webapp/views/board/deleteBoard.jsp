<%@page import="boardServer.board.model.BoardDao"%>
<%@page import="boardServer.board.model.Board"%>
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
	<form method="POST" action="/DeleteBoardAction">
		비밀번호 : <input type="password" name="password" id="password" placeholder="비밀번호">
		<input type="hidden" name="userPassword" value="${user.password }">
		<input type="hidden" name="title" value="${board.title }">
		<input type="hidden" name="boardId" value="${board.boardId}">
		<input type="submit" value="삭제">
	</form>
</body>
</html>