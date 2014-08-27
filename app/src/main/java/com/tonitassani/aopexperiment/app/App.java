package com.tonitassani.aopexperiment.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tonitassani.aopexperiment.module.ModuleWithDefaultConstructor;
import com.tonitassani.aopexperiment.module.ModuleWithoutDefaultConstructor;

public class App {


	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("ERROR: Missing parameter Spring Application Context file");
			System.exit(-1);
		}
		String springFile = args[0];
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(springFile);
		ModuleWithoutDefaultConstructor moduleWithout = context.getBean("moduleWithoutDefaultConstructor", ModuleWithoutDefaultConstructor.class);
		ModuleWithDefaultConstructor moduleWith =       context.getBean("moduleWithDefaultConstructor", ModuleWithDefaultConstructor.class);
		System.out.println("");
		System.out.println("----------------------------");
		System.out.println("moduleWithoutDefaultConstructor.sum(3, 5) = "  + moduleWithout.sum(3, 5));
		System.out.println("moduleWithDefaultConstructor.sum(3, 5)    = "  + moduleWith.sum(3, 5));
		System.out.println("----------------------------");
		System.out.println("");
		context.close();
	}
}