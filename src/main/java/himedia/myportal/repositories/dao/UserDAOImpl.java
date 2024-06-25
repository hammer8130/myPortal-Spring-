package himedia.myportal.repositories.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.UserDAOException;
import himedia.myportal.repositories.vo.UserVO;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(UserVO vo) {
		try {
			return sqlSession.insert("users.insert", vo);
		} catch (Exception e) {
			throw new UserDAOException("회원 가입 중 에러!", vo);
		}
	}

	@Override
	public UserVO selectUser(String email) {
		return null;
	}

	@Override
	public UserVO selectUser(String email, String password) {
		// mybatis parameterType="map" 으로 전달하기
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("email", email);
		userMap.put("password", password);

		UserVO userVo = sqlSession.selectOne("users.selectUserByEmailAndPassword", userMap);
		return userVo;
	}

}
