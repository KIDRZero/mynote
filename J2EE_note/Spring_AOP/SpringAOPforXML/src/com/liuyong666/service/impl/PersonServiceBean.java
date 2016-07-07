package com.liuyong666.service.impl;

import com.liuyong666.service.PersonService;

public class PersonServiceBean implements PersonService {
	


	public void save(String name) {
//		throw new RuntimeException("我是例外");
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
