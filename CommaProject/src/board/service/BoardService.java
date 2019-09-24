package board.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import board.common.Search;
import board.vo.BoardVO;


public interface BoardService {
	public BoardVO createBoard(BoardVO board);
	public void deleteBoard(BoardVO board);
	public BoardVO updateBoard(BoardVO board);
	public BoardVO selectOneBoard(int boardId);
	public List<BoardVO> selectBoardList(Search search);//수정
	public BoardVO read(int boardId) throws Exception;
	public int selectBoardListCnt(Search search) throws Exception;//수정

}
