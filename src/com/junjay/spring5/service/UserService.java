package com.junjay.spring5.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.junjay.spring5.dao.UserDao;

// ��ͬ����xml�����ļ������<bean id="userService" class="**.**.UserService"></bean>
// id��ֵ����@Component�е�value��ֵ��һ����
// ��ע������value����ֵ�����Բ�ʡ��д��Ĭ��ֵ�������ƣ�����ĸСд��eg��UserService =��userService
//@Component(value = "userService")
@Service
public class UserService {
	
	/**
	 * ��ͨ�������ԣ�ע��ֵ
	 */
	@Value(value = "adc")
	private String name;

	// ����dao��������
	// �Զ�ע������,����Ҫ�ڼ�set����
//	@Autowired // ��������ע�룬��һ���ӿڿ����ж��ʵ���࣬����ж������ʵ���࣬���Ҳ���Ҫע����һ��
//	@Qualifier(value = "userDaoImpl") // ���ʱ���Ҫ��@Qualifierͨ������ע�����ԣ�Ĭ��Ϊ����ĸСдuserDaoImpl
//	private UserDao userDao;
	
	// @Resource // ��������ע��
	@Resource(name = "userDaoImpl") // ��������ע��
	private UserDao userDao;

	public void add() {
		System.out.println("@Value��ͨ����ע��------------"+name);
		userDao.add(0, 0);
	}

}
