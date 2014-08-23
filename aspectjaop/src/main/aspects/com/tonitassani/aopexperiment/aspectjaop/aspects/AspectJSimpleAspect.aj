package com.tonitassani.aopexperiment.aspectjaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.CodeSignature;

public aspect AspectJSimpleAspect {

	pointcut sumPointcut(int a, int b):
		args(a, b) &&
		call( * com.tonitassani.aopexperiment.module.ModuleWithoutDefaultConstructor.*(..));
		//call( * com.thomsonreuters.nge.admin.NgeFacade*.authenticate(String, String, String));
		
	pointcut anyMethodPointcut():
		call( * com.tonitassani..*.*(..));
	
	int around(int a, int b): sumPointcut(a, b) {
		System.out.println("INTERCEPCTED (AspecJ)**********************");
		int res = proceed(a + 2, b + 3);
		return res;
	}

/*
	Object around(): anyMethodPointcut() {
 	  	System.out.println("Intercepted message: " + thisJoinPointStaticPart.getSignature().getName());
      	System.out.println("in class: " + thisJoinPointStaticPart.getSignature().getDeclaringType().getName());
      	printParameters(thisJoinPoint);
		return proceed();
	}
	
	static private void printParameters(JoinPoint jp) {
      System.out.println("Arguments: " );
      Object[] args = jp.getArgs();
      String[] names = ((CodeSignature)jp.getSignature()).getParameterNames();
      Class[] types = ((CodeSignature)jp.getSignature()).getParameterTypes();
      for (int i = 0; i < args.length; i++) {
         System.out.println("  "  + i + ". " + names[i] +
             " : " +            types[i].getName() +
             " = " +            args[i]);
      }
   }
*/
}

