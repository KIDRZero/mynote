package com.liuyong666.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 输出Student类的类名、所有声明的属性、方法和构造方法
 * @author Administrator
 *
 */
public class ReflectTest {
	public static void main(String[] args) throws ClassNotFoundException {
		
//		Class clazz = Student.class;
//		Class clazz = new Student().getClass();
		Class clazz = Class.forName("com.liuyong666.demo.Student");
		
		
		System.out.println("Field-------------------------------");
		Field[] fields = clazz.getDeclaredFields();
		for(int i=0;i<fields.length;i++){
			System.out.println(fields[i]);
		}
		
		
		System.out.println("Method-------------------------------");
		Method[] methods = clazz.getDeclaredMethods();
		for(int i=0;i<methods.length;i++){
			System.out.println(methods[i]);
		}
		
		System.out.println("Constructor-------------------------------");
		Constructor[] construtors = clazz.getDeclaredConstructors();
		for(int i=0;i<construtors.length;i++){
			System.out.println(construtors[i]);
		}
		
		System.out.println("Package-------------------------------");
		System.out.println(clazz.getPackage().getName());
		
		System.out.println("Superclass-------------------------------");
		System.out.println(clazz.getSuperclass());
		
		System.out.println("Interface-------------------------------");
		Class[] interfaces = clazz.getInterfaces();
		for(Class  inte: interfaces){
			System.out.println(inte);
		}
	}

}
