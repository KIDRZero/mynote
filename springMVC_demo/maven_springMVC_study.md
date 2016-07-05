
### 生成Web项目

>mvn archetype:generate -DgroupId=com.liuyong666 -DartifactId=spring-mvc-study -Darchet
maven-archetype-webapp

![maven ](http://i.imgur.com/5QnnFSQ.png)

### maven生成的web项目中的web.xml默认忽略el表达式

> 更改头部为以下内容


	<?xml version="1.0" encoding="UTF-8"?>  
	<web-app version="2.5"   
	    xmlns="http://java.sun.com/xml/ns/javaee"   
	    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"   
	    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee   
	    http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">  

### hello springMVC成功

![hello springMVC](http://i.imgur.com/YCcWitd.png)



### cvc-complex-type.2.3: 元素 'beans' 必须不含字符 [子级], 因为该类型的内容类型为“仅元素”

>nested exception is org.xml.sax.SAXParseException; lineNumber: 29; columnNumber: 7; cvc-complex-type.2.3: 元素 'beans' 必须不含字符 [子级], 因为该类型的内容类型为“仅元素。

- 系统启动时，出现配置文件spring-mvc-servlet.xml解析异常。原因是，
文件里含有特殊字符，比如标签里出现了中文空格，重新另存UTF-8，把注释之外的多余内容删除即可。

### springMVC结构

![结构](http://i.imgur.com/62wJph4.jpg)

### springMVC流程图

![流程](http://i.imgur.com/QPGRUA3.jpg)

### springMVC细节

![细节](http://i.imgur.com/PP0pmaG.jpg)