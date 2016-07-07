package com.liuyong666.service.impl;

import com.liuyong666.service.PersonService;
/**
 * 业务需求：
 * 		1. 拦截所有业务方法
 * 		2. 判断用户是否有权限
 * 				如果用户为null，没有权限调用业务方法
 * 				如果用户不为null，则有权限调用
 * @author Administrator
 *
 */
public class PersonServiceBean implements PersonService{
	
	private String user = null;
	
	
	
	public String getUser() {
		return user;
	}

	public PersonServiceBean() {
		super();
	}

	public PersonServiceBean(String user){
		this.user = user;
	}


	public void save(String name) {
		System.out.println("我是save()方法！");

	}

	public void update(String name, Integer personid) {
		System.out.println("我是update()方法！");
	}

	public String getPersonName(Integer personid) {
		System.out.println("我是getPersonName()方法！");
		return "666";
	}

}
