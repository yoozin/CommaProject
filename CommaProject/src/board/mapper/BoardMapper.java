package board.mapper;

import java.util.List;

import board.vo.BoardVO;

@Mymapper
public interface BoardMapper {
	
	public void insert(BoardVO board);
	public void update(BoardVO board);
	public void updateReplyCount(int boardId);
	public void delete(BoardVO board);
	public BoardVO selectOne(int boardId);
	public List<BoardVO> selectAll();
	public BoardVO selectBoardLastOne();
	

}
