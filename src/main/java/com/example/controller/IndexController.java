package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "login";
	}
	
	@RequestMapping("/page")
	public String page(String page) {
		return page;
	}
	
}
