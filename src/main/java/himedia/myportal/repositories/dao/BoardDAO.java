package himedia.myportal.repositories.dao;

import java.util.List;

import himedia.myportal.repositories.vo.BoardVO;

public interface BoardDAO {
	// 게시물 목록 출력
	public List<BoardVO> selectAll();
	public int insert(BoardVO boardVo);
	// 게시물 조회
	public BoardVO getcontent(Long no);
	public int update(BoardVO boardVo);
	public int increaseHitCount(Long no);
	// delete는 사용자 체크만 잘하자
	public int delete(Long no,Long userNo);
}
