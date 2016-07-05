package com.liuyong666.mvcdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.liuyong666.mvcdemo.model.Chapter;
import com.liuyong666.mvcdemo.model.Course;
import com.liuyong666.mvcdemo.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService{

	public Course getCourseById(Integer courseId) {
		
		Course course = new Course();
		
		course.setCourseId(courseId);
		course.setTitle("java编程思想");
		course.setImgPath("resources/imgs/course-img.jpg");
		course.setLearningNum(123455);
		course.setLevel(1);
		course.setLevelDesc("中级");
		course.setDuration(7200l);
		course.setDescr("java界好书");
		
		List<Chapter> chapterList = new ArrayList<Chapter>();
		for(int i = 1; i < 6; i++){
			Chapter ch = new Chapter();
			ch.setId(i);
			ch.setCourseId(courseId);
			ch.setOrder(i);
			ch.setCourseId(courseId);
			ch.setTitle("标题哦" + i);
			ch.setDescr("这是详细描述");
			chapterList.add(ch);
		}
		
		course.setChapterList(chapterList);
		return course;
	}

}
