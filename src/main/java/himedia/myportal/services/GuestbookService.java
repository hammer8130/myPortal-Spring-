package himedia.myportal.services;

import java.util.List;

import himedia.myportal.repositories.vo.GuestbookVO;

public interface GuestbookService {
//	DAO는 쿼리와 영향받은 레코드수가 중요하지만,
//	Service는 메서드의 성공여부가 더 중요하기 때문에 아래와 같이 설정
	public List<GuestbookVO> getMessageList();
	public boolean writeMessage(GuestbookVO vo);
	public boolean deleteMessage(GuestbookVO vo);
}
