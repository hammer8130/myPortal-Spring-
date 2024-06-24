package himedia.myportal.repositories.dao;

import himedia.myportal.repositories.vo.UserVO;

public interface UserDAO {
	public int insert(UserVO vo);
	public UserVO selectUser(String email); // 중복 이메일 체크
	public UserVO selectUser(String email, String password); // 로그인용
}
