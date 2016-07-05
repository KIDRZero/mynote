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
		course.setTitle("java���˼��");
		course.setImgPath("resources/imgs/course-img.jpg");
		course.setLearningNum(123455);
		course.setLevel(1);
		course.setLevelDesc("�м�");
		course.setDuration(7200l);
		course.setDescr("java�����");
		
		List<Chapter> chapterList = new ArrayList<Chapter>();
		for(int i = 1; i < 6; i++){
			Chapter ch = new Chapter();
			ch.setId(i);
			ch.setCourseId(courseId);
			ch.setOrder(i);
			ch.setCourseId(courseId);
			ch.setTitle("����Ŷ" + i);
			ch.setDescr("������ϸ����");
			chapterList.add(ch);
		}
		
		course.setChapterList(chapterList);
		return course;
	}

}
