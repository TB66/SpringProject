package com.tb.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/**
 * 切面类 @Pointcut切入点 +增强
 * @author tanben
 *
 */
@Aspect 
@Component
public class MyAspect {
	
	@Pointcut(("execution( * com.tb.spring.dao.MySqlDao.*(..))"))
	public void aspect1() {}
	
	@Before("aspect1()")
	public void before() {
		System.out.println("=====增强=======");
	}
	
	@After("execution( * com.tb.spring.HelloWorld.*(..))")
	public void after(JoinPoint jp) {
		System.out.println("===增强===");
	}
}
