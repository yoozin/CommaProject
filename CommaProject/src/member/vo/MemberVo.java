package member.vo;

import java.util.Date;

public class MemberVo {
	int memberNumber;
	String memberId; 
	String memberName; 
	String memberPassword; 
	String memberEmail; 
	String memberPhone; 
	String memberRegdate; 
	String memberUdate;
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberRegdate() {
		return memberRegdate;
	}
	public void setMemberRegdate(String memberRegdate) {
		this.memberRegdate = memberRegdate;
	}
	public String getMemberUdate() {
		return memberUdate;
	}
	public void setMemberUdate(String memberUdate) {
		this.memberUdate = memberUdate;
	}
	public MemberVo(int memberNumber, String memberId, String memberName, String memberPassword, String memberEmail,
			String memberPhone, String memberRegdate, String memberUdate) {
		super();
		this.memberNumber = memberNumber;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPassword = memberPassword;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberRegdate = memberRegdate;
		this.memberUdate = memberUdate;
	}
	public MemberVo() {
		super();
	}
	@Override
	public String toString() {
		return "MemberVo [memberNumber=" + memberNumber + ", memberId=" + memberId + ", memberName=" + memberName
				+ ", memberPassword=" + memberPassword + ", memberEmail=" + memberEmail + ", memberPhone=" + memberPhone
				+ ", memberRegdate=" + memberRegdate + ", memberUdate=" + memberUdate + "]";
	}
	
	
}
