package comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comment.dao.CommentDAO;
import comment.vo.CommentVO;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentDAO dao;

	@Override
	public List<CommentVO> selectAll(int borderNo) throws Exception {
		return dao.selectAll(borderNo);
	}

}
