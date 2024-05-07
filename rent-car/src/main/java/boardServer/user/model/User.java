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
	private Timestamp modDate;
	
	public User(String id, String name, String birth, String gender,
			String phone, String address, Timestamp regDate, Timestamp mogDate) {
		super();
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.regDate = regDate;
		this.modDate = mogDate;
	}


	public String getId() {
		return id;
	}
	
	
	public Timestamp getRegDate() {
		return regDate;
	}


	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}


	public Timestamp getModDate() {
		return modDate;
	}


	public void setModDate(Timestamp mogDate) {
		this.modDate = mogDate;
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
}
