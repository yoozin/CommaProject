package board.controller;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

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
	public String boardViewOne(Model model , BoardVO board) {
		board.setReplyCount(0);
		BoardVO boardOne = boardService.selectOneBoard(board.getBoardId());
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
		BoardVO updatedBoard = boardService.updateBoard(board);	
		System.out.println(board);
		return "forward:/board/viewOne";
	}
	

	@RequestMapping("board/delete")
	public String boardDeleter(Model model, BoardVO board) {
		System.out.println(board);
		boardService.deleteBoard(board);
		System.out.println("¼º°ø");
		return "redirect:/board/list";
	}
	
	 @RequestMapping("board/list")
	    public String boardList(Model model) throws Exception{
	        List<BoardVO> list = boardService.selectBoardList();
	        model.addAttribute("list", list);
	        
	        return "/WEB-INF/views/boardList.jsp";
	    }
	
}
