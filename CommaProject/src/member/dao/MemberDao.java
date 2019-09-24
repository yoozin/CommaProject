package member.dao;

import java.util.HashMap;
import java.util.List;

import member.vo.MemberVo;

public interface MemberDao {
	public List<MemberVo> getMemberList() throws Exception; 
	public MemberVo getMemberInfo(String id) throws Exception; 
	public void insertMember(MemberVo memberVO) throws Exception; 
	public void updateMember(MemberVo memberVO) throws Exception; 
	public void deleteMember(String id) throws Exception;
	public int idcheck(String memberId);
	public int pwdcheck(String memberPassword);

    
    
}


	

