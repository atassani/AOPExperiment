package com.tonitassani.app;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tonitassani.aopexperiment.module.ModuleWithDefaultConstructor;
import com.tonitassani.aopexperiment.module.ModuleWithoutDefaultConstructor;

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
	
	@Test
	public void testSumObjectInModuleWithConstructor() {
		assertEquals(Integer.valueOf(5), moduleWithConstructor.sumObjects(3, 2));
	}

	@Test
	public void testSumObjectInModuleWithoutConstructor() {
		assertEquals(Integer.valueOf(5), moduleWithoutConstructor.sumObjects(3, 2));
	}
}
