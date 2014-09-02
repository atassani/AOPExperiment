package com.tonitassani.aopexperiment.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tonitassani.aopexperiment.module.ModuleWithDefaultConstructor;
import com.tonitassani.aopexperiment.module.ModuleWithoutDefaultConstructor;

@Controller
public class AopExperimentController {

	@Autowired
	ModuleWithDefaultConstructor 	moduleWith;
	@Autowired
	ModuleWithoutDefaultConstructor moduleWithout;

	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("sumWithout", moduleWithout.sum(3, 5));
		modelAndView.addObject("sumWith", 	 moduleWith.sum(3, 5));
		return modelAndView;
	}

}
