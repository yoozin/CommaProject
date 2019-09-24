package login.dto;

public class LoginDto {

	private String memberId;
	private String memberPassword;
	private boolean memberCookie;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public boolean isMemberCookie() {
		return memberCookie;
	}
	public void setMemberCookie(boolean memberCookie) {
		this.memberCookie = memberCookie;
	}
	public LoginDto(String memberId, String memberPassword, boolean memberCookie) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberCookie = memberCookie;
	}
	public LoginDto() {
		super();
	}
	@Override
	public String toString() {
		return "LoginDto [memberId=" + memberId + ", memberPassword=" + memberPassword + ", memberCookie="
				+ memberCookie + "]";
	}
	
	
}
