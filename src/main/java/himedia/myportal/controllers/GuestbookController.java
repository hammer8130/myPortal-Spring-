package himedia.myportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import himedia.myportal.repositories.vo.GuestbookVO;
import himedia.myportal.services.GuestbookService;


// requestMapping (상위 URL)
@RequestMapping("/guestbook")
@Controller
public class GuestbookController {
//		Service로 부터 데이터를 불러오자.
		@Autowired
		GuestbookService guestbookService;

//	@ResponseBody
	@RequestMapping({"","/","/list"})
	public String list(Model md) {
		List<GuestbookVO> list = guestbookService.getMessageList();
		md.addAttribute("list",list);
		return "guestbook/list"; // View 로 포워딩
//		return list.toString();
	}
	
	// /guestbook/write (POST)  ---> 방명록 기록
	@PostMapping("/write")
	public String write(@ModelAttribute GuestbookVO vo) {
		System.out.println("HTML Form:"+vo);
		boolean success = guestbookService.writeMessage(vo);
		System.out.println("Write Result:"+success);
//		Insert -> Redirect
		return "redirect:/guestbook";
	}
	
//	ex) /guestbook/delete/3 이라는 url 등록시, {no} path의 일부가 변수처럼
//	/guestbook/delete/{no} ---> 삭제 폼
	@GetMapping("/delete/{no}")
	public String delete(@PathVariable("no") Long no,Model md) {
		md.addAttribute("no",no);
		return "guestbook/deleteform";
	}
	
	// /guestbook/delete (POST)
	@PostMapping("/delete")
	public String delete(@ModelAttribute GuestbookVO vo) {
		boolean success = guestbookService.deleteMessage(vo);
		System.out.println("Delete Result:"+success);
		return "redirect:/guestbook";
	}
}
