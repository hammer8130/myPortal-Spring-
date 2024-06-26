package himedia.myportal.repositories.vo;

import java.util.Date;

public class UserVO {

	private Long no;
	private String name;
	private String email;
	private String password;
	private String gender;
	private Date createdAt;

//	생성자
	public UserVO() {

	}

	public UserVO(String name, String email, String password, String gender) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "UserVO [번호=" + no + ", 이름=" + name + ", 이메일=" + email + ", 비밀번호=" + password + ", 성별=" + gender
				+ ", 생성일자=" + createdAt + "]";
	}

}
