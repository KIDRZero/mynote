package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liuyong666.service.PersonService;

public class SpringAOPTest {
	
	
	@Test
	public void interceptorTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		PersonService personService = (PersonService) context.getBean("personService");
		personService.save("hhh");
		personService.getPersonName(111);
		personService.update("aaa", 111);
	}

}
