package member.mapper;

import member.vo.MemberVo;

public interface MemberMapper {
	public void insertMember(MemberVo member);
	public void updateMember(MemberVo member);
	public MemberVo selectById(int id);
	public MemberVo selectAll(MemberVo member);
	public void deleteMember(int number);
}
