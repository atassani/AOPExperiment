package com.tonitassani.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tonitassani.aopexperiment.module.ModuleWithDefaultConstructor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")

public class AppTest {

	@Autowired
	ModuleWithDefaultConstructor module;
	
	@Test
	public void testSum() {
		assertEquals(5, module.sum(3, 2));
	}
}
