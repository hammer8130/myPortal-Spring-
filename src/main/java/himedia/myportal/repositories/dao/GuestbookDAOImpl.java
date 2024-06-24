package himedia.myportal.repositories.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.GuestbookDAOException;
import himedia.myportal.repositories.vo.GuestbookVO;

@Repository("guestbookDAO")
public class GuestbookDAOImpl implements GuestbookDAO {
//	자동 연결. 외부에서 주입해준다.
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<GuestbookVO> selectAll() {
		List<GuestbookVO> list = sqlSession.selectList("guestbook.selectAll");
		return list;
	}

	@Override
	public int insert(GuestbookVO vo) {
		try {

			int insertedCount = sqlSession.insert("guestbook.insert", vo);
			return insertedCount;
//		}catch(PersistenceException e) {
		} catch (Exception e) {
			// DAO의 Exception은 구체적인 사용자 정의 예외로 전환하여서 throw
			throw new GuestbookDAOException("방명록 기록 중 예외 발생!");
		}

	}

	@Override
	public int delete(GuestbookVO vo) {
		try {
			return sqlSession.delete("guestbook.delete", vo);
		} catch (Exception e) {
			throw new GuestbookDAOException("방명록 삭제 중 예외 발생!", vo);
		}

	}

}
