package boardServer.user.model;

import java.sql.Timestamp;

public class User {
	private String id;
	private String password;
	private String name;
	private String birth;
	private String gender;
	private String phone;
	private String address;
	private Timestamp regDate;
	private String admin;
	
	public User(String id, String password, String name, String birth, String gender,
			String phone, Timestamp regDate, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.regDate = regDate;
		this.address = address;
	}
	
	public User(String id, String password, String name, String birth, String gender,
			String phone, Timestamp regDate, String address, String admin) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.regDate = regDate;
		this.address = address;
		this.admin = admin;
	}

	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	
	public Timestamp getRegDate() {
		return regDate;
	}


	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getBirth() {
		return birth;
	}
	
	public String getGender() {
		return gender;
	}
	
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;	
	}
	public String getAdmin() {
		return admin;
	}
	
	public void setAdmin(String admin) {
		this.admin = admin;
	}
}
