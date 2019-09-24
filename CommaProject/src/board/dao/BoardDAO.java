package board.dao;

import java.util.List;

import board.common.Search;
import board.vo.BoardVO;


public interface BoardDAO {

	public void insert(BoardVO board);
	public void update(BoardVO board);
	public void updateReplyCount(int boardId);
	public void delete(BoardVO board);
	public BoardVO selectOne(int boardId);
	public List<BoardVO> selectAll(Search search);//수정
	public BoardVO selectBoardLastOne();
	public void updateReplyCount(int boardId, int amount) throws Exception;
	public void updateViewCount(int boardId) throws Exception;
	public int selectBoardListCnt(Search search) throws Exception;//수정
		
}
