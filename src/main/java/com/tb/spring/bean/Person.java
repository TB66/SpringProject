package com.tb.spring.bean;

import java.util.List;

public class Person {
	private String name;
	private String alisa;
	private int age;
	private List<?> hero;
	private Person friend;

	public Person getFriend() {
		return friend;
	}

	public void setFriend(Person friend) {
		this.friend = friend;
	}

	public Person() {
		super();
	}

	public Person(int age, String name, String alisa) {
		super();
		this.name = name;
		this.alisa = alisa;
		this.age = age;
	}

	public Person(String name, String alisa, int age) {
		super();
		this.name = name;
		this.alisa = alisa;
		this.age = age;
	}

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

	public String getAlisa() {
		return alisa;
	}

	public void setAlisa(String alisa) {
		this.alisa = alisa;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
