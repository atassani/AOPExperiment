package com.tonitassani.aopexperiment.module;

import org.springframework.stereotype.Component;

@Component
public class ModuleWithDefaultConstructor {

	public ModuleWithDefaultConstructor() {}
	
	public int sum(int a, int b) {
		return a+b;
	}
	
	public Integer sumObjects(Integer a, Integer b) {
		return a+b;
	}
	
	public void echoHello() {
		System.out.println("Hello");
	}
}
