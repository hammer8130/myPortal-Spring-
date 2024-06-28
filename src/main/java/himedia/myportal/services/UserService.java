package himedia.myportal.services;



import himedia.myportal.repositories.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
	
	public boolean join(UserVO vo); // 회원 가입
	public UserVO getUser(String email);  // 중복 가입 체크
	public UserVO getUser(String email, String password); // 로그인
	
//	요청 정보에 해당 정보를 끄집어낸다음에 그 요청이 있는가 없는가 체크
	public boolean isAuthenticated(HttpServletRequest req); // 인증 체크 메서드
}
