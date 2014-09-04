package com.tonitassani.aopexperiment.aspectjaop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SimpleAspect {

	@Around("execution(* com.tonitassani.aopexperiment.module.ModuleWithoutDefaultConstructor.sum(..)) && args(a,b)") 
	public int sumAdvice(ProceedingJoinPoint joinPoint, int a, int b) throws Throwable {
		System.out.println("ASPECTJ INTERCEPTED ****************************************");
		return (Integer)joinPoint.proceed(new Integer[] {a + 2, b + 3});
	}
}
