package com.tb.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {
	@Test
	public void test() {
		
		//Spring 容器对象
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		Hello h=(Hello) ctx.getBean("hello");
		h.sayHello();
		ctx.close();
	}
}
