package boardServer.user.model;

public class UserResponseDto {
	private String id;
	private String password;
	private String name;
	private String birth;
	private String gender;
	private String phone;
	private String address;

	public UserResponseDto(String id, String password, String name, String birth, String gender,
			 String phone, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
	}
	
	public UserResponseDto(User user) {
		this.id = user.getId();
		this.password = user.getPassword();
		this.name = user.getName();
		this.birth = user.getBirth();
		this.gender = user.getGender();
		this.phone = user.getPhone();
		this.address = user.getAddress();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return String.format("%d/%d/%d", this.id, this.password, this.name);
	}
}
