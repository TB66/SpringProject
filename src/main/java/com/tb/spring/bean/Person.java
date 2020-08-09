package com.tb.spring.bean;

import java.util.List;

public class Person {
	private String name;
	private String sex;
	private int age;
	private List<?> hero;
	
	public List<?> getHero() {
		return hero;
	}
	public void setHero(List<?> hero) {
		this.hero = hero;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
