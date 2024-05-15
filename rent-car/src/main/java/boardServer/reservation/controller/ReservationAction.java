package boardServer.reservation.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardServer.reservation.model.ReservationDao;
import boardServer.reservation.model.ReservationRequestDto;
import boardServer.reservation.model.ReservationResponseDto;

/**
 * Servlet implementation class ReservationAction
 */
public class ReservationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationAction() {
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
		
		String id = request.getParameter("id");
		int carCode = Integer.parseInt(request.getParameter("carCode"));
		String car = request.getParameter("car");
		LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
		LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
		
		
		
		
		// Backend 에서 전달받은 데이터에 대한 유효성 검증 
		boolean isValid = true;
		
		if(startDate == null || startDate.equals(""))
			isValid = false;
		else if(endDate == null || endDate.equals(""))
			isValid = false;
		else if(car == null || car.equals(""))
			isValid = false;
		
		if(isValid) {
			ReservationRequestDto reservationDto = new ReservationRequestDto(id, carCode, car, startDate, endDate);
			ReservationDao reservationDao = ReservationDao.getInstance();
			ReservationResponseDto reservation = reservationDao.createReservation(reservationDto);
			
			if (reservation == null) {
				response.sendRedirect("/successReservation");
			}else {
				response.sendRedirect("/board");
			}
		}else {
			response.sendRedirect("/home");
		}
	}

}
