package com.oneio.fizzbuzz.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oneio.fizzbuzz.constants.FizzBuzzConstants;
import com.oneio.fizzbuzz.model.FizzBuzz;
import com.oneio.fizzbuzz.util.FizzBuzzUtil;

@RestController
public class FizzBuzzController {

	@RequestMapping(value = "fizzbuzz", method = RequestMethod.POST)
	public String fizzBuzz(Model m, @RequestParam String content) {
		try {
			FizzBuzz fizzBuzz = new FizzBuzz();
			FizzBuzzUtil fizzBuzzUtil = new FizzBuzzUtil();
			fizzBuzz.setContent(fizzBuzzUtil.fizzBuzz(content));
			return fizzBuzz.getContent();
		} catch (Exception e) {
			return FizzBuzzConstants.fizzBuzzRequestError() + e;
		}
	}
}
