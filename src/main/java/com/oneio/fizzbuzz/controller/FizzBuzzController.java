package com.oneio.fizzbuzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.oneio.fizzbuzz.constants.FizzBuzzConstants;
import com.oneio.fizzbuzz.util.FizzBuzzUtil;

@Controller
public class FizzBuzzController {

	@RequestMapping(value = "fizzbuzz", method = RequestMethod.POST)
	public RedirectView fizzBuzzPost(@RequestParam String content, RedirectAttributes attributes) {
		try {
			attributes.addAttribute("content", FizzBuzzUtil.calculateFizzBuzz(content));
			return new RedirectView("fizzbuzz");
		} catch (Exception e) {
			attributes.addFlashAttribute("error", FizzBuzzConstants.requestErrorMessage + e.getMessage());
			attributes.addFlashAttribute("retry", FizzBuzzConstants.requestRetry);
			return new RedirectView("index");
		}
	}

	@GetMapping("fizzbuzz")
	@ResponseBody
	public String fizzBuzzGet(@RequestParam String content) {
		return content;
	}
}