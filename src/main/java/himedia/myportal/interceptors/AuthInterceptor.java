package himedia.myportal.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;


import himedia.myportal.services.UserService;
import himedia.myportal.services.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	@Override
	// 메서드 핸들러 작동 이전

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("AuthInterceptor: ");
//		사용자가 로그인 한 사용자입니까?
//		현재 applicaion이 가지고 있는 applicationcontext를 얻는다. -> userService Bean을 찾아야 된다.
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		UserService userService = context.getBean(UserServiceImpl.class);

//		세션정보에서 authuser를 확인한 다음 있으면 인증, 없으면 x
		if (userService.isAuthenticated(request)) {
			logger.debug("인증된 사용자!");
			return true; // 통과
		} else {
			logger.debug("인증되지 않은 사용자!");
//			login page로 redirect
			response.sendRedirect(request.getContextPath() + "/users/login");
			return false; // 뒤로 넘겨주지 않게끔
		}

	}

}
