package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import board.common.Search;
import board.dao.BoardDAO;
import board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public BoardVO createBoard(BoardVO board) {
		boardDao.insert(board);
		return boardDao.selectBoardLastOne();
	}

	@Override
	public void deleteBoard(BoardVO board) {
		
		boardDao.delete(board);
	}

	@Override
	public BoardVO updateBoard(BoardVO board) {
		boardDao.update(board);
		BoardVO updatedBoard = boardDao.selectOne(board.getBoardId());
		return updatedBoard;
	}

	//¼öÁ¤
	@Override
	public List<BoardVO> selectBoardList(Search search){
		return boardDao.selectAll(search);
	}

	@Override
	public BoardVO selectOneBoard(int boardId) {
		return boardDao.selectOne(boardId);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardVO read(int boardId) throws Exception {
		boardDao.updateViewCount(boardId);
		return boardDao.selectOne(boardId);
	}
	
	@Override
	public int selectBoardListCnt(Search search) throws Exception {
		return boardDao.selectBoardListCnt(search);
	}
	
}
