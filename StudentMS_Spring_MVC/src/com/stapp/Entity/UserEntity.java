package com.stapp.Entity;

public class UserEntity {

	private long id;
	private String name;
	private String password;
	private String email;
	private String contactNum;
	private String resetCode;
	private long orgId;
	private String role;
	private boolean enable;
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(long id, String name, String password, String email, String contactNum, String resetCode,
			long orgId, String role, boolean enable) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.contactNum = contactNum;
		this.resetCode = resetCode;
		this.orgId = orgId;
		this.role = role;
		this.enable = enable;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getResetCode() {
		return resetCode;
	}

	public void setResetCode(String resetCode) {
		this.resetCode = resetCode;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", contactNum=" + contactNum + ", resetCode=" + resetCode + ", orgId=" + orgId + ", role=" + role
				+ ", enable=" + enable + "]";
	}
	
	
	
}
