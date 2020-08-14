package com.tb.spring;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tb.spring.bean.Person;

public class HTest {
	ClassPathXmlApplicationContext ctx;

	// @Before方法执行前 执行
	@Before
	public void before() {
		ctx = new ClassPathXmlApplicationContext("beans2.xml");
	}

	// @After方法执行结束 执行
	@After
	public void after() {
		ctx.close();
	}
	/**
	 * 懒加载
	 */
	@Test
	public void test() {
		System.out.println("==============test======");
		Hello h=(Hello) ctx.getBean("hello2");
		h.sayHello();
	}
	@Test
	public void test1() {
		Hello h=(Hello) ctx.getBean("hello3");
		h.sayHello();
	}
	@Test
	public void test2() {
		Person p2=(Person) ctx.getBean("p2");
		Assert.assertEquals("刘备", p2.getName());
		Assert.assertEquals("关羽", p2.getFriend().getName());
	}
}
