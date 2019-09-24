package member.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import login.dto.LoginDto;
import member.service.MemberService;
import member.vo.MemberVo;

@Controller 
@RequestMapping("/member") 
public class MemberController { 
	
	
	@Autowired
	private MemberService memberService; 
	
	
	
	@RequestMapping(value = "/getMemberList", method = RequestMethod.GET) 
	public String getMemberList(Model model) throws Exception{ 
		
		
		model.addAttribute("memberList", memberService.getMemberList());
		
		return "member/memberList"; 
		
	} 
	
	
	@RequestMapping("/idcheck.do")
    @ResponseBody
    public Map<Object, Object> idcheck(@RequestBody String memberId) {
        System.out.println("incheckcontroller");
        int count = 0;
        Map<Object, Object> map = new HashMap<Object, Object>();
        
        count = memberService.idcheck(memberId);
        System.out.println(count);
        map.put("cnt", count);
 
        return map;
    }
 
	
	
	
	@RequestMapping("/signup")
	public String registerMember()throws Exception{
		
		
		return "/WEB-INF/views/login/signupForm.jsp";
	}
	
	
	
	
	@RequestMapping(value = "/insertMember", method= RequestMethod.POST) 
	public String insertMember(MemberVo memberVO, Model model) throws Exception { 
		System.out.println(memberVO);
		model.addAttribute("memberVO" , memberVO);
		memberService.insertMember(memberVO); 
		//회원가입 인증메일 보내기 추가예정(메일샌더서비스 검색해서..)
		
		System.out.println(memberVO.getMemberId()+" , "+memberVO.getMemberName());
		
		
		return "LoginWithSession"; 
		
	}
	
	
	
	@RequestMapping(value = "/loginIdCheck.do", method = RequestMethod.POST) 
	@ResponseBody
	public Map<Object, Object> loginId(@RequestBody String memberId) { 
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		System.out.println(memberId);
		
		///test
		
		int countId;
		
		
		countId = memberService.idcheck(memberId);
	    map.put("cnt", countId);
	    return map;
		
		}
	
	
	
	
	@RequestMapping(value = "/loginPwdCheck.do", method = RequestMethod.POST) 
	@ResponseBody
	public Map<Object, Object> loginPassword(@RequestBody String Password) throws Exception { 
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		System.out.println(Password);
		
		///test
		
		int countPassword;
		
		
		countPassword = memberService.pwdcheck(Password);
	    map.put("cnt", countPassword);

		return map;
		
		
		
		}
	
	
	@RequestMapping(value = "/LoginWithSession")
	public String LoginWithSession(LoginDto loginDTO, HttpSession session) throws Exception{
	
		
		
		System.out.println("longinDto ::"+loginDTO);
		MemberVo member = memberService.loginMember(loginDTO);
		session.setAttribute("loginInfo",member);
		System.out.println("로그인이 완료되었습니다.");
		
		return "redirect:/contact.jsp";
		
	}

	
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String test(MemberVo memberVO, Model model, HttpSession session) {
		
		System.out.println((String)session.getAttribute("loginId"));
		
		return "main";
      }
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		
		request.getSession().removeAttribute("loginInfo");
		model.addAttribute("","");
		
		return "/index.jsp";
      }
	
	 
	
}