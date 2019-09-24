package board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import board.common.Search;
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

	//수정
	@Override
	public List<BoardVO> selectAll(Search search) {
		 
		return boardMapper.selectAll(search);
	}

	@Override
	public BoardVO selectBoardLastOne() {
		// TODO Auto-generated method stub
		return boardMapper.selectBoardLastOne();
	}
	
	@Override
	public void updateReplyCount(int boardId, int amount) throws Exception{
		
	}

	@Override
	public void updateViewCount(int boardId) throws Exception{
		boardMapper.updateViewCount(boardId);
	}
	
	//수정
	@Override
	public int selectBoardListCnt(Search search) throws Exception{
		return boardMapper.selectBoardListCnt(search);
	}
	
	
	
	
	
	
	
}
