package boardServer.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDao() {
		setConnection();
		
	}
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	private void setConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/lent_car_db";
			String user = "root";
			String password = "root";
			this.conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("데이터 베이스 연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("데이터 베이스 연결 실패");
		}
	}
}
