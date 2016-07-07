import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service.StudentService;
import domain.Student;


public class Test {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx=new FileSystemXmlApplicationContext("src/beans.xml");
		//ctx.registerShutdownHook();
		
		StudentService s=(StudentService) ctx.getBean("studentService");
		
		System.out.println();
		System.out.println("findAll---------------------------");
		List<Student> list=s.findAll();
		for(Student stu : list){
			System.out.println(stu);
		}
		
		System.out.println();
		System.out.println("findById--------------------------");
		System.out.println(s.findById(2));
		
		System.out.println();
		System.out.println("findSchool(查询单值)----------------");
		System.out.println("sid为2的学校为：" + s.findSchool(2));
		
		
		System.out.println();
		System.out.println("update-----------------------------");
		Student stu = s.findById(2);
		System.out.println("修改前：" + stu);
		stu.setAge(82);
		stu.setBirthday(new Date());
		System.out.println(s.update(stu));
		System.out.println("修改后" + s.findById(2));
		
		System.out.println();
		System.out.println("insert-----------------------------");
		System.out.println("新增前表大小：" + s.findAll().size());
		Student new_stu = new Student();
		new_stu.setSid(666);
		new_stu.setSname("liuyong");
		new_stu.setAge(22);
		new_stu.setBirthday(new Date());
		new_stu.setSchool("东北林业大学");
		System.out.println(s.save(new_stu));
		System.out.println("新增后表大小：" + s.findAll().size());
		
		System.out.println();
		System.out.println("delete-----------------------------");
		System.out.println("删除前表大小：" + s.findAll().size());
		System.out.println(s.delete(666));
		System.out.println("删除后表大小：" + s.findAll().size());
		
	}
}
