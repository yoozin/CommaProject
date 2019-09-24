package comment.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comment.mapper.CommentMapper;
import comment.vo.CommentVO;
import commons.Criteria;

@Repository("commentDao")
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public void insertComment(CommentVO comment) {
		commentMapper.insertComment(comment);
		
	}

	@Override
	public void updateComment(CommentVO comment) {
		commentMapper.updateComment(comment);
		
	}

	@Override
	public void deleteComment(int commentNo) {
		commentMapper.deleteComment(commentNo);		
	}

	

	@Override
	public CommentVO selectOne(int commentNo) {
		return commentMapper.selectOne(commentNo);
	}

	@Override
	public CommentVO selectLastOne() {
		return commentMapper.selectLastOne();
	}


	@Override
	public List<CommentVO> selectAll(int boardId) {
		return commentMapper.selectAll(boardId);
	}

	//페이징처리 메소드	
	@Override
	public List<CommentVO> listPaging(int boardId, Criteria criteria) {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("boardId",boardId);
		paramMap.put("criteria",criteria);
		
		return commentMapper.selectAll(boardId);
	}

	@Override
	public int CountComment(int boardId) throws Exception {
		// TODO Auto-generated method stub
		return commentMapper.selectCount(boardId);
	}

	
}
