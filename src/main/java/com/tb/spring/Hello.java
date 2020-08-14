package com.tb.spring;

public class Hello {

	public Hello() {
		System.out.println("=======无参数=======");
	}

	public Hello(int a) {
		System.out.println("=======有参数=======");
	}
	public void init() {
		System.out.println("Hello被创建");
	}
	public void destroy() {
		System.out.println("Hello被销毁");
	}
	public void sayHello() {
		System.out.println("Hello World");
	}
}
