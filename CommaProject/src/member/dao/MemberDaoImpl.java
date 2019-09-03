package member.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.mapper.MemberMapper;
import member.vo.MemberVo;

@Repository("MemberDao")
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private MemberMapper memberMapper;
	

	@Override
	public void insertMember(MemberVo member) {
		// TODO Auto-generated method stub
		memberMapper.insertMember(member);
		
	}

	@Override
	public void updateMember(MemberVo member) {
		// TODO Auto-generated method stub
		memberMapper.updateMember(member);
		
	}

	@Override
	public MemberVo selectById(int number) {
		// TODO Auto-generated method stub
		return memberMapper.selectById(number);
	}

	@Override
	public MemberVo selectAll(MemberVo member) {
		// TODO Auto-generated method stub
		return memberMapper.selectAll(member);
	}

	@Override
	public void deleteMember(int number) {
		// TODO Auto-generated method stub
		memberMapper.deleteMember(number);
	}
	
	

}
