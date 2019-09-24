package comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import comment.dao.CommentDAO;
import comment.vo.CommentVO;
import commons.Criteria;

@Service("commentService")
public class CommentServiceImpl implements CommentService{
	
	
	@Autowired
	private CommentDAO commentDao;
	
	@Override
	public void createComment(CommentVO comment) {
		commentDao.insertComment(comment);
		
		System.out.println("service"+comment);
	}


	@Override
	public void deleteComment(int commentNo) {
		commentDao.deleteComment(commentNo);
		
	}

	@Override
	@Transactional
	public List<CommentVO> commentList(int boardId) {
		return commentDao.selectAll(boardId);
	
	}

	@Override
	@Transactional
	public void updateComment(CommentVO comment) {
		commentDao.updateComment(comment);
		
	}
	
	@Override
	@Transactional
	public void selectOneComment(CommentVO comment ) {
		commentDao.selectOne(comment.getCommentNo());
	}


	@Override
	public List<CommentVO> getCommentPaging(int boardId, Criteria criteria) {
		return commentDao.listPaging(boardId, criteria);
		// TODO Auto-generated method stub
		
	}


	@Override
	public int countComment(int boardId) throws Exception {
		// TODO Auto-generated method stub
		return commentDao.CountComment(boardId);
	}
}
