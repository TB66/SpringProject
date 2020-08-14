package com.tb.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * JDKProxy 动态代理  基于接口
 * @author tanben
 *
 */
public class JDKProxy implements InvocationHandler {
	/**
	 * 被代理对象
	 */
	private Object realSubject;
	/**
	 * @param proxy 目标对象的代理类实例
	 * @param method 对应于在代理实例.上调用接口方法的Method实例
	 * @param args 传入到代理实例_上方法参数值的对象数组
	 * @return 方法的返回值没有返回值时是nu1l
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("我的当事人有不在场证明");
		Object ret = method.invoke(realSubject, args);
		System.out.println("我的当事人有不在场证明");
		return ret;
	}

	/**
	 * 构建代理对象
	 * 
	 * @param targerObject
	 * @return
	 */
	public Object createProxyInstance(Object targerObject) {
		/**
		 * 第一个参数设置代码使用的共加载器,一般采用跟目标类相同的类加载器
		 * 第二个参数设置代理类实现的接口,跟目标类使用相同的接口
		 * 第三个参数设置回调对象,当代理对象的方法被调用时。会调用该参数指定对象的invoke方法
		 */
		this.realSubject = targerObject;
		return Proxy.newProxyInstance(targerObject.getClass().getClassLoader(), targerObject.getClass().getInterfaces(),
				this);
	}

	public static void main(String[] args) {
		JDKProxy jp = new JDKProxy();
		RealSubject rs = new RealSubject();
		Subject ps = (Subject) jp.createProxyInstance(rs);
		ps.say();

		HouserOwner ho = new HouserOwner();
		Broker bk = (Broker) jp.createProxyInstance(ho);
		bk.sale();
	}

}

interface Broker {
	void sale();
}

class HouserOwner implements Broker {

	@Override
	public void sale() {
		System.out.println("房子又大又宽");

	}

}