package com.tb.spring.dao;

public class MySqlDao implements UserDao {

	@Override
	public void getUserId(String name) {
		System.out.println("MySql");
		
	}

}
