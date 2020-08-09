package com.tb.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tb.spring.dao.UserDao;

/**
 * Spring框架解决的问题 
 * Servlet 
 * UserBiz ubiz = new UserBiz(); 
 * UserBiz ubiz = new SubUserBiz1(); 
 * UserBiz ubiz = new SubUserBiz2(); 
 * 1. new 	==>创建对象
 * 			==>内存中占用存储对象的空间 每次new都会创建一个新的对象
 * 			==>内存消耗大 解决的方式:	
 * 				使用对象池 对象池. get对象获取对象 
 * 2.耦合性问题 对象可以任意在运行期设置为指定的子类现实类 控制反转:
 * 		 对象创建有程序员决定 对象的创建由容器决定
 * 控制反转:
 * 		对象创建有程序员决定
 * 		对象的创建由容器决定
 * @author tanben
 *
 */
public class HelloTest {
	@Test
	public void test() {

		// Spring 容器对象
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Hello h = (Hello) ctx.getBean("hello");
		h.sayHello();
		ctx.close();
	}

	@Test
	public void test1() {
		// Spring 容器对象
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserDao user1 = (UserDao) ctx.getBean("odao");
		UserDao user2 = (UserDao) ctx.getBean("mdao");
		user1.getUserId("zhangsan");
		user2.getUserId("lisi");
		ctx.close();
	}
}
