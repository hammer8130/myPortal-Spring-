package himedia.myportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import himedia.myportal.exceptions.MainControllerException;

@Controller
public class MainController {
//	@RequestMapping(value =  {"/","/main"}, method = RequestMethod.GET )
	@GetMapping({"/","/main"})
	public String mc() {

//		return "/WEB-INF/views/home.jsp";
		// prefix 와 suffix 설정.
		return "home";
	}
	
	@ResponseBody
	@GetMapping("/except")
	public String raiseExcept() {
//		RuntimeException -> 좀 더 구체적인 예외로 전환한 이후 throw 해주기!
//		특히 DAO는 어떤 작업을 수행하다 error가 뜨는지 모르기 떄문에, 구체적인 예외 전환 필
//		throw new RuntimeException("force Exception");
		throw new MainControllerException("메인 컨트롤러에서 예외가 발생했습니다!");
	}
	
//	@ExceptionHandler(RuntimeException.class)
//	@ResponseBody
//	public String handlerCtrlException(RuntimeException e) {
//		return "Exception: "+e.getMessage();
//	}
	
//	@ExceptionHandler(MainControllerException.class)
//	public String handleCtrlException(MainControllerException e,Model md) {
//		md.addAttribute("name", e.getClass().getName());
//		md.addAttribute("message",e.getMessage());
//		
//		return "errors/exception";
//	}
}
