package com.liuyong666.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.liuyong666.service.impl.PersonServiceBean;

public class JDKProxyFactory implements InvocationHandler {
	
	private Object targetObject;
	
	public Object createProxyInstance(Object targetObject){
		
		this.targetObject = targetObject;
		
		/*
		 * 1. this.targetObject.getClass().getClassLoader() --目标对象的类装载器
		 * 2. this.targetObject.getClass().getInterfaces()  --代理对象要实现的接口
		 * 3. this  --这个类实例本身
		 */
		
		
		return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(),
				this.targetObject.getClass().getInterfaces(), this);
	}


	/**
	 * 代理对象会执行这个方法
	 * @param proxy   代理对象
	 * @param method  被拦截到的方法
	 * @param args	  方法的输入参数
	 * @return 
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {//环绕通知
		PersonServiceBean bean = (PersonServiceBean) this.targetObject;
		Object result = null; 
		if(bean.getUser()!=null){
			//..... advice()-->前置通知
			try {
				result = method.invoke(targetObject, args);
				// afteradvice() -->后置通知
			} catch (RuntimeException e) {
				//exceptionadvice()--> 例外通知
			}finally{
				//finallyadvice(); -->最终通知
			}
		}
		return result;
	}
	
	

}
