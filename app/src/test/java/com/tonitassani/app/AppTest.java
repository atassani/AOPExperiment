package com.tonitassani.app;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tonitassani.aopexperiment.module.ModuleWithDefaultConstructor;
import com.tonitassani.aopexperiment.module.ModuleWithoutDefaultConstructor;

/*
 * Tests are ignored because all the instrumentation has been moved to main instead of test.
 * Maven was behaving diferently when dealing with configurations related to test and main code
 * so all exercises have been moved away from tests.
 * 
 * The code still remains to check if we can have tests and production code with AOP altogether.
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class AppTest {

	@Autowired
	ModuleWithDefaultConstructor moduleWithConstructor;
	
	@Autowired
	ModuleWithoutDefaultConstructor moduleWithoutConstructor;
	
	@Test
	public void testSumInModuleWithConstructor() {
		assertEquals(5, moduleWithConstructor.sum(3, 2));
	}

	@Test
	public void testSumInModuleWithoutConstructor() {
		assertEquals(5, moduleWithoutConstructor.sum(3, 2));
	}
}
