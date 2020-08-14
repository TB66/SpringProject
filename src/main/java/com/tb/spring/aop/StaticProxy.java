package com.tb.spring.aop;
/**
 * 静态代理
 * @author tanben
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		Subject sj=new ProxySubject();
		sj.say();
	}
}

/**
 * 抽象主题
 * 
 * @author tanben
 *
 */
interface Subject {
	void say();
}

/**
 * 真实主题 ：被告
 * 
 * @author tanben
 *
 */
class RealSubject implements Subject {

	@Override
	public void say() {
		System.out.println("真的不是我干的");
	}

}

class ProxySubject implements Subject {
	Subject sj = new RealSubject();

	@Override
	public void say() {
		System.out.println("我的当事人有不在场证明");
		sj.say();
		System.out.println("我的当事人有不在场证明");
	}

}
