## 实验1：java反射和增强for循环


### 实验目的
	1 掌握增强for循环和其他遍历数组和集合的方法；
	2 掌握 java反射原理和使用
	3 掌握class类、Constructor类、Field类、Method类使用


### 实验内容

	1建立下列数组和集合，并用两种以上的方法遍历数组和集合。
	//定义数组  "张三","李四","王五"
	//定义Set集合  HashSet<String>，数据："c"、"c++"、".nat"
	//定义List集合  LinkedList<String>，数据："java"、"jsp"、"javaEE"
	//定义Map集合 HashMap<String,String>，数据： "1","Oracle"、"2","mysql"、"3","db2"
	2 建立Student类，
	（1）属性 
		public int age;
		public static String department;
		private String name ;
	（2）方法：
	    成员变量所有的get和set方法（public）和private  int add(int x,int y)
	（3）构造方法：
		public Student()
		private Student(String name)
		public Student(String name, int age)
	3 输出Student类的类名、所有声明的属性、方法和构造方法
	4 应用反射方式，分别用Constructor对象构建3个Student类对象。
	5 应用反射方式，分别用Field对象获取Student类属性name 、age和department;，使用Field对象get和set方法对属性赋值和取值。
	6 应用反射方式，分别用Method对象获取getName() 方法、getName()方法、add()方法，并执行。
