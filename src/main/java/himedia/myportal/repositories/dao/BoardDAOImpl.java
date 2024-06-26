package himedia.myportal.repositories.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.BoardDAOException;
import himedia.myportal.repositories.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVO> selectAll() {
		
		List<BoardVO> list = sqlSession.selectList("board.selectAll");
		return list;
	}

	@Override
	public int insert(BoardVO boardVo) {
//		게시물 작성 메서드
		try {
			int insertedCount=sqlSession.insert("board.insert",boardVo);
			return insertedCount;
		}catch(Exception e) {
			e.printStackTrace();
			throw new BoardDAOException("게시글 등록중 예외 발생!",boardVo);
		}
	}

	@Override
	public BoardVO getcontent(Long no) {
		BoardVO boardVO = sqlSession.selectOne("board.getContent",no);
		return boardVO;
	}

	@Override
	public int update(BoardVO boardVo) {
		try {
			int updateCount = sqlSession.update("board.update",boardVo);
			return updateCount;
		}catch(Exception e) {
			e.printStackTrace();
			throw new BoardDAOException("게시글 update중 예외 발생!",boardVo);
		}
	}

	@Override
	public int increaseHitCount(Long no) {
//		조회 수 증가
		return sqlSession.update("increaseHitCount",no);
	}

	@Override
	public int delete(Long no, Long userNo) {
		try {
			Map<String, Long> map = new HashMap<String, Long>();
			map.put("no", no);
			map.put("userNo", userNo);
			return sqlSession.delete("board.delete",map);
		}catch(Exception e) {
			e.printStackTrace();
			throw new BoardDAOException("게시글 삭제중 예외 발생!");
		}
	}

}
