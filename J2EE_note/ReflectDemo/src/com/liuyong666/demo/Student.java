package com.liuyong666.demo;

public class Student {
	
	public int age;
	public static String department;
	private String name ;
	
	public Student() {
	}
	
	private Student(String name){
		this.name = name;
	}
	public Student(String name, int age){
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static String getDepartment() {
		return department;
	}

	public static void setDepartment(String department) {
		Student.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	private int add(int x, int y){
		return x + y;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}
	
	

	
	


}
