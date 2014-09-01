package com.tonitassani.aopexperiment.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tonitassani.aopexperiment.webapp.beans.Product;
import com.tonitassani.aopexperiment.webapp.service.ProductsService;

@Controller
public class AopExperimentController {

	@Autowired
	ProductsService productService;

	@RequestMapping("/home")
	public String helloWorld() {
		return "home";
	}

	@RequestMapping("/list")
	public ModelAndView listAll() {
		ModelAndView modelAndView = new ModelAndView("list");
		List<Product> productList = productService.getAllProducts();
		modelAndView.addObject("productList", productList);
		return modelAndView;
	}

}
