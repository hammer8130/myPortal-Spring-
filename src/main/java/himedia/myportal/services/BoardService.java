package himedia.myportal.services;

import java.util.List;

import himedia.myportal.repositories.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> getList();
	// 게시물 조회용
	public BoardVO getContent(Long no);
	public boolean write(BoardVO boardVo);
	public boolean update(BoardVO boardVo);
	public boolean delete(Long no, Long userNo);
}
