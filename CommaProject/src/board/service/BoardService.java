package board.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import board.vo.BoardVO;


public interface BoardService {
	public BoardVO createBoard(BoardVO board);
	public void deleteBoard(BoardVO board);
	public BoardVO updateBoard(BoardVO board);
	public BoardVO selectOneBoard(int boardId);
	public List<BoardVO> selectBoardList();
}
