package boardServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import boardServer.board.model.Board;
import boardServer.board.model.BoardDao;
import boardServer.board.model.BoardResponseDto;
import boardServer.user.model.UserDao;
import boardServer.user.model.UserResponseDto;

/**
 * Servlet implementation class UpdateBoardAction
 */
public class UpdateBoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoardAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String boardId = request.getParameter("board_id");
		String preTitle = request.getParameter("pre_title");
		String preBoardId = request.getParameter("pre_boardId");
		
		System.out.println("UpdateBoardAction");
		System.out.println(title);
		System.out.println(content);
		System.out.println(boardId);
		System.out.println(preTitle);
		System.out.println(preBoardId);
		boolean isValid = true;
		
		if(title == null || title.equals(""))
			isValid = false;
		else if(content == null || content.equals(""))
			isValid = false;
		
		if(isValid) {
			// 연동된 데이터 베이스로부터		(UserDao)
			// 유저의 정보를 조회 하고,		(findUserByIdAndPassword())
			// 정보가 일치하면				(return된 UserResponseDto가 null이 아니면)
			// 로그인 처리 후, 페이지 이동		(jsp 내장객체 중 session에 유저정보 저장)
			
			BoardDao boardDao = BoardDao.getInstance();
			BoardResponseDto board = boardDao.findAndUpdateBoardByTitleAndBoardId(title, content, boardId, preTitle, preBoardId);
			if(board != null) {
				response.sendRedirect("/board");				
			} else {
				response.sendRedirect("/unwelcome");				
			}
		} else {
			response.sendRedirect("/home");
		}
	}

}
