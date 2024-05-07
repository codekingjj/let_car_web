package boardServer.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import boardServer.user.model.UserResponseDto;
import util.DBManager;

public class UserDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	public UserResponseDto findUserByIdAndPassword(String id, String password) {
		UserResponseDto user = null;
		
		try {
			//쿼리할 준비
			String sql = "SELECT id, password, name, birth, gender, phone, address FROM users WHERE id=? AND password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			pstmt.setString(2,  password);
			
			//쿼리 실행
			rs = pstmt.executeQuery();
			
			//튜플 읽기
			if(rs.next()) {
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String gender = rs.getString(5);
				String phone = rs.getString(6);
				String address = rs.getString(8);
				
				user = new UserResponseDto(id, password, name, birth, gender, phone, address);
				System.out.println(user.getId());
				System.out.println(user.getPassword());
				System.out.println(user.getName());
				System.out.println(user.getBirth());
				System.out.println(user.getGender());
				System.out.println(user.getPhone());
				System.out.println(user.getAddress());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return user;
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
		System.out.println(userDto.getAddress());
		
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO user(id, password, name, birth, gender, phone, address)" + 
					"VALUES(?, ?, ?, ?, ?, ?, ?)";
					
			pstmt = conn.prepareStatement(sql);
			
			//sql 구문에 맵핑할 값 설정
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, userDto.getPassword());
			pstmt.setString(3, userDto.getName());
			pstmt.setString(4, userDto.getBirth());
			pstmt.setString(5, userDto.getGender());
			pstmt.setString(6, userDto.getPhone());
			pstmt.setString(7, userDto.getAddress());
			
			pstmt.execute();
			
			return findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
}
