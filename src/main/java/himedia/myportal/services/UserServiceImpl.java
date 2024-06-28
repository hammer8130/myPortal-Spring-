package himedia.myportal.services;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.repositories.dao.UserDAO;
import himedia.myportal.repositories.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public boolean join(UserVO vo) {
		int insertedCount =0;
//		controller부터 전달받은 insert 데이터
		insertedCount = userDAO.insert(vo);
		return insertedCount ==1;
	}

	@Override
	public UserVO getUser(String email) {
		UserVO userVo = userDAO.selectUser(email);
		System.out.println("Service UserVo: "+userVo);
		return userVo;
	}

	@Override
	public UserVO getUser(String email, String password) {
		UserVO userVo = userDAO.selectUser(email,password);
		return userVo;
	}

	@Override
	public boolean isAuthenticated(HttpServletRequest req) {
//		세션을 통해 사용자 인증 상태 체크 로직
		HttpSession session = req.getSession(false);
		
		if(session != null) { // 인증했을 가능성이 있다.
			UserVO authUser = (UserVO)session.getAttribute("authUser");
			return authUser != null;
		}
		return false;
	}

}
