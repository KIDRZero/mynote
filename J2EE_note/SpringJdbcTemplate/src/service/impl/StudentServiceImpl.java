package service.impl;

import java.util.List;

import dao.StudentDao;
import domain.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService{
	
	private StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public List<Student> findAll() {
		return studentDao.findAll();
	}

	public Student findById(Integer sid) {
		return studentDao.findById(sid);
	}

	public String findSchool(Integer sid) {
		return studentDao.findSchool(sid);
	}

	public int update(Student stu) {
		return studentDao.update(stu);
	}

	public int save(Student stu) {
		return studentDao.save(stu);
	}

	public int delete(Integer sid) {
		return studentDao.delete(sid);
	}

}
