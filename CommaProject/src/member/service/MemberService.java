package member.service;

import java.util.List;

import login.dto.LoginDto;
import member.vo.MemberVo;

public interface MemberService {

	
	public List<MemberVo> getMemberList() throws Exception; 
	
	public MemberVo loginMember(LoginDto loginDTO) throws Exception; 
	
	public void insertMember(MemberVo memberVO) throws Exception; 
	
	public void updateMember(MemberVo memberVO) throws Exception; 
	
	public void deleteMember(String id) throws Exception;

	public int idcheck(String memberId);

	public int pwdcheck(String memberPassword);
}
