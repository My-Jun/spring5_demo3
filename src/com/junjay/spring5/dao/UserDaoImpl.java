package com.junjay.spring5.dao;

import org.springframework.stereotype.Repository;

/**
 * @author My
 *	implements ʵ�� UserDao �ӿ�
 *	
 */
@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public int add(int a, int b) {
		System.out.println("UserDaoImpl ִ�� add����");
		return a+b;
	}

	@Override
	public String del(String id) {
		System.out.println("UserDaoImpl ִ�� del����");
		return id;
	}

}
