package member.dao;

import member.vo.MemberVo;

public interface MemberDao {
	public void insertMember(MemberVo member);
	public void updateMember(MemberVo member);
	public MemberVo selectById(int id);
	public MemberVo selectAll(MemberVo member);
	public void deleteMember(int number);
	
}
