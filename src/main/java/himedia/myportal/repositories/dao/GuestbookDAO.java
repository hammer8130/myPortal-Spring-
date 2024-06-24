package himedia.myportal.repositories.dao;

import java.util.List;

import himedia.myportal.repositories.vo.GuestbookVO;

public interface GuestbookDAO {
	public List<GuestbookVO> selectAll(); 
	public int insert(GuestbookVO vo);
	public int delete(GuestbookVO vo);
	
}
