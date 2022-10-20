package com.gm.home.aop.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class Card {
	
	@Before("execution(* com.gm.home.aop.test.Transeport.airPlane())")
	public void before() {
		log.info("----- Before -----");
	}
	@After("execution(* com.gm.home.aop.test.Transeport.get*())")
	public void after() {
		log.info("----- After -----");
	}
	
	
	@Around("execution(* com.gm.home.aop.test.Transeport.take*())")
	public Object CardCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("--- 탈거야? ---");
		Object obj = joinPoint.proceed();
		log.info("--- 내릴거야? ---");
		
		return obj;
	}
}
