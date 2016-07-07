## 实验6 Spring jdbc模板应用


### 实验目的
	能用Spring jdbc模板完成对数据库操作的基本功能


### 实验内容

	DROP TABLE  IF EXISTS students;
	CREATE TABLE students(
	       sid INT PRIMARY KEY,
	       sname VARCHAR(20),
	       age INT,
	       birthday DATE,
	       school VARCHAR(30)
	);
	
	
	INSERT INTO students VALUES(1,'张三',24,'1988-10-29','哈理工');
	INSERT INTO students VALUES(2,'李四',28,'1984-4-19','哈工大');
	INSERT INTO students VALUES(3,'王五',27,'1985-3-4','黑龙江大学');
	INSERT INTO students VALUES(4,'赵六',22,'1990-11-22','哈理工');
	
	COMMIT;
	SELECT * FROM students;
	
	
	DELETE FROM students WHERE sid = 3;
	
	SELECT sid,sname,age,birthday,school FROM students;

	/*
	       任务：
	       使用spring框架的JdbcTemplate完成以下操作       
	       查询多条记录	(查所有)	
	       查询一条记录	()	
	       查询单值	(查学校)	
	       修改记录		
	       插入记录		
	       删除记录
	*/
