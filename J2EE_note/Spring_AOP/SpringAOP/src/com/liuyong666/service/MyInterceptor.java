package com.liuyong666.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/**
 * 切面
 */
@Aspect
public class MyInterceptor {

	//Spring只支持方法的拦截
	
	/*
	 * 
	 * 这句话是方法切入点，
	 * 			execution为执行的意思，
	 * 			*代表任意返回值，
	 * 			然后是包名，.*意思是包下面的所有子包。
	 * 			(..)代表各种方法.
	 */
	
	@Pointcut("execution (* com.liuyong666.service.impl.PersonServiceBean.*(..))")
	private void anyMethod(){}//声明一个切入点
	
	@Before("anyMethod() && args(name)")
	public void doAccessCheck(String name){
		System.out.println("前置通知:" + name);
	}
	
	@AfterReturning(pointcut="anyMethod()",returning="result")
	public void doAfterReturning(String result){
		System.out.println("后置通知:" + result);
	}
	
	@AfterThrowing(pointcut="anyMethod()",throwing="e")
	public void doAfterThrowing(Exception e){
		System.out.println("例外通知:" + e);
	}
	
	@After("anyMethod()")
	public void doAfter(){
		System.out.println("最终通知");
	}
	
	@Around("anyMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		//if(){//判断用户是否在权限
		System.out.println("进入方法");
		Object result = pjp.proceed();
		System.out.println("退出方法");
		//}
		return result;
	}
}
