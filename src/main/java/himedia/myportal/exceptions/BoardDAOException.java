package himedia.myportal.exceptions;

import himedia.myportal.repositories.vo.BoardVO;

public class BoardDAOException extends RuntimeException {

	private static final long serialVersionUID = 9165217283197053660L;

	private BoardVO boardVo = null;

//	기본 생성자
	public BoardDAOException() {

	}

//	에러 메시지를 포함한 생성자
	public BoardDAOException(String message) {
		super(message);
	}

//	+boardVo의 정보까지 포함한 생성자
	public BoardDAOException(String message, BoardVO boardVo) {
		super(message);
		this.boardVo = boardVo;
	}

	public BoardVO getBoardVo() {
		return boardVo;
	}

	public void setBoardVo(BoardVO boardVo) {
		this.boardVo = boardVo;
	}

}
