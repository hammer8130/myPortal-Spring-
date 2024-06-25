package himedia.myportal.exceptions;

import himedia.myportal.repositories.vo.UserVO;

public class UserDAOException extends RuntimeException{

	private static final long serialVersionUID = -8257523486095525180L;
	private UserVO userVo = null;
	
	public UserDAOException() {
		
	}
	
	public UserDAOException(String message) {
		super(message);
	}
//	UserDAOException이 발생됐을 때 해당 정보를 담을 수 있게끔
	
	public UserDAOException(String message, UserVO userVo) {
		super(message);
		this.userVo=userVo;
	}

	public UserVO getUserVo() {
		return userVo;
	}
	
	public void setUserVo(UserVO userVo) {
		this.userVo=userVo;
	}
	
}
