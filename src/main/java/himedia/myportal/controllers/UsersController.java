package himedia.myportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.myportal.repositories.vo.UserVO;
import himedia.myportal.services.UserService;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/users")
@Controller
public class UsersController {
	@Autowired
	private UserService userService;

	// 가입 폼
	@GetMapping({ "", "/", "/join" })
	public String join() {
		return "users/joinform";
	}

//	가입 처리(액션)
	@PostMapping("/join")
	public String join(@ModelAttribute UserVO userVo) {
		System.out.println("회원 가입 폼: " + userVo);
		
		boolean success = userService.join(userVo);
		if (success) { //	가입 성공
			//	가입 성공 페이지로 리다이렉트
			System.out.println("회원 가입 성공");
			return "redirect:/users/joinsuccess";
		} else {
			//	다시 가입 폼으로
			System.err.println("회원 가입 실패");
			return "redirect:/users/join";
		}
	}

	// 가입 성공 페이지
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "users/joinsuccess";
	}

	// 로그인 폼 페이지
	@GetMapping("/login")
	public String loginForm() {
		return "users/loginform";
	}

	// 로그인 액션
	@PostMapping("/login")
	public String loginAction(@RequestParam(value = "email", required = false, defaultValue = "") String email,
			@RequestParam(value = "password", required = false, defaultValue = "") String password,HttpSession session) {
//		requestParam으로 부터 가져온 값을 각 변수에 할당했다.
		System.out.println("email:" + email);
		System.out.println("password:" + password);

		if (email.length() == 0 || password.length() == 0) {
			System.out.println("email 혹은 password를 입력하십시오.");
			return "redirect:/users/login";
		}
		
//		email과 password를 이용해서 사용자정보 질의
		UserVO authUser = userService.getUser(email,password);
		if(authUser !=null) {
//			로그인 처리
//			세션정보에다 정보를 담아둔다. session정보를 요청하라.
			session.setAttribute("authUser", authUser);
//			홈페이지로 이동
			return "redirect:/";
		}else {
			return "redirect:/users/login";
		}
	}
	
	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}
	
}
