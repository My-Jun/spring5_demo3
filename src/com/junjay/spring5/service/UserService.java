package com.junjay.spring5.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.junjay.spring5.dao.UserDao;

// 等同于在xml配置文件中添加<bean id="userService" class="**.**.UserService"></bean>
// id的值，与@Component中的value的值是一样的
// 在注解里面value属性值，可以不省略写。默认值是类名称，首字母小写；eg：UserService =》userService
//@Component(value = "userService")
@Service
public class UserService {
	
	/**
	 * 普通类型属性，注入值
	 */
	@Value(value = "adc")
	private String name;

	// 定义dao类型属性
	// 自动注入属性,不需要在加set方法
//	@Autowired // 根据类型注入，但一个接口可以有多个实现类，如果有多个类型实现类，就找不到要注入哪一个
//	@Qualifier(value = "userDaoImpl") // 这个时候就要用@Qualifier通过名称注入属性，默认为首字母小写userDaoImpl
//	private UserDao userDao;
	
	// @Resource // 根据类型注入
	@Resource(name = "userDaoImpl") // 根据名称注入
	private UserDao userDao;

	public void add() {
		System.out.println("@Value普通类型注入------------"+name);
		userDao.add(0, 0);
	}

}
