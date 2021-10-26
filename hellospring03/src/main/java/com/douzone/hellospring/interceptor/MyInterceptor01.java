package com.douzone.hellospring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor01 implements HandlerInterceptor {

	// Interceptor를 구현하는 방법은 2가지가 있는데, HandlerInterceptor 인터페이스를 구현하는 방법과
	// HandlerInterceptorAdapter 클래스를 상속 받는 방법이 있습니다.

	// Controller로 보내기 전에 가로채서 처리하는 인터셉터
	// 반환이 false라면, controller로 요청을 안함.
	// 매개변수 Object는 핸들러 정보를 의미한다.

	// preHandle() 메서드는 컨트롤러가 실행되기 전에 호출됨
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("MyInterceptor01.preHandle(...) called");
		return false;
	}

	// postHandle() 메서드는 컨트롤러가 실행된 후에 호출됨
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("MyInterceptor01.postHandle(...) called");

	}

	// afterComplete() 은 뷰에서 최종 결과가 생성하는 일을 포함한 모든 일이 완료 되었을 때 실행
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MyInterceptor01.afterCompletion(...) called");

	}

}
