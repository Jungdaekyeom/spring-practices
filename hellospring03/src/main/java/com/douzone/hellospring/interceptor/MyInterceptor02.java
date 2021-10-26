package com.douzone.hellospring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor02 extends HandlerInterceptorAdapter {

	// Interceptor를 구현하는 방법은 2가지가 있는데, HandlerInterceptor 인터페이스를 구현하는 방법과
	// HandlerInterceptorAdapter 클래스를 상속 받는 방법이 있습니다.

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("MyInterceptor02.preHandle(...) called");
		return true;
	}

}
