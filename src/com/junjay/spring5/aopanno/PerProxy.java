package com.junjay.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect //���ɴ������
@Order(2)
public class PerProxy {
	
	/**
	 * ǰ��֪ͨ
	 */
	// @Beforeע���ʾ��Ϊ�ķ�����ǰ��֪ͨ
	@Before(value = "execution(* com.junjay.spring5.aopanno.User.add(..))")
	public void beforeAdvice() {
		System.err.println("PerProxy -----  @Beforeǰ��֪ͨ");
	}

}
