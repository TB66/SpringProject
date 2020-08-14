package com.tb.spring;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tb.spring.bean.Person;
import com.tb.spring.dao.MySqlDao;
import com.tb.spring.dao.OracleDao;

/**
 * 注解方式配置IOC容器
 * @author tanben
 *
 */
@Configuration //IOC容器配置类的注解 ==>beans.xml
public class BeanConfig {
	//beans.xml 中每一个bean 对应java中的一个方法	这个方法返回一个bean对象
	
	@Bean(name = "mdao")
	public MySqlDao getMySqlDao() {
		return new MySqlDao();
	}
	@Bean(name = "odao")
	public OracleDao getOracleDao() {
		return new OracleDao();
	}
	@Bean(name = "hello")
	public Hello getHello() {
		return new Hello();
	}
	@Bean(name = "p1")
	public Person getPerson1() {
		Person p=new Person();
		p.setName("武松");
		p.setAge(35);
		p.setHero(new ArrayList<>());
		p.getHero().add("蒋门神");
		p.getHero().add("蒋门神");
		p.getHero().add("蒋门神");
		p.getHero().add("蒋门神");
		p.getHero().add("蒋门神");
		return p;
	}

	@Bean(name = "p5")
	public Person getPerson5() {
		Person p=Person.PersonFactory();
		p.setName("王英");
		p.setAge(40);
		return p;
	}
}
