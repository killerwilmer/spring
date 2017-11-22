package com.killerwilmer.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.killerwilmer.beans.AppConfig;
import com.killerwilmer.beans.AppConfig2;
import com.killerwilmer.beans.Mundo;

public class App {

	public static void main(String[] args) {
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/killerwilmer/xml/beans.xml");
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.register(AppConfig2.class);
		applicationContext.refresh();
		
		Mundo mundo = (Mundo) applicationContext.getBean("marte");
		
		System.out.print(mundo.getSaludo());
		
		((ConfigurableApplicationContext)applicationContext).close();
	}

}
