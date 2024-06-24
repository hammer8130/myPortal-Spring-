package himedia.myportal.services;

import himedia.myportal.repositories.vo.UserVO;

public interface UserService {
	
	public boolean join(UserVO vo); // 회원 가입
	public UserVO getUser(String email);  // 중복 가입 체크
	public UserVO getUser(String email, String password); // 로그인
}
