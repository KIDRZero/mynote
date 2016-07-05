<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="<%=request.getContextPath()%>/courses/save" method="post">
		课程名称：<input type="text" name="title"/><br/>
		学习人数：<input type="text" name="learningNum"/><br/>
		课程时长：<input type="text" name="duration"/><br/>
		课程难度：<select name="level">
					<option value="0">初级</option>
					<option value="1">中级</option>
					<option value="2">高级</option>
				</select> <br/>
		课程难度描述：<textarea  name="levelDesc"></textarea><br/>
		课程介绍：<input type="text" name="descr"/><br/>
		<input type="submit" value="提交"/><br/>			
		</form>
		
	</div>
</body>
</html>