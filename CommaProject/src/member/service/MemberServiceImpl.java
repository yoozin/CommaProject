package member.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import login.dto.LoginDto;
import member.dao.MemberDao;
import member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class); 
	
	@Autowired
	private MemberDao memberDAO;

	@Override
	public List<MemberVo> getMemberList() throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.getMemberList();
	}

	//로그인 매소드
	@Override
	public MemberVo loginMember(LoginDto loginDTO) throws Exception {
		
		String id = loginDTO.getMemberId();
		MemberVo member = memberDAO.getMemberInfo(id);
		
		return memberDAO.getMemberInfo(id);
	}

	
	
	
	@Override
	public void insertMember(MemberVo memberVO) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.insertMember(memberVO);
	}

	@Override
	public void updateMember(MemberVo memberVO) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.updateMember(memberVO);
	}

	@Override
	public void deleteMember(String id) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.deleteMember(id);
	}

	@Override
	public int idcheck(String memberId) {
		// TODO Auto-generated method stub
		return memberDAO.idcheck(memberId);
	}

	@Override
	public int pwdcheck(String memberPassword) {
		// TODO Auto-generated method stub
		return memberDAO.pwdcheck(memberPassword);
	}

}
