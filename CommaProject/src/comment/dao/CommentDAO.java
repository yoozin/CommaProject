package comment.dao;

import java.util.List;

import comment.vo.CommentVO;
import commons.Criteria;

public interface CommentDAO {
	public void insertComment(CommentVO comment);
	public void updateComment(CommentVO comment);
	public void deleteComment(int commentNo);
	public List<CommentVO> selectAll(int boardId);
	public CommentVO selectOne(int commentNo);
	public CommentVO selectLastOne();

	
	//페이징처리하기 메소드
	List<CommentVO> listPaging(int boardId, Criteria criteria);
	
	public int CountComment(int boardId) throws Exception;
	
	
	
}