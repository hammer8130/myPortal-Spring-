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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.myportal.repositories.vo.BoardVO;
import himedia.myportal.repositories.vo.UserVO;
import himedia.myportal.services.BoardService;
import jakarta.servlet.http.HttpSession;

// 사용자 기반 서비스
// ( 시 나 리 오 )
// -목록은 로그인 상관 없이 접근 가능
// -조회, 작성, 수정은 로그인 해야 사용 가능
@RequestMapping("/board")
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping({ "", "/", "/list" })
	public String list(Model md) {
		List<BoardVO> list = boardService.getList();
		md.addAttribute("list", list);
		System.out.println(list);
		return "board/list";
	}

	@GetMapping("/{no}")
	// URL 패스로 의해 값을 가져온다 -> pathVariable
//	httpsession내부엔 authuser라는 객체를 담아놓게끔 해주었다.
//	로그인을 해야 조회, 작성, 수정가능하게끔 authuser
	public String view(@PathVariable("no") Long no, Model md, HttpSession session) {
//		System.out.println("전달받은 no값 : "+no);
//		UserVO authUser = (UserVO) session.getAttribute("authUser");
//		if (authUser == null) {
//			// 홈 화면으로 리다이렉트
//			return "redirect:/";
//		}
		BoardVO boardVo = boardService.getContent(no);
//		System.out.println("boardVo로 부터 전달받은 no값 : "+no);
		md.addAttribute("vo", boardVo);
		return "board/view";
	}

	// 작성 폼
	@GetMapping("/write")
	public String writeForm(HttpSession session, RedirectAttributes redirectAtt) {
		UserVO authUser = (UserVO) session.getAttribute("authUser");
//		if (authUser == null) {
//
//			redirectAtt.addFlashAttribute("errorMsg", "로그인 실패~");
//			return "redirect:/";
//		}
		return "board/write";
	}

	// 작성 액션
	@PostMapping("/write")
	public String writeAction(@ModelAttribute BoardVO boardVO, HttpSession session, RedirectAttributes redirectAtt) {
		UserVO authUser = (UserVO) session.getAttribute("authUser");
//		if (authUser == null) {
//			redirectAtt.addFlashAttribute("errorMsg", "로그인 실패~");
//			return "redirect:/";
//		}
//			인증된 사용자 메서드
		boardVO.setUserNo(authUser.getNo()); // 작성자 pk
		boardService.write(boardVO);

		return "redirect:/board";
	}

	// 편집 폼
	@GetMapping("/{no}/modify")
	public String modifyForm(@PathVariable("no") Long no, Model md, HttpSession session,
			RedirectAttributes redirectAtt) {
//		UserVO authUser = (UserVO) session.getAttribute("authUser");
//		if (authUser == null) {
//			redirectAtt.addFlashAttribute("errorMsg", "로그인 실패~");
//			return "redirect:/";
//		}
		BoardVO vo = boardService.getContent(no);
		md.addAttribute("vo", vo);
		return "board/modify";
	}

	// 편집 액션
	@PostMapping("/modify")
	public String modifyAction(@ModelAttribute BoardVO updatedVo, HttpSession session, RedirectAttributes redirectAtt) {
//		UserVO authUser = (UserVO) session.getAttribute("authUser");
//		if (authUser == null) {
//			redirectAtt.addFlashAttribute("errorMsg", "로그인 실패~");
//			return "redirect:/";
//		}
		// 기존 게시물 받아오기
		BoardVO vo = boardService.getContent(updatedVo.getNo());
//		새로 갱신될 게시물
		vo.setTitle(updatedVo.getTitle());
		vo.setContent(updatedVo.getContent());

		boolean success = boardService.update(vo);

		return "redirect:/board";
	}

	// 게시물 삭제
	@RequestMapping("/{no}/delete")
	public String deleteAction(@PathVariable("no") Long no, HttpSession session, RedirectAttributes redirectAtt) {
		UserVO authUser = (UserVO) session.getAttribute("authUser");
//		if (authUser == null) {
//			redirectAtt.addFlashAttribute("errorMsg", "로그인 실패~");
//			return "redirect:/";
//		}
		boardService.delete(no, authUser.getNo());
		return "redirect:/board";
	}
}
