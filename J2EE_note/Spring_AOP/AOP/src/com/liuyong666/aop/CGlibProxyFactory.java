package com.liuyong666.aop;

import java.lang.reflect.Method;

import com.liuyong666.service.impl.PersonServiceBean;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGlibProxyFactory implements MethodInterceptor {

	private Object targetObjeact;//代理的目标对象
	
	public Object createProxyInstance(Object targetObjeact){
		
		this.targetObjeact = targetObjeact;
		
		Enhancer enhancer = new Enhancer();//该类用于生成代理对象
		enhancer.setSuperclass(this.targetObjeact.getClass());//非final
		enhancer.setCallback(this);//设置回调对象为本身
		return enhancer.create();//创建代理对象
	}

	/**
	 * 当代理对象的业务方法被调用的时候，会回调这个方法
	 * @param proxy   代理对象
	 * @param method  被拦截到的方法
	 * @param args	  方法的输入参数
	 * @param methodProxy  方法的代理对象
	 * @return 
	 * @throws Throwable
	 */
	@Override 
	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {

		PersonServiceBean bean = (PersonServiceBean) this.targetObjeact;
		Object  result = null;
		if(bean.getUser() != null){
			result = methodProxy.invoke(targetObjeact, args);//把方法的调用委派给目标对象
		}
		
		
		return result;
	}
	
	

}
