package boardServer.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBManager;

public class UserDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	public UserResponseDto createUser(UserRequestDto userDto) {
		// sql 구문을 쿼리하고
		// 실행한 결과(resultSet)을 가져와
		// 성공을 했다면 -> UserResponseDto 객체 생성하여
		// 반환 
		System.out.println(userDto.getId());
		System.out.println(userDto.getPassword());
		System.out.println(userDto.getName());
		System.out.println(userDto.getBirth());
		System.out.println(userDto.getGender());
		System.out.println(userDto.getPhone());
		
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO users(id, password, email, name, birth, gender, country, telecom, phone, agree)" + 
					"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					
			pstmt = conn.prepareStatement(sql);
			
			//sql 구문에 맵핑할 값 설정
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, userDto.getPassword());
			pstmt.setString(3, userDto.getName());
			pstmt.setString(4, userDto.getBirth());
			pstmt.setString(5, userDto.getPhone());

			pstmt.execute();
			
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
}
