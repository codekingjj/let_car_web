package boardServer.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

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
            conn = DBManager.getConnection();

            String sql = "SELECT id, password, name, birth, gender, phone, address, admin_check FROM user WHERE id=? AND password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

            if (rs.next()) {
            	String name = rs.getString(3);
				String birth = rs.getString(4);
				String gender = rs.getString(5);
				String phone = rs.getString(6);
				String address = rs.getString(7);
				String adminCheck = rs.getString(8);
				
				
				user = new UserResponseDto(id, password, name, birth, gender, phone, address, adminCheck);
    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
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
	
	public UserResponseDto updateUserPassword(UserRequestDto userDto, String newPassword) {
		UserResponseDto user = null;
		
		if(newPassword == null || newPassword.equals("")) {
			return user;
		}
		
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE user SET password=? WHERE id=? AND password=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setString(2, userDto.getId());
			pstmt.setString(3, userDto.getPassword());
			
			pstmt.execute();
			
			User userVo = findUserById(userDto.getId());
			user = new UserResponseDto(userVo);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	private User findUserById(String id) {
		User user = null;
		
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT id, password, name, birth, gender, phone, reg_date, address FROM user WHERE id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String password = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String gender = rs.getString(5);
				String phone = rs.getString(6);
				Timestamp regDate = rs.getTimestamp(7);
				String address = rs.getString(8);
				
				user = new User(id, password, name, birth, gender, phone, regDate, address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public UserResponseDto updateUserPhone(UserRequestDto userDto) {
		UserResponseDto user = null;
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE user SET phone=? WHERE id=? AND password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, userDto.getPhone());
			pstmt.setString(3, userDto.getId());
			pstmt.setString(4, userDto.getPassword());
			
			pstmt.execute();
			
			user = findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean deleteUser(UserRequestDto userDto) {
		if(findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) == null)
			return false;
		
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM user WHERE id=? AND password=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, userDto.getPassword());
			
			pstmt.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
