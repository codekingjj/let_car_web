package boardServer.reservation.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import util.DBManager;

public class ReservationDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static ReservationDao instance = new ReservationDao();
	
	public static ReservationDao getInstance() {
		return instance;
	}
	
	public ReservationResponseDto findReservationById(String id) {
		ReservationResponseDto reservation = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT * FROM reservation WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String userid = rs.getString(1);
				String car = rs.getString(2);
				int carCode = rs.getInt(3);
				LocalDate startDate = LocalDate.parse(rs.getString(4));
				LocalDate endDate = LocalDate.parse(rs.getString(5));
				String payState = rs.getString(6);
				
				reservation = new ReservationResponseDto(userid, car, carCode, startDate, endDate, payState);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
            DBManager.close(conn, pstmt);
        }
		return reservation;
	}
	
	public ReservationResponseDto findReservatioinByIdAndCarCode(String id, int carcode) {
		ReservationResponseDto reservation = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT * FROM reservation WHERE id=? AND car_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			pstmt.setInt(2, carcode);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String userid = rs.getString(1);
				String car = rs.getString(2);
				int carCode = rs.getInt(3);
				LocalDate startDate = LocalDate.parse(rs.getString(4));
				LocalDate endDate = LocalDate.parse(rs.getString(5));
				String payState = rs.getString(6);
				
				reservation = new ReservationResponseDto(userid, car, carCode, startDate, endDate, payState);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
            DBManager.close(conn, pstmt);
        }
		return reservation;
		
	}
	
	public ReservationResponseDto createReservation(ReservationRequestDto reservationDto) {
		try {
			Date startDate = Date.valueOf(reservationDto.getRentStartDate());
			Date endDate = Date.valueOf(reservationDto.getRentEndDate());
			conn = DBManager.getConnection();
			String sql = "INSERT INTO reservation(id, car, car_code, rent_startDate, rent_endDate)" + 
					"VALUES(?, ?, ?, ?, ?)";
					
			pstmt = conn.prepareStatement(sql);
			
			//sql 구문에 맵핑할 값 설정
			pstmt.setString(1, reservationDto.getId());
			pstmt.setString(2, reservationDto.getCar());
			pstmt.setInt(3, reservationDto.getCarCode());
			pstmt.setDate(4, startDate);
			pstmt.setDate(5, endDate);
			
			pstmt.execute();
			
			return findReservatioinByIdAndCarCode(reservationDto.getId(), reservationDto.getCarCode());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
}
