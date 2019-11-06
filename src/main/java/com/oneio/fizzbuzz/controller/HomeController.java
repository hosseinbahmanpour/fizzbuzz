package com.oneio.fizzbuzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

	@GetMapping("*")
	public String home(@ModelAttribute String error) {
		return "index";
	}
}