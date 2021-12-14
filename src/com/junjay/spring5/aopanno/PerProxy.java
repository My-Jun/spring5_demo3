package com.junjay.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect //生成代理对象
@Order(2)
public class PerProxy {
	
	/**
	 * 前置通知
	 */
	// @Before注解表示作为改方法的前置通知
	@Before(value = "execution(* com.junjay.spring5.aopanno.User.add(..))")
	public void beforeAdvice() {
		System.err.println("PerProxy -----  @Before前置通知");
	}

}
