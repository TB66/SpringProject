package com.tb.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tb.spring.dao.UserDao;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AOPConfig.class)
public class AOPTest {
	@Autowired
	@Qualifier("mdao") // 指定注入的组件id
	private UserDao mdao;
	@Autowired
	@Qualifier("odao")
	private UserDao odao;
	@Autowired
	private Hello hello;
	@Autowired
	private HelloWorld hw;
	@Test
	public void test1() {
		System.out.println("=====1======");
		mdao.getUserId("mm");
		System.out.println("=====2======");
		odao.getUserId("oo");
		System.out.println("=====1======");
	}

	@Test
	public void test2() {
		System.out.println(mdao.getClass());
		System.out.println(odao.getClass());
	}
	@Test
	public void test3() {
		System.out.println(hw.getClass());
		hw.say();
	}
}
