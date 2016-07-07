package service;

import java.util.List;

import domain.Student;

public interface StudentService {
	List<Student> findAll();
	
	Student findById(Integer sid);
	
	//查学校
	String findSchool(Integer sid);
	
	int update(Student stu);
	
	int save(Student stu);
	
	int delete(Integer sid);
}
