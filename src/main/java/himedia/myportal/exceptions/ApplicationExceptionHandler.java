package himedia.myportal.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 전역 예외 처리 컨트롤러
@ControllerAdvice // @Component의 하위 어노테이션
//					-> Component를 Scan해주었기 때문에 사용 가능
public class ApplicationExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	// 전역에서 runtimeexception이 발생되었을 때, 내부에서 처리가 되게끔 해줌.
	public String handleRuntimeException(RuntimeException e, Model md) {
//		1.로깅
		System.err.println("=======");
		System.err.println("ControllerAdvice에 의한 ErrorHandling");
		e.printStackTrace();
		
//		2. 시스템 오류 안내화면
		md.addAttribute("name", e.getClass().getSimpleName());
		md.addAttribute("message", e.getMessage());
		
		return "errors/exception";
	}
}
