package board.controller;

import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
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

import board.paging.Pagination;
import board.service.BoardService;
import board.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("board/index")
	public String index(Model model) {
	    
	    return "/index.jsp";
	}

	@RequestMapping("board")
	public String board(Model model) {
	    
	    return "//WEB-INF/views/boardWrite.jsp";
	}
	
	
	
	@RequestMapping("board/write")
	public String write(BoardVO board, Model model ) {
		board.setReplyCount(0);

		BoardVO createboard = boardService.createBoard(board);
		model.addAttribute("board", createboard);
		return "/WEB-INF/views/boardResult.jsp";
	}
	
	@RequestMapping("board/viewOne")
	public String boardViewOne(Model model , BoardVO board) throws Exception {
		board.setReplyCount(0);
		BoardVO boardOne = boardService.read(board.getBoardId());
		model.addAttribute("board", boardOne);
		return "/WEB-INF/views/boardResult.jsp";
	}
	
	@RequestMapping("board/modify")
	public String boardEditPre(Model model, BoardVO board) {
		model.addAttribute("board", board);
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
	
//	 @RequestMapping("board/list")
//	    public String boardList(Model model, ) throws Exception{
//	        List<BoardVO> list = boardService.selectBoardList();
//	        model.addAttribute("list", list);
//	        
//	        return "/WEB-INF/views/boardList.jsp";
//	    }
	 
	 
	 	@RequestMapping("board/list")
	    public String boardList(@ModelAttribute("boardVO") BoardVO boardVO,
	            @RequestParam(defaultValue="1") int curPage,
	            HttpServletRequest request,
	            Model model) throws Exception{
	 
	        // 전체리스트 개수
	        int listCnt = boardService.selectBoardListCnt();
	        Pagination pagination = new Pagination(listCnt, curPage);
	        
	        boardVO.setStartIndex(pagination.getStartIndex());
	        boardVO.setCntPerPage(pagination.getPageSize());
	        // 전체리스트 출력
	        List<BoardVO> list = boardService.selectBoardList();
	                
	        model.addAttribute("list", list);
	        model.addAttribute("listCnt", listCnt);
	   //     model.addAttribute("loginVO", loginVO);
	        
	        model.addAttribute("pagination", pagination);
	        
	        return "/WEB-INF/views/boardList.jsp";
	    }
	    
	
}
