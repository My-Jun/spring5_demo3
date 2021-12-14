package com.junjay.spring5.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JdkProxy {

	public static void main(String[] args) {
		Class[] interfaces = { UserDao.class };
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		// 创建接口实现类的代理对象
		UserDao newProxyInstance = (UserDao) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), interfaces,
				new UserProxy(userDaoImpl));
		// Proxy.newProxyInstance....这一步相当于是创建接口实现类以接口做接收
		// UserDao userDaoImpl = new UserDaoImpl(); // 但改UserDao为动态代理的接口
		int add = newProxyInstance.add(3, 7);
		System.out.println("返回结果："+add);
	}

}

//创建代理对象代码
/**
 * @author My 内部类（类中创建新类）
 */
class UserProxy implements InvocationHandler {

	// 把创建的接口实现类，传递过来
	private Object obj;

	// 有参构造，参数为需要代理对象的实现类
	public UserProxy(Object obj) {
		this.obj = obj;
	}

	// 增强逻辑
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 方法之前
		System.err.println(method.getName() + "方法执行前。。。。" + " 传递的参数=" + Arrays.toString(args));
		// 被增强的方法执行
		Object object = method.invoke(obj, args);
		// 方法之后
		System.err.println("方法执行后=" + obj);
		return object;
	}
}
