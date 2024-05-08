package boardServer.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import boardServer.user.model.UserDao;
import boardServer.user.model.UserRequestDto;
import boardServer.user.model.UserResponseDto;

/**
 * Servlet implementation class UpdateAction
 */

public class UpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAction() {
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

		UserDao userDao = UserDao.getInstance();
		HttpSession session = request.getSession();
		UserResponseDto user = (UserResponseDto) session.getAttribute("user");

		String password = request.getParameter("password");
		if(userDao.findUserByIdAndPassword(user.getId(), password) != null) {
			UserRequestDto userDto = new UserRequestDto();
			
			userDto.setId(user.getId());
			userDto.setPassword(password);
			
			String newPassword = request.getParameter("password-new");
			
			String phone = request.getParameter("phone");
			
			if(!newPassword.equals("") && !newPassword.equals(password)) {
				user = userDao.updateUserPassword(userDto, newPassword);
			}
			
			
			
			if(!user.getPhone().equals(phone)) {
				userDto.setPhone(phone);
				user = userDao.updateUserPhone(userDto);
			}
		}
		session.setAttribute("user", user);
		response.sendRedirect("/mypage");
	}

}
