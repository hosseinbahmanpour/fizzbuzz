package com.oneio.fizzbuzz.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.oneio.fizzbuzz.constants.FizzBuzzConstants;
import com.oneio.fizzbuzz.constants.FizzBuzzTestingConstants;
import com.oneio.fizzbuzz.util.FizzBuzzUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(FizzBuzzController.class)
class FizzBuzzControllerTest {

	@Autowired
	private MockMvc mvc;

	private static final String url = "/fizzbuzz?content=";

	@Test
	public void testNumber() throws Exception {
		String request = "1";
		String expectedResponse = FizzBuzzUtil.calculateFizzBuzz(request);
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("content"))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", expectedResponse));
	}

	@Test
	public void testFizz() throws Exception {
		String request = "3";
		String expectedResponse = FizzBuzzUtil.calculateFizzBuzz(request);
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("content"))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", expectedResponse));
	}

	@Test
	public void testBuzz() throws Exception {
		String request = "5";
		String expectedResponse = FizzBuzzUtil.calculateFizzBuzz(request);
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("content"))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", expectedResponse));
	}

	@Test
	public void testFizzMultiple() throws Exception {
		String request = "6";
		String expectedResponse = FizzBuzzUtil.calculateFizzBuzz(request);
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("content"))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", expectedResponse));
	}

	@Test
	public void testBuzzMultiple() throws Exception {
		String request = "10";
		String expectedResponse = FizzBuzzUtil.calculateFizzBuzz(request);
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("content"))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", expectedResponse));
	}

	@Test
	public void testFizzBuzz() throws Exception {
		String request = "15";
		String expectedResponse = FizzBuzzUtil.calculateFizzBuzz(request);
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("content"))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", expectedResponse));
	}

	@Test
	public void testComplex() throws Exception {
		String request = FizzBuzzTestingConstants.complexRequest;
		String expectedResponse = FizzBuzzUtil.calculateFizzBuzz(request);
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("content"))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", expectedResponse));
	}

	@Test
	public void testError() throws Exception {
		String request = "a";
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("error"))
				.andExpect(MockMvcResultMatchers.flash().attribute("error",
						FizzBuzzConstants.requestErrorMessage + "For input string: \"a\""))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("retry"))
				.andExpect(MockMvcResultMatchers.flash().attribute("retry", FizzBuzzConstants.requestRetry));
	}

	@Test
	public void testComplexError() throws Exception {
		String request = "1;2;3;b;5";
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("error"))
				.andExpect(MockMvcResultMatchers.flash().attribute("error",
						FizzBuzzConstants.requestErrorMessage + "For input string: \"b\""))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("retry"))
				.andExpect(MockMvcResultMatchers.flash().attribute("retry", FizzBuzzConstants.requestRetry));
	}

	@Test
	public void testEmptyResponse() throws Exception {
		String request = "";
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("error"))
				.andExpect(MockMvcResultMatchers.flash().attribute("error",
						FizzBuzzConstants.requestErrorMessage + "For input string: \"\""))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("retry"))
				.andExpect(MockMvcResultMatchers.flash().attribute("retry", FizzBuzzConstants.requestRetry));
	}
}