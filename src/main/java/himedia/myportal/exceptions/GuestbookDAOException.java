package himedia.myportal.exceptions;

import himedia.myportal.repositories.vo.GuestbookVO;

public class GuestbookDAOException extends RuntimeException{

	private static final long serialVersionUID = -1956357463472553763L;
	private GuestbookVO guestbookVO = null;
	
	public GuestbookDAOException() {
		
	}
	
	public GuestbookDAOException(String message) {
		super(message);

	}
	
	public GuestbookDAOException(String message, GuestbookVO vo) {
		super(message);
		this.guestbookVO=vo;
	}
	
//	Getters
	public GuestbookVO getGuestbookVO() {
		return guestbookVO;
	}

	
	
}
