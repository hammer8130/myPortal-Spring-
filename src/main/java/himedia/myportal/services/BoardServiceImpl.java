package himedia.myportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.repositories.dao.BoardDAO;
import himedia.myportal.repositories.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> getList() {
		List<BoardVO> list = boardDAO.selectAll();
		return list;
	}

	@Override
	public BoardVO getContent(Long no) {
		boardDAO.increaseHitCount(no);
//		pk를 전달
		BoardVO boardVO = boardDAO.getcontent(no);
		return boardVO;
	}

	@Override
	public boolean write(BoardVO boardVo) {
		int insertedCount = boardDAO.insert(boardVo);
		return insertedCount == 1;
	}

	@Override
	public boolean update(BoardVO boardVo) {
		int updatedCount = boardDAO.update(boardVo);
		return updatedCount == 1;
	}

	@Override
	public boolean delete(Long no, Long userNo) {
		int deletedCount = boardDAO.delete(no, userNo);
		return deletedCount == 1;
	}

}
