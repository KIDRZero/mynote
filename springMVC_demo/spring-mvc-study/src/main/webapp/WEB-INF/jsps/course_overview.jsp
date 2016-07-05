<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		课程ID：${course.courseId}<br/>
		课程名称：${course.title}<br/>
		<img alt="" src="<%=request.getContextPath()%>/${course.imgPath}"><br/>
		学习人数：${course.learningNum }<br/>
		课程时长：${course.duration}<br/>
		课程难度：${course.level}<br/>
		课程难度描述：${course.levelDesc}<br/>
		课程介绍：${course.descr}<br/>
		课程提纲:<br>
		
	</div>
</body>
</html>