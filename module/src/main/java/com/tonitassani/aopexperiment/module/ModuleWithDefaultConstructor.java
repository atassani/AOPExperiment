package com.tonitassani.aopexperiment.module;

import org.springframework.stereotype.Component;

@Component
public class ModuleWithDefaultConstructor {

	public ModuleWithDefaultConstructor() {}
	
	public int sum(int a, int b) {
		return a+b;
	}
}
