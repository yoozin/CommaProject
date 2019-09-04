package comment.service;

import java.util.List;

import comment.vo.CommentVO;

public interface CommentService {
	public List<CommentVO> selectAll(int borderNo) throws Exception;
}
