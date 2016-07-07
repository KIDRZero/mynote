package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dao.StudentDao;
import domain.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate temp;
	
	
	public JdbcTemplate getTemp() {
		return temp;
	}

	public void setTemp(JdbcTemplate temp) {
		this.temp = temp;
	}

	//匿名类
	RowMapper rowMapper = new RowMapper(){

		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			
			Student student = new Student();
			student.setSid(rs.getInt("sid"));
			student.setSname(rs.getString("sname"));			
			student.setAge(rs.getInt("age"));
			student.setBirthday(rs.getDate("birthday"));
			student.setSchool(rs.getString("school"));
			
			return student;
		}
		
	};
	
	@SuppressWarnings("unchecked")
	public List<Student> findAll() {
		String sql = "SELECT * FROM students";
		return (List<Student>)temp.query(sql, rowMapper);
	}

	@SuppressWarnings("unchecked")
	public Student findById(Integer sid) {
		String sql = "SELECT * FROM students where sid = ?";
		Object[] args = {sid};
		List<Student> list = (List<Student>)temp.query(sql, args, rowMapper);
		
		Student stu = null;
		if(list.size() > 0){
			stu = list.get(0);
		}
		return stu;
	}

	public String findSchool(Integer sid) {
		String sql = "SELECT school FROM students where sid = ?";
		return (String)temp.queryForObject(sql, new Object[]{sid}, String.class);
	}

	public int update(Student stu) {
		String sql = "update students set sname = ?,age = ?,birthday = ?,school = ? where sid = ? ";
		Object[] args = new Object[5];
		args[0] = stu.getSname();
		args[1] = stu.getAge();
		
		//	java.util.Date 到 java.sql.Date转换
		java.util.Date date = stu.getBirthday();
		long l = date.getTime();
		java.sql.Date sqlDate = new java.sql.Date(l);
		
		args[2] = sqlDate;
		args[3] = stu.getSchool();
		args[4] = stu.getSid();
		return temp.update(sql, args);
	}

	public int save(Student stu) {
		String sql = "insert into students values(?,?,?,?,?) ";
		
		Object[] args = new Object[5];
		args[0] = stu.getSid();
		args[1] = stu.getSname();
		args[2] = stu.getAge();
		
		//	java.util.Date 到 java.sql.Date转换
		java.util.Date date = stu.getBirthday();
		long l = date.getTime();
		java.sql.Date sqlDate = new java.sql.Date(l);
				
		
		args[3] = sqlDate;
		args[4] = stu.getSchool();
		return temp.update(sql, args);
	}

	public int delete(Integer sid) {
		String sql = "delete from students where sid = ?";
		return temp.update(sql, new Object[]{sid});
	}

}
