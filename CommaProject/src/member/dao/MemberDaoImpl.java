package member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.mapper.MemberMapper;
import member.vo.MemberVo;

@Repository 
	public class MemberDaoImpl implements MemberDao{ 
		
		@Autowired 
		private MemberMapper memberMapper; 
		
		
		
		
		
		@Override public List<MemberVo> getMemberList() throws Exception { 
			return memberMapper.getMemberList(); 
			
		} 
		
		@Override 
		public MemberVo getMemberInfo(String id) throws Exception { 
			MemberVo member = memberMapper.getMemberInfo(id);
			
			return memberMapper.getMemberInfo(id); 
			
		} 
		
		@Override 
		public void insertMember(MemberVo memberVO) throws Exception { 
			
			memberMapper.insertMember(memberVO);
			
		} 
		
		
		@Override 
		public void updateMember(MemberVo memberVO) throws Exception { 
			
			memberMapper.updateMember(memberVO);
			
		} 
		
		@Override 
		public void deleteMember(String id) throws Exception { 
			
			memberMapper.deleteMember(id);
			
		}

		@Override
		public int idcheck(String memberId) {
			// TODO Auto-generated method stub
			return memberMapper.idcheck(memberId);
		}

		@Override
		public int pwdcheck(String memberPassword) {
			// TODO Auto-generated method stub
			
			return memberMapper.pwdcheck(memberPassword);
		}

		
		
	
	
	
}
