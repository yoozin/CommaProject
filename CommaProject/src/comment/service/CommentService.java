package comment.service;

import java.util.List;

import comment.vo.CommentVO;
import commons.Criteria;

public interface CommentService {
	public void createComment(CommentVO comment);
	public void deleteComment(int commentNo);
	public void updateComment(CommentVO comment);
	public void selectOneComment(CommentVO comment);
	public List<CommentVO> commentList(int boardId);
	
	public List<CommentVO> getCommentPaging(int boardId, Criteria criteria);
	
	public int countComment(int boardId) throws Exception;
	
}
