package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	@Before("execution(* *..*.ProductService.find(..))")
	public void beforeAdvice() {
		System.out.println("---Before Advice---");
	}
	
	@After("execution(* *..*.ProductService.find(..))")
	public void afterAdvice() {
		System.out.println("---After Advice---");
	}
	
	@AfterReturning("execution(* *..*.ProductService.*(..))")
	public void afterReturningAdvice() {
		System.out.println("---After Returning Advice---");
	}
	
	@AfterThrowing(value="execution(* *..*.*.*(..))", throwing="ex")
	public void afterThrowingAdvice(Throwable ex) {
		System.out.println("---After Throwing Advice: " + ex + "---");
	}
	
	@Around("execution(* *..*.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		/* before */
		System.out.println("---@Around(Before) Advice---");
		
		// PointCut 메소드 실행
		Object result = pjp.proceed();
		
		/* after */
		System.out.println("---@Around(after) Advice---");
		
		return result;
	}
}
