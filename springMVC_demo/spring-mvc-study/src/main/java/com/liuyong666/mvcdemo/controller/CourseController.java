package com.liuyong666.mvcdemo.controller;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.liuyong666.mvcdemo.model.Course;
import com.liuyong666.mvcdemo.service.CourseService;

@Controller
@RequestMapping("/courses")
//  /courses/**
public class CourseController {
	
	private static Logger log = LoggerFactory.getLogger(CourseController.class);
	
	private CourseService courseService;

	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	//    本方法处理  /courses/view?courseId=123
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewCourse(@RequestParam("courseId") Integer courseId, Model model){
		log.info("In viewCourse,courseId = {}", courseId);
		
		Course course = courseService.getCourseById(courseId);
		model.addAttribute(course);
		return "course_overview";
	}
	
	//restful风格URL
	// /courses/view2/{courseId}
	@RequestMapping(value = "/view2/{courseId}", method = RequestMethod.GET)
	public String viewCourse2(@PathVariable("courseId") Integer courseId, Map<String, Object> model){
		log.info("In viewCourse2,courseId = {}", courseId);
		
		Course course = courseService.getCourseById(courseId);
		model.put("course", course);
		return "course_overview";
	}

	//传统方式，HttpServletRequest
	//  本方法处理  /courses/view?courseId=123
	@RequestMapping(value = "/view3", method = RequestMethod.GET)
	public String viewCourse3(HttpServletRequest request){
		
		Integer courseId = Integer.valueOf(request.getParameter("courseId"));
		
		log.info("In viewCourse3,courseId = {}", courseId);
		Course course = courseService.getCourseById(courseId);
		request.setAttribute("course", course);
		
		return "course_overview";
	}
	
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET, params = "add")
	public String createCourse(){
		
		return "course_admin/edit";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)	
	public String doSave(@ModelAttribute Course course){
		
		log.info("Info of Course:");
		log.info(ReflectionToStringBuilder.toString(course));
		
		//在此进行业务操作，比如数据库持久化
		course.setCourseId(666);
		return "redirect:view2/" + course.getCourseId();
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String showUploadPage(){
		return "course_admin/file";
	}
	
	//上传文件
	@RequestMapping(value = "/doUpload" ,method = RequestMethod.POST)
	public String doUpload(@RequestParam("file") MultipartFile file) throws Exception{

		if(!file.isEmpty()){
			log.info("Process file: {}",file.getOriginalFilename());
			
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("c:\\temp\\spring-mvc-test", System.currentTimeMillis() + file.getOriginalFilename()));
		}
		
		return "success";
	}
	
	//返回JSON数据，@ResponseBody方式
	@RequestMapping(value = "/json1/{courseId}", method = RequestMethod.GET)
	public @ResponseBody Course getCourseInJson(@PathVariable Integer courseId){
		return courseService.getCourseById(courseId);
	}
	
	//返回JSON数据，ResponseEntity方式
	@RequestMapping(value = "/json2/{courseId}", method = RequestMethod.GET)
	public ResponseEntity<Course> getCourseInJson2(@PathVariable Integer courseId){
		Course course = courseService.getCourseById(courseId);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	
	
}
