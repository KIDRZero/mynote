package junit.test;

import org.junit.Test;

import com.liuyong666.aop.CGlibProxyFactory;
import com.liuyong666.aop.JDKProxyFactory;
import com.liuyong666.service.PersonService;
import com.liuyong666.service.impl.PersonServiceBean;

public class AOPTest {
	
	
	@Test
	public void proxyTest(){
		JDKProxyFactory factory = new JDKProxyFactory();
		PersonService service = (PersonService) factory.createProxyInstance(new PersonServiceBean("XXX"));
		service.save("666");
	}
	
	@Test
	public void proxyTestByCGlib(){
		CGlibProxyFactory factory = new CGlibProxyFactory();
		PersonServiceBean service = (PersonServiceBean) factory.createProxyInstance(new PersonServiceBean("xxx"));
		service.save("6666");
	}

}
