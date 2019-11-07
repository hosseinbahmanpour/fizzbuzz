package com.oneio.fizzbuzz.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.oneio.fizzbuzz.constants.FizzBuzzConstants;
import com.oneio.fizzbuzz.util.FizzBuzzUtil;

@Controller
@RequestMapping("fizzbuzz")
public class FizzBuzzController {

	@PostMapping()
	public RedirectView fizzBuzz(@RequestParam String content, RedirectAttributes attributes,
			HttpServletRequest request) {
		try {
			attributes.addFlashAttribute("content", FizzBuzzUtil.calculateFizzBuzz(content));
			attributes.addFlashAttribute("link", "fizzbuzz?content=" + content);
			return new RedirectView("index");
		} catch (Exception e) {
			attributes.addFlashAttribute("error", FizzBuzzConstants.requestErrorMessage + e.getMessage());
			attributes.addFlashAttribute("retry", FizzBuzzConstants.requestRetry);
			return new RedirectView("index");
		}
	}

	@GetMapping()
	@ResponseBody()
	public String fizzBuzz(@RequestParam String content) {
		try {
			return FizzBuzzUtil.calculateFizzBuzz(content);
		} catch (Exception e) {
			return FizzBuzzConstants.requestErrorMessage + e.getMessage();
		}
	}
}