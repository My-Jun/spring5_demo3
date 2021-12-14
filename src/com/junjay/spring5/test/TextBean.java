package com.junjay.spring5.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.junjay.spring5.aopanno.User;
import com.junjay.spring5.aopxml.Book;
import com.junjay.spring5.config.SpringConfig;
import com.junjay.spring5.service.UserService;

public class TextBean {

	@Test
	public void testUserService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		UserService userService = context.getBean("userService", UserService.class);
		System.out.println("对象："+userService);
		userService.add();
	}
	
	@Test
	public void testConfig() {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		UserService userService = context.getBean("userService", UserService.class);
		userService.add();
	}
	
	@Test
	public void testAopAnno() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		// 获取被增强的类，并调用被增强的方法
		User user = context.getBean("user", User.class);
		user.add();
	}
	
	@Test
	public void testBook() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
		// 获取被增强的类，并调用被增强的方法
		Book book = context.getBean("book", Book.class);
		book.buy();
	}

}
