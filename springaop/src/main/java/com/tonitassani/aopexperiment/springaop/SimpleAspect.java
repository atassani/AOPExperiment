package com.tonitassani.aopexperiment.springaop;

import javax.inject.Named;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Named
@Aspect
public class SimpleAspect {

	@Around("execution(* com.tonitassani.aopexperiment.module.Module*DefaultConstructor.sum(..)) && args(a,b)") 
	public int sumAdvice(ProceedingJoinPoint joinPoint, int a, int b) throws Throwable {
		System.out.println("INTERCEPTED ****************************************");
		Integer ret = (Integer) joinPoint.proceed(new Object[] {a + 2, b + 3});
		return ret;
	}
}
