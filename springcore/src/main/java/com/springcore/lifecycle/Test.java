package com.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
		"com/springcore/lifecycle/configlifecycle.xml");
		// registering shutdown hook
		context.registerShutdownHook();
//		Car c1 = (Car) context.getBean("c1");
//		System.out.println(c1); 
	
//		Bike bike = (Bike) context.getBean("b1");
//		System.out.println(bike);
		
		Example ex =(Example) context.getBean("example");
		System.out.println(ex);
	}

}
