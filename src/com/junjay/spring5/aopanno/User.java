package com.junjay.spring5.aopanno;

import org.springframework.stereotype.Component;

/**
 * @author My
 *	被增强类
 */
@Component
public class User {

	public void add() {
		 int i = 10/0;
		System.out.println("user add ....");
	}
}
