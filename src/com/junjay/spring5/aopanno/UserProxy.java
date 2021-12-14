package com.junjay.spring5.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author My
 * 增强User类
 */
@Component
@Aspect //生成代理对象
@Order(1)
public class UserProxy {
	
	// 相同切入点抽取 Point-点 cut-切入
	@Pointcut(value = "execution(* com.junjay.spring5.aopanno.User.add(..))")
	public void pointdemo() {

	}
	
	/**
	 * 前置通知
	 */
	// @Before注解表示作为改方法的前置通知
	// pointdemo 方法上已经有了execution切入点方法直接使用就可以
	@Before(value = "pointdemo()")
	public void beforeAdvice() {
		System.err.println("UserProxy ----- @Before前置通知");
	}
	
	@AfterReturning(value = "execution(* com.junjay.spring5.aopanno.User.add(..))")
	public void afterReturning() {
		System.err.println("@AfterReturning后置通知");
	}
	
	/**
	 * @throws Throwable 
	 * @Around 环绕通知，在执行add（）方法之前、之后都执行
	 */
	@Around(value = "execution(* com.junjay.spring5.aopanno.User.add(..))")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.err.println("@Around环绕之前。。。");
		// 执行被增强的方法
		pjp.proceed();
		System.err.println("环绕之后。。。");
	}
	
	@AfterThrowing(value = "execution(* com.junjay.spring5.aopanno.User.add(..))")
	public void afterThrowing() {
		System.err.println("@AfterThrowing异常通知");
	}
	
	@After(value = "execution(* com.junjay.spring5.aopanno.User.add(..))")
	public void after() {
		System.err.println("@After最终通知");
	}
	
	

}
