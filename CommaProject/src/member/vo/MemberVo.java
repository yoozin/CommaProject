package member.vo;

import java.util.Date;

public class MemberVo {
	private int number;
	private String id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private Date regDate;
	private Date uDate;

	public Date getuDate() {
		return uDate;
	}
	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}
	
	public int getNumber() {
		return number;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public MemberVo(int number, String id, String name, String password, String email, String phone, Date regDate) {
		this.number = number;
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.regDate = regDate;
		
	}
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}
	
	
}
