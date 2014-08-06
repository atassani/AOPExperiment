package com.tonitassani.aopexperiment.aspectjaop.aspects;

public aspect AspectJSimpleAspect {

	pointcut sumPointcut(int a, int b):
		args(a, b) &&
		call( * com.tonitassani.aopexperiment.module.ModuleWithoutDefaultConstructor.*(..));
		//call( * com.thomsonreuters.nge.admin.NgeFacade*.authenticate(String, String, String));
		
	pointcut sumObjectPointcut(Integer a, Integer b):
		args(a, b) &&
		call( * com.tonitassani.aopexperiment.module.ModuleWithoutDefaultConstructor.*(..));
		//call( * com.thomsonreuters.nge.admin.NgeFacade*.authenticate(String, String, String));
		
	
	Object around(int a, int b): sumPointcut(a, b) {
		System.out.println("INTERCEPCTED (AspecJ)**********************");
		Object res = proceed(a + 2, b + 3);
		return res;
	}

	Object around(Integer a, Integer b): sumObjectPointcut(a, b) {
		System.out.println("INTERCEPCTED (AspecJ)**********************");
		Object res = proceed(new Integer(a.intValue() + 2), new Integer(b.intValue() + 3));
		return res;
	}
}

