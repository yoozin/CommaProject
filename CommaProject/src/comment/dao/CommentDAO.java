package comment.dao;

import java.util.List;

import comment.vo.CommentVO;

public interface CommentDAO {
	
	//댓글 조회
	public List<CommentVO> selectAll(int borderNo) throws Exception;
}