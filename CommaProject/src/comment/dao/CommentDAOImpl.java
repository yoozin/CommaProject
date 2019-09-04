package comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comment.vo.CommentVO;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired 
	SqlSession sql;
	
	@Override
	public List<CommentVO> selectAll(int borderNo) throws Exception {
		return sql.selectList("commentMapper.selectAll", borderNo);
	}


}
