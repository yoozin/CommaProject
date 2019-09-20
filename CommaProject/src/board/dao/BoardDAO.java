package board.dao;

import java.util.List;

import board.vo.BoardVO;


public interface BoardDAO {

	public void insert(BoardVO board);
	public void update(BoardVO board);
	public void updateReplyCount(int boardId);
	public void delete(BoardVO board);
	public BoardVO selectOne(int boardId);
	public List<BoardVO> selectAll();
	public BoardVO selectBoardLastOne();
	public void updateReplyCount(int boardId, int amount) throws Exception;
	public void updateViewCount(int boardId) throws Exception;
	public int selectBoardListCnt();
		
}
