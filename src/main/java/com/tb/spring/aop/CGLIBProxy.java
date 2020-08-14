package com.tb.spring.aop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * CGLIBProxy 动态代理 基于继承
 * 
 * @author tanben
 *
 */
public class CGLIBProxy implements MethodInterceptor {
	public static void main(String[] args) {
		RealSubject rs = new RealSubject();
		HouserOwner ho = new HouserOwner();

		CGLIBProxy cp = new CGLIBProxy();
		RealSubject proxyRs = (RealSubject) cp.proxy(rs);
		proxyRs.say();

		HouserOwner proxyHo = (HouserOwner) cp.proxy(ho);
		proxyHo.sale();
	}

	private Object realSubject;

	/**
	 * @param obj目标对象代理类的实例
	 * @param method代理实例上调用父类方法的Method实例
	 * @param args传入到代理实例上方法参数值的对象数組
	 * @param methodProxy使用它调用父类的方法
	 * 
	 */
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("代理类" + obj.getClass());
		System.out.println("方法名称" + method.getName());
		if (args != null && args.length > 0) {//方法的参数值
			for (int i = 0; i < args.length; i++) {
				System.out.println("方法参数" + args[i]);
			}
		}
		Object returnObject = null;//方法的返回值 如果无返回值 为null
		returnObject = methodProxy.invoke(this.realSubject, args);//调用目标对象的方法
		return returnObject;
	}
	/**
	 * 代理方法
	 * @param targerObject
	 * @return
	 */
	public Object proxy(Object targerObject) {
		this.realSubject = targerObject;
		Enhancer eh = new Enhancer();//该类用于生成代理对象
		eh.setSuperclass(targerObject.getClass());//设置父类
		eh.setCallback(this);//设置回调函数对象为本身
		return eh.create();//创建代理对象

	}
}
