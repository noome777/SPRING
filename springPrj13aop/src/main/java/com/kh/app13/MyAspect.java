package com.kh.app13;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Component
@Aspect
public class MyAspect {
	
	/*
	 * 	before 				: 타겟이 실행되기 전
	 *  after 				: 타겟이 실행된 후 (예외 상관 X)
	 *  afterReturning 		: 타켓이 실행된 후 (예외가 없을때만)
	 *  afterThrowing 		: 타겟이 실행된 후 (예외가 있을때만)
	 *  around 				: 전후 전부다 //메소드 형태 지정 (리턴타입, 파라미터, 예외)
	 */
	
	

//	@Before("target(com.kh.app13.member.service.MemberServiceImpl)")
//	@After("target(com.kh.app13.member.service.MemberServiceImpl)")
//	@AfterReturning("target(com.kh.app13.member.service.MemberServiceImpl)")
	@Around("target(com.kh.app13.member.service.MemberServiceImpl)")
	public Object myAdvice(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("충고 할게요 ~~~");
		System.out.println(jp.getSignature().toLongString());
		System.out.println(jp.getSignature().toShortString());
		System.out.println(jp.getSignature().toString());
		Object result = jp.proceed();
		System.out.println("충고 했어요 ~~~");
		return result;
	}
	
}
