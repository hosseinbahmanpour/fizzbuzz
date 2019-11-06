package com.oneio.fizzbuzz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oneio.fizzbuzz.constants.FizzBuzzConstants;
import com.oneio.fizzbuzz.util.FizzBuzzUtil;

@RestController
public class FizzBuzzController {

	@RequestMapping(value = "fizzbuzz", method = RequestMethod.POST)
	public String fizzBuzz(@RequestParam String content) {
		try {
			return FizzBuzzUtil.fizzBuzz(content);
		} catch (Exception e) {
			return FizzBuzzConstants.requestError + e.getMessage();
		}
	}
}