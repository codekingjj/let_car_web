package boardServer.car.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBManager;


public class CarDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static CarDao instance = new CarDao();
	
	public static CarDao getInstance() {
		return instance;
	}
	
	public Car getCar(int carCode) {
		Car car = new Car();
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM car WHERE car_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, carCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				car.setCar(rs.getString(1));
				car.setCode(rs.getInt(2));
				car.setColor(rs.getString(3));
				car.setPax(rs.getInt(4));
				car.setFuel(rs.getString(5));
				car.setSize(rs.getString(6));
				car.setImage(rs.getString(7));
				car.setFee(rs.getInt(8));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return car;
	}
	
	public ArrayList<Car> getList() {
		ArrayList<Car> list = new ArrayList<Car>();
		
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM car ORDER BY car_code ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Car car= new Car();
				car.setCar(rs.getString(1));
				car.setCode(rs.getInt(2));
				car.setColor(rs.getString(3));
				car.setPax(rs.getInt(4));
				car.setFuel(rs.getString(5));
				car.setSize(rs.getString(6));
				car.setImage(rs.getString(7));
				car.setFee(rs.getInt(8));
				list.add(car);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
}
