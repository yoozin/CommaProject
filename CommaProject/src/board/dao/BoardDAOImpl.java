package board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.mapper.BoardMapper;
import board.vo.BoardVO;

@Repository("boardDao")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private BoardMapper boardMapper; 
	
	@Override
	public void insert(BoardVO board) {
		
		boardMapper.insert(board);
	}

	@Override
	public void update(BoardVO board) {
		
		boardMapper.update(board);
	}

	@Override
	public void updateReplyCount(int boardId) {
		
		boardMapper.updateReplyCount(boardId);
	}

	@Override
	public void delete(BoardVO board) {
		boardMapper.delete(board);
		
	}

	@Override
	public BoardVO selectOne(int boardId) {
	
		return boardMapper.selectOne(boardId);
	}

	@Override
	public List<BoardVO> selectAll() {
		
		return boardMapper.selectAll();
	}

	@Override
	public BoardVO selectBoardLastOne() {
		// TODO Auto-generated method stub
		return boardMapper.selectBoardLastOne();
	}

}
