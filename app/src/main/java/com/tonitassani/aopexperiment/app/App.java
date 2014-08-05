package com.tonitassani.aopexperiment.app;

import javax.inject.Inject;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tonitassani.aopexperiment.module.ModuleWithDefaultConstructor;

public class App {

	@Inject
	ModuleWithDefaultConstructor module;
	
	public static void main(String[] args) {
		 ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/application-context.xml");
		 ModuleWithDefaultConstructor module = context.getBean("moduleWithDefaultConstructor", ModuleWithDefaultConstructor.class);
		 System.out.println(module.sum(3, 5));
		 context.close();
	}

}
