package com.liuyong666.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TraverseTest {
	public static void main(String[] args) {
		//定义数组  "张三","李四","王五"
		//定义Set集合  HashSet<String>，数据："c"、"c++"、".net"
		//定义List集合  LinkedList<String>，数据："java"、"jsp"、"javaEE"
		//定义Map集合 HashMap<String,String>，数据： "1","Oracle"、"2","mysql"、"3","db2"

		System.out.println("String-------------------------------------");
		String[] persons = new String[]{"张三","李四","王五"};
		
		for(int i = 0; i < persons.length; i++){
			System.out.print(persons[i] + " : ");
		}
		System.out.println();
		
		System.out.println("-------------------------------------");
		for(String str : persons){
			System.out.print(str + " : ");
		}
		System.out.println();
		
		System.out.println("HashSet-------------------------------------");
		Set<String> coursesSet = new HashSet<String>();
		coursesSet.add("c");
		coursesSet.add("c++");
		coursesSet.add(".net");
		Iterator<String> it = coursesSet.iterator();
		while(it.hasNext()){
			String course = it.next();
			System.out.print(course + " : ");
		}
		System.out.println();
		
		System.out.println("LinkedList-------------------------------------");
		List<String> coursesList = new LinkedList<String>();
		coursesList.add("java");
		coursesList.add("jsp");
		coursesList.add("javaEE");
		for(String course : coursesList){
			System.out.print(course + " : ");
		}
		System.out.println();
		
		System.out.println("HashMap-------------------------------------");
		Map<String,String> coursesMap = new HashMap<String,String>();
		coursesMap.put("1","Oracle");
		coursesMap.put("2","mysql");
		coursesMap.put("3","db2");
		
		Set<String> ids = coursesMap.keySet();
		for(String id : ids){
			String course = coursesMap.get(id);
			System.out.print(id + ":" + course + " ; ");
		}
		System.out.println();
		System.out.println("-------------------------------------");
			
	}

}
