package com.killerwilmer.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.killerwilmer.beans.AppConfig;
import com.killerwilmer.beans.AppConfig2;
import com.killerwilmer.beans.Mundo;
import com.killerwilmer.beans.Persona;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.register(AppConfig2.class);
		applicationContext.refresh();
		
		Mundo mundo = (Mundo) applicationContext.getBean("marte");
		
		System.out.print(mundo.getSaludo());
		
		((ConfigurableApplicationContext)applicationContext).close();
		
		// Por xml
		ApplicationContext applicationContextXml = new ClassPathXmlApplicationContext("com/killerwilmer/xml/beans.xml");
		Persona persona = (Persona) applicationContextXml.getBean("personaBean");
		System.out.print(persona.getId() + " " + persona.getNombre() + " " + persona.getApodo() + " " + persona.getPais().getNombre() + " " + persona.getPais().getCiudad().getNombre());
		((ConfigurableApplicationContext)applicationContextXml).close();
	}

}
