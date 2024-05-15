package boardServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardServer.board.model.BoardDao;
import boardServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class DeleteBoardAction
 */
public class DeleteBoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoardAction() {
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
		String boardId = request.getParameter("boardId");
		String password = request.getParameter("password");
		String userPassword = request.getParameter("userPassword");
		
		System.out.println("UpdateBoardAction");
		System.out.println(title);
		System.out.println(boardId);
		System.out.println(password);
		System.out.println(userPassword);
		boolean isValid = true;
		
		if(!password.equals(userPassword))
			isValid = false;
		
		if(isValid) {
			// 연동된 데이터 베이스로부터		(UserDao)
			// 유저의 정보를 조회 하고,		(findUserByIdAndPassword())
			// 정보가 일치하면				(return된 UserResponseDto가 null이 아니면)
			// 로그인 처리 후, 페이지 이동		(jsp 내장객체 중 session에 유저정보 저장)
			
			BoardDao boardDao = BoardDao.getInstance();
			boardDao.deleteBoard(title, boardId);
			
			response.sendRedirect("/board");				
			
		} else {
			response.sendRedirect("/home");
		}
	}

}
