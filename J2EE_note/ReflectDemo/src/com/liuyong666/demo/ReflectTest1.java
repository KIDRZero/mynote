package com.liuyong666.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * 应用反射方式，分别用Constructor对象构建3个Student类对象。
 * 
 * 应用反射方式，分别用Field对象获取Student类属性name 、age和department;，使用Field对象get和set方法对属性赋值和取值。
 * 
 * 应用反射方式，分别用Method对象获取getName() 方法、add()方法，并执行。
 * 
 * @author Administrator
 *
 */
public class ReflectTest1 {
	public static void main(String[] args) throws Exception{
		
		Class clazz = Student.class;
		
		//应用反射方式，分别用Constructor对象构建3个Student类对象。
		System.out.println("用Constructor对象构建Student类对象-------------------------------");
		Constructor constructor1 = clazz.getConstructor();
		Object stu1 = constructor1.newInstance();

		
		Constructor constructor2 = clazz.getDeclaredConstructor(String.class);
		constructor2.setAccessible(true);
		Object stu2 = constructor2.newInstance("liuyong");

		Constructor constructor3 = clazz.getConstructor(String.class, int.class);
		Object stu3 = constructor3.newInstance("liuyong", 22);
		
		System.out.println(stu1 + ":" + stu2 +  ":" + stu3);
		
		System.out.println();
		System.out.println("用Field对象获取Student类属性-------------------------------");
		Field age = clazz.getDeclaredField("age");
		Field department = clazz.getDeclaredField("department");
		Field name = clazz.getDeclaredField("name");
		name.setAccessible(true);
		System.out.println(age);
		System.out.println(department);
		System.out.println(name);
		
		//使用Field对象get和set方法对属性赋值和取值。
		age.setInt(stu1, 20);
		System.out.println("使用Field对象get对属性取值,stu1.age = " + age.getInt(stu1));
		System.out.println("使用Field对象get对属性取值,stu3.age = " + age.getInt(stu3) + ",stu3.name = " + name.get(stu3));
		
		
		System.out.println();
		//用Method对象获取getName() 方法、add()方法，并执行。
		System.out.println("用Method对象获取方法并执行-------------------------------");
		Method getNameMethod = clazz.getMethod("getName");
		String nameFromMethod = (String) getNameMethod.invoke(stu2);
		System.out.println("用Method对象获取getName() 方法,并执行,stu2.name = " + nameFromMethod);
		
		Method addMethod = clazz.getDeclaredMethod("add", int.class, int.class);
		addMethod.setAccessible(true);
		int resultFromMethod = (Integer) addMethod.invoke(stu2, 5, 7);
		System.out.println("用Method对象获取add() 方法,并执行,stu2.add() : " + resultFromMethod);
		

	}

}
