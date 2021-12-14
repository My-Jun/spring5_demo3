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
 * ��ǿUser��
 */
@Component
@Aspect //���ɴ������
@Order(1)
public class UserProxy {
	
	// ��ͬ������ȡ Point-�� cut-����
	@Pointcut(value = "execution(* com.junjay.spring5.aopanno.User.add(..))")
	public void pointdemo() {

	}
	
	/**
	 * ǰ��֪ͨ
	 */
	// @Beforeע���ʾ��Ϊ�ķ�����ǰ��֪ͨ
	// pointdemo �������Ѿ�����execution����㷽��ֱ��ʹ�þͿ���
	@Before(value = "pointdemo()")
	public void beforeAdvice() {
		System.err.println("UserProxy ----- @Beforeǰ��֪ͨ");
	}
	
	@AfterReturning(value = "execution(* com.junjay.spring5.aopanno.User.add(..))")
	public void afterReturning() {
		System.err.println("@AfterReturning����֪ͨ");
	}
	
	/**
	 * @throws Throwable 
	 * @Around ����֪ͨ����ִ��add��������֮ǰ��֮��ִ��
	 */
	@Around(value = "execution(* com.junjay.spring5.aopanno.User.add(..))")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.err.println("@Around����֮ǰ������");
		// ִ�б���ǿ�ķ���
		pjp.proceed();
		System.err.println("����֮�󡣡���");
	}
	
	@AfterThrowing(value = "execution(* com.junjay.spring5.aopanno.User.add(..))")
	public void afterThrowing() {
		System.err.println("@AfterThrowing�쳣֪ͨ");
	}
	
	@After(value = "execution(* com.junjay.spring5.aopanno.User.add(..))")
	public void after() {
		System.err.println("@After����֪ͨ");
	}
	
	

}
