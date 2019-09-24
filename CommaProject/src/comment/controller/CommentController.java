package comment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import comment.service.CommentService;
import comment.vo.CommentVO;
import commons.Criteria;
import commons.PageMaker;
import member.vo.MemberVo;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	
	

	
	@RequestMapping(value = "/create.do",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createComment(CommentVO comment) {
		System.out.println("create.do");
		ResponseEntity<String> entity = null;
		System.out.println(comment.getCommentWriter());
		System.out.println(comment.getCommentText());
		System.out.println(comment.getBoardId());
		
		try {
			System.out.println("Create");
			commentService.createComment(comment);
			entity = new ResponseEntity<>("regSuccess",HttpStatus.OK);
			
			
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
		
//		MemberVo member= (MemberVo) session.getAttribute("loginInfo");
//		Map<Object, Object> map = new HashMap<Object, Object>();
//		
//		model.addAttribute("member", member);
//		
//		model.addAttribute("comment",comment);
//		commentService.createComment(comment);
//		System.out.println(comment+"controller");
//		
		
		
		return entity;
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/all" , method = RequestMethod.GET)
	public ResponseEntity<List<CommentVO>> list(int boardId,Model model) throws Exception{
		ResponseEntity<List<CommentVO>> entity = null;
		
		try {
			
			entity = new ResponseEntity<>(commentService.commentList(boardId),HttpStatus.OK);
			model.addAttribute("list",entity);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
//		
//		List<CommentVO> clist = commentService.commentList(comment);
//		model.addAttribute("clist",clist);
//		System.out.println(clist);
		return entity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/{boardId}", method= {RequestMethod.PUT,RequestMethod.PATCH})
	public ResponseEntity<String> updateComment(@PathVariable("commentNo")int boardId,@RequestBody CommentVO comment) {
		ResponseEntity<String> entity = null;
		try {
			comment.setCommentNo(boardId);
			commentService.updateComment(comment);
			entity = new ResponseEntity<>("updateSuccess",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	
	
	@RequestMapping(value="/{commentNo}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteComment(@PathVariable("commentNo") int commentNo) {
		ResponseEntity<String> entity = null;
		
		try {
			commentService.deleteComment(commentNo);
			entity = new ResponseEntity<>("deleteSuccess",HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	@RequestMapping(value="/{boardId}/{page}",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>>listPaging(@PathVariable("boardId") int boardId, @PathVariable("page") int page){
		ResponseEntity<Map<String,Object>> entity=null;
		
		try {
			Criteria criteria = new Criteria();
			criteria.setPage(page);
			List<CommentVO> comment = commentService.getCommentPaging(boardId, criteria);
			int commentCount = commentService.countComment(boardId);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCriteria(criteria);
			pageMaker.setTotalCount(commentCount);
			
			Map<String,Object> map = new HashMap<>();
			map.put("comment", comment);
			map.put("pageMake", pageMaker);
			
			
		} catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(HttpStatus.OK);
		}
		return entity;
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/selectOne")
	public String selectOneComment(Model model, CommentVO comment) {
		model.addAttribute("selectOne", comment);
		commentService.selectOneComment(comment);
		return "/WEB-INF/views/updateCommentResult.jsp";
	}
}
