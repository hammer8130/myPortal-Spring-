package himedia.myportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.repositories.dao.GuestbookDAO;
import himedia.myportal.repositories.vo.GuestbookVO;

@Service("guestbookService")
public class GuestbookServiceImpl implements GuestbookService{
	@Autowired
//	연결하고자 하는 bean까지.
	GuestbookDAO guestbookDAO;
	
	@Override
	public List<GuestbookVO> getMessageList() {
		List<GuestbookVO> list = guestbookDAO.selectAll();
		return list;
	}

	@Override
	public boolean writeMessage(GuestbookVO vo) {
		int insertedCount = guestbookDAO.insert(vo);
		return insertedCount == 1;
	}

	@Override
	public boolean deleteMessage(GuestbookVO vo) {
		return guestbookDAO.delete(vo) == 1;
	}

}
