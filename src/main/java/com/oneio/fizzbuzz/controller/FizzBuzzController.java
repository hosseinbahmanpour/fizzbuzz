package com.oneio.fizzbuzz.controller;

import javax.servlet.http.HttpServletResponse;

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

	@PostMapping
	public RedirectView fizzBuzz(@RequestParam String content, RedirectAttributes attributes) {
		try {
			attributes.addFlashAttribute("content", FizzBuzzUtil.calculateFizzBuzz(content));
			attributes.addFlashAttribute("link", FizzBuzzConstants.fizzBuzzContentUrl + content);
			return new RedirectView("index");
		} catch (Exception e) {
			attributes.addFlashAttribute("error", FizzBuzzConstants.requestErrorMessage + e.getMessage());
			attributes.addFlashAttribute("retry", FizzBuzzConstants.requestRetryMessage);
			return new RedirectView("index");
		}
	}

	@GetMapping
	@ResponseBody
	public String fizzBuzz(@RequestParam String content, HttpServletResponse httpResponse) {
		try {
			return FizzBuzzUtil.calculateFizzBuzz(content);
		} catch (Exception e) {
			httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return FizzBuzzConstants.requestErrorMessage + e.getMessage();
		}
	}

	@GetMapping("*")
	public String fizzBuzz() {
		return "redirect:/index";
	}
}