package com.tb.spring.dao;

public class OracleDao implements UserDao {

	@Override
	public void getUserId(String name) {
		System.out.println("Oracle");
		
	}

}
