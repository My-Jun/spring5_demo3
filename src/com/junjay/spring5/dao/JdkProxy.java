package com.junjay.spring5.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JdkProxy {

	public static void main(String[] args) {
		Class[] interfaces = { UserDao.class };
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		// �����ӿ�ʵ����Ĵ������
		UserDao newProxyInstance = (UserDao) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), interfaces,
				new UserProxy(userDaoImpl));
		// Proxy.newProxyInstance....��һ���൱���Ǵ����ӿ�ʵ�����Խӿ�������
		// UserDao userDaoImpl = new UserDaoImpl(); // ����UserDaoΪ��̬����Ľӿ�
		int add = newProxyInstance.add(3, 7);
		System.out.println("���ؽ����"+add);
	}

}

//��������������
/**
 * @author My �ڲ��ࣨ���д������ࣩ
 */
class UserProxy implements InvocationHandler {

	// �Ѵ����Ľӿ�ʵ���࣬���ݹ���
	private Object obj;

	// �вι��죬����Ϊ��Ҫ��������ʵ����
	public UserProxy(Object obj) {
		this.obj = obj;
	}

	// ��ǿ�߼�
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// ����֮ǰ
		System.err.println(method.getName() + "����ִ��ǰ��������" + " ���ݵĲ���=" + Arrays.toString(args));
		// ����ǿ�ķ���ִ��
		Object object = method.invoke(obj, args);
		// ����֮��
		System.err.println("����ִ�к�=" + obj);
		return object;
	}
}
