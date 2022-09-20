package com.kh.app10;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice(basePackages = "com.kh.app10")
@ControllerAdvice(annotations = KhAno.class)
public class MyControllerAdvisor {

	@ExceptionHandler(Exception.class)
	public String m01(Exception e, HttpServletRequest req) {
		System.out.println("예외 발생");
		return "error/e404";
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public String m02(Exception e) {
		System.out.println("나누기 0 하지 마세요...");
		return "error/ae";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String m03(Exception e) {
		System.out.println("숫자를 가지고 파싱하세요...");
		return "error/nfe";
	}
}
