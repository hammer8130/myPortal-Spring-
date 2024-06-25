package himedia.myportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.repositories.dao.UserDAO;
import himedia.myportal.repositories.vo.UserVO;

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
		return null;
	}

	@Override
	public UserVO getUser(String email, String password) {
		UserVO userVo = userDAO.selectUser(email,password);
		return userVo;
	}

}
