package boardServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardServer.board.model.BoardDao;
import boardServer.board.model.BoardRequestDto;
import boardServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class WriteBoardAction
 */
public class WriteBoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WriteBoardAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String boardId = request.getParameter("board_id");
		String noticeCheck = "N";

		boolean isValid = true;

		if (title == null || title.equals(""))
			isValid = false;
		else if (content == null || content.equals(""))
			isValid = false;
		else if (boardId == null || boardId.equals(""))
			isValid = false;
		else if (noticeCheck == null || noticeCheck.equals(""))
			isValid = false;

		if (isValid) {
			BoardRequestDto boardDto = new BoardRequestDto(title, content, boardId, noticeCheck);
			BoardDao boardDao = BoardDao.getInstance();
			BoardResponseDto board = boardDao.createBoard(boardDto);
			
			if (board == null) {
				System.out.println("게시판X실패");
				response.sendRedirect("/board");
			}else {
				System.out.println("성공");
				response.sendRedirect("/home");
			}
			
		}
		else {
			System.out.println("isValid실패");
			response.sendRedirect("/board");
		}
	}

}
