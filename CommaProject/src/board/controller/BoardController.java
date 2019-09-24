package board.controller;

import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import board.common.Search;
import board.image.BaseToImgDecoder;
import board.service.BoardService;
import board.vo.BoardVO;
import comment.service.CommentService;
import comment.vo.CommentVO;
import member.vo.MemberVo;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private CommentService commentService;

	
	@GetMapping("board/index")
	public String index(Model model) {
	    
	    return "/index.jsp";
	}

	
	
	@RequestMapping("board")
	public String board(Model model) {
	    //로그인 체크 
		
	    return "//WEB-INF/views/boardWrite.jsp";
	}
	
	
	
	@RequestMapping("board/write")
	public String write(BoardVO board, Model model ) throws Exception {
		board.setReplyCount(0);
		
		BaseToImgDecoder baseDecoder = new BaseToImgDecoder();
		board.setContent(baseDecoder.decoder(board.getContent()));
		
		BoardVO createboard = boardService.createBoard(board);
		model.addAttribute("board", createboard);
		return "/WEB-INF/views/boardResult.jsp";
	}
	
	
	@RequestMapping("board/viewOne")
	public String boardViewOne(Model model , BoardVO board, HttpSession session) {
		session.getAttribute("loginInfo");
		MemberVo member= (MemberVo) session.getAttribute("loginInfo");
		System.out.println("viewOne");
		model.addAttribute("member", member);
		
		//수정해야함 리플라이카운트
		board.setReplyCount(0);
		BoardVO boardOne = boardService.selectOneBoard(board.getBoardId());
		model.addAttribute("board", boardOne);
	
		
		List<CommentVO> list = commentService.commentList(board.getBoardId());
		model.addAttribute("list", list);
		System.out.println("controller list"+list);
		return "/WEB-INF/views/boardResult.jsp";
	}
	
	
	@RequestMapping("board/modify")
	public String boardEditPre(Model model, int boardId) throws Exception {
		BoardVO boardOne = boardService.read(boardId);
		model.addAttribute("board", boardOne);
		return "/WEB-INF/views/boardEdit.jsp";	
	}
	
	@RequestMapping("board/modifyUpload")
	public String boardEditor(Model model, BoardVO board) {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String updatedTime = date.format(time);
		board.setuDate(updatedTime);
		BoardVO updatedBoard = boardService.updateBoard(board);	
		System.out.println(board);
		return "forward:/board/viewOne";
	}
	

	@RequestMapping("board/delete")
	public String boardDeleter(Model model, BoardVO board) {
		System.out.println(board);
		boardService.deleteBoard(board);
		System.out.println("성공");
		return "redirect:/board/list";
	}
	
	   @RequestMapping("board/list")
       public String getBoardList(Model model, @RequestParam(required=false, defaultValue="1")int page, @RequestParam(required=false, defaultValue="1") int range, @RequestParam(required=false,defaultValue="title") String searchType, @RequestParam(required=false)String keyword) throws Exception{
        
       Search search = new Search();
       search.setSearchType(searchType);
       search.setKeyword(keyword);
       
       //전체 게시글 개수
       int listCnt = boardService.selectBoardListCnt(search);
       search.pageInfo(page, range, listCnt);
       model.addAttribute("pagination",search);
       model.addAttribute("list", boardService.selectBoardList(search));
       
           
           return "/WEB-INF/views/boardList.jsp";
       }
	 
	 
//	 	@RequestMapping("board/list")
//	    public String boardList(@ModelAttribute("boardVO") BoardVO boardVO,
//	            @RequestParam(defaultValue="1") int curPage,
//	            HttpServletRequest request,
//	            Model model) throws Exception{
//	 
//	        // 전체리스트 개수
//	        int listCnt = boardService.selectBoardListCnt();
//	        Pagination pagination = new Pagination(listCnt, curPage);
//	        
//	        boardVO.setStartIndex(pagination.getStartIndex());
//	        boardVO.setCntPerPage(pagination.getPageSize());
//	        // 전체리스트 출력
//	        List<BoardVO> list = boardService.selectBoardList();
//	                
//	        model.addAttribute("list", list);
//	        model.addAttribute("listCnt", listCnt);
//	   //     model.addAttribute("loginVO", loginVO);
//	        
//	        model.addAttribute("pagination", pagination);
//	        
//	        return "/WEB-INF/views/boardList.jsp";
//	    }
//	    
	
}
