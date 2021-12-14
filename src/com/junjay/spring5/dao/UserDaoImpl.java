package com.junjay.spring5.dao;

import org.springframework.stereotype.Repository;

/**
 * @author My
 *	implements 实现 UserDao 接口
 *	
 */
@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public int add(int a, int b) {
		System.out.println("UserDaoImpl 执行 add方法");
		return a+b;
	}

	@Override
	public String del(String id) {
		System.out.println("UserDaoImpl 执行 del方法");
		return id;
	}

}
