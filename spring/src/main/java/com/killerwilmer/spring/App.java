package com.killerwilmer.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.killerwilmer.beans.Mundo;

public class App {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/killerwilmer/xml/beans.xml");
		Mundo mundo = (Mundo) applicationContext.getBean("mundo");
		
		System.out.print(mundo.getSaludo());
		
		((ConfigurableApplicationContext)applicationContext).close();
	}

}
