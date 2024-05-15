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
<jsp:include page="/header"></jsp:include>
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
	<h2>게시글 수정</h2>
	<form method="POST" action="/UpdateBoardAction" >
		<input type="hidden" name="pre_title" id="pre_title" value="${board.title }">
		<input type="hidden" name="pre_boardId" id="pre_boardId" value="${board.boardId }">
		<input type="text" name="title" id="title" value="${board.title }">
		<input type="text" name="content" id="content" value="${board.content }">
		<input type="hidden" id="board_id" name="board_id" value="${user.id }">
		<input type="submit" value="수정">
	</form>
</body>
</html>