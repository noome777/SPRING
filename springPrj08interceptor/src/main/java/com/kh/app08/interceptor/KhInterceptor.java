package com.kh.app08.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//인터페이스로 만들기
//1. 클래스 상속
//2. 인터페이스 상속


//public class KhInterceptor extends HandlerInterceptorAdapter {
public class KhInterceptor implements HandlerInterceptor {

	//prehandle
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("==============================================");
		System.out.println("preHandle 메소드 호출됨");
		System.out.println("==============================================");
		
		return true;
//		return false; --> home이 출력이 안된다. 인터셉터가 가져가기 때문에
		
		
	}
	
	//posthandle
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("==============================================");
		System.out.println("postHandle 메소드 호출됨");
		System.out.println(handler);
		System.out.println(modelAndView);
		System.out.println("==============================================");
	}
	
	//afterCompletion
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
		System.out.println("afterCompletion 메소드 호출됨");
		System.out.println(ex);
	}
	
}
