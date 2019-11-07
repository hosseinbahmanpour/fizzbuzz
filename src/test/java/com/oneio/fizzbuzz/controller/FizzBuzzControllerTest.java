package com.oneio.fizzbuzz.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
	private static final String urlNoDash = "fizzbuzz?content=";

	@Test
	public void testNumberGet() throws Exception {
		String request = "1";
		mvc.perform(MockMvcRequestBuilders.get(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzUtil.calculateFizzBuzz(request))));
	}

	@Test
	public void testFizzGet() throws Exception {
		String request = "3";
		mvc.perform(MockMvcRequestBuilders.get(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzUtil.calculateFizzBuzz(request))));
	}

	@Test
	public void testBuzzGet() throws Exception {
		String request = "5";
		mvc.perform(MockMvcRequestBuilders.get(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzUtil.calculateFizzBuzz(request))));
	}

	@Test
	public void testFizzMultipleGet() throws Exception {
		String request = "6";
		mvc.perform(MockMvcRequestBuilders.get(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzUtil.calculateFizzBuzz(request))));
	}

	@Test
	public void testBuzzMultipleGet() throws Exception {
		String request = "10";
		mvc.perform(MockMvcRequestBuilders.get(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzUtil.calculateFizzBuzz(request))));
	}

	@Test
	public void testFizzBuzzGet() throws Exception {
		String request = "15";
		mvc.perform(MockMvcRequestBuilders.get(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzUtil.calculateFizzBuzz(request))));
	}

	@Test
	public void testComplexGet() throws Exception {
		String request = FizzBuzzTestingConstants.complexRequest;
		mvc.perform(MockMvcRequestBuilders.get(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzUtil.calculateFizzBuzz(request))));
	}

	@Test
	public void testErrorGet() throws Exception {
		String request = "a";
		mvc.perform(MockMvcRequestBuilders.get(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(
						content().string(equalTo(FizzBuzzConstants.requestErrorMessage + "For input string: \"a\"")));
	}

	@Test
	public void testComplexErrorGet() throws Exception {
		String request = "1;2;3;b;5";
		mvc.perform(MockMvcRequestBuilders.get(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(
						content().string(equalTo(FizzBuzzConstants.requestErrorMessage + "For input string: \"b\"")));
	}

	@Test
	public void testEmptyResponseGet() throws Exception {
		String request = "";
		mvc.perform(MockMvcRequestBuilders.get(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzConstants.requestErrorMessage + "For input string: \"\"")));
	}

	@Test
	public void testNumberPost() throws Exception {
		String request = "1";
		String expectedResponse = FizzBuzzUtil.calculateFizzBuzz(request);
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("content"))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", expectedResponse))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("link"))
				.andExpect(MockMvcResultMatchers.flash().attribute("link", urlNoDash + request))
				.andExpect(MockMvcResultMatchers.flash().attribute("error", nullValue()))
				.andExpect(MockMvcResultMatchers.flash().attribute("retry", nullValue()));
	}

	@Test
	public void testFizzPost() throws Exception {
		String request = "3";
		String expectedResponse = FizzBuzzUtil.calculateFizzBuzz(request);
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("content"))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", expectedResponse))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("link"))
				.andExpect(MockMvcResultMatchers.flash().attribute("link", urlNoDash + request))
				.andExpect(MockMvcResultMatchers.flash().attribute("error", nullValue()))
				.andExpect(MockMvcResultMatchers.flash().attribute("retry", nullValue()));
	}

	@Test
	public void testBuzzPost() throws Exception {
		String request = "5";
		String expectedResponse = FizzBuzzUtil.calculateFizzBuzz(request);
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("content"))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", expectedResponse))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("link"))
				.andExpect(MockMvcResultMatchers.flash().attribute("link", urlNoDash + request))
				.andExpect(MockMvcResultMatchers.flash().attribute("error", nullValue()))
				.andExpect(MockMvcResultMatchers.flash().attribute("retry", nullValue()));
	}

	@Test
	public void testFizzMultiplePost() throws Exception {
		String request = "6";
		String expectedResponse = FizzBuzzUtil.calculateFizzBuzz(request);
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("content"))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", expectedResponse))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("link"))
				.andExpect(MockMvcResultMatchers.flash().attribute("link", urlNoDash + request))
				.andExpect(MockMvcResultMatchers.flash().attribute("error", nullValue()))
				.andExpect(MockMvcResultMatchers.flash().attribute("retry", nullValue()));
	}

	@Test
	public void testBuzzMultiplePost() throws Exception {
		String request = "10";
		String expectedResponse = FizzBuzzUtil.calculateFizzBuzz(request);
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("content"))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", expectedResponse))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("link"))
				.andExpect(MockMvcResultMatchers.flash().attribute("link", urlNoDash + request))
				.andExpect(MockMvcResultMatchers.flash().attribute("error", nullValue()))
				.andExpect(MockMvcResultMatchers.flash().attribute("retry", nullValue()));
	}

	@Test
	public void testFizzBuzzPost() throws Exception {
		String request = "15";
		String expectedResponse = FizzBuzzUtil.calculateFizzBuzz(request);
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("content"))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", expectedResponse))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("link"))
				.andExpect(MockMvcResultMatchers.flash().attribute("link", urlNoDash + request))
				.andExpect(MockMvcResultMatchers.flash().attribute("error", nullValue()))
				.andExpect(MockMvcResultMatchers.flash().attribute("retry", nullValue()));
	}

	@Test
	public void testComplexPost() throws Exception {
		String request = FizzBuzzTestingConstants.complexRequest;
		String expectedResponse = FizzBuzzUtil.calculateFizzBuzz(request);
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("content"))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", expectedResponse))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("link"))
				.andExpect(MockMvcResultMatchers.flash().attribute("link", urlNoDash + request))
				.andExpect(MockMvcResultMatchers.flash().attribute("error", nullValue()))
				.andExpect(MockMvcResultMatchers.flash().attribute("retry", nullValue()));
	}

	@Test
	public void testErrorPost() throws Exception {
		String request = "a";
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("error"))
				.andExpect(MockMvcResultMatchers.flash().attribute("error",
						FizzBuzzConstants.requestErrorMessage + "For input string: \"a\""))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("retry"))
				.andExpect(MockMvcResultMatchers.flash().attribute("retry", FizzBuzzConstants.requestRetry))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", nullValue()))
				.andExpect(MockMvcResultMatchers.flash().attribute("link", nullValue()));
	}

	@Test
	public void testComplexErrorPost() throws Exception {
		String request = "1;2;3;b;5";
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("error"))
				.andExpect(MockMvcResultMatchers.flash().attribute("error",
						FizzBuzzConstants.requestErrorMessage + "For input string: \"b\""))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("retry"))
				.andExpect(MockMvcResultMatchers.flash().attribute("retry", FizzBuzzConstants.requestRetry))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", nullValue()))
				.andExpect(MockMvcResultMatchers.flash().attribute("link", nullValue()));
	}

	@Test
	public void testEmptyResponsePost() throws Exception {
		String request = "";
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("error"))
				.andExpect(MockMvcResultMatchers.flash().attribute("error",
						FizzBuzzConstants.requestErrorMessage + "For input string: \"\""))
				.andExpect(MockMvcResultMatchers.flash().attributeExists("retry"))
				.andExpect(MockMvcResultMatchers.flash().attribute("retry", FizzBuzzConstants.requestRetry))
				.andExpect(MockMvcResultMatchers.flash().attribute("content", nullValue()))
				.andExpect(MockMvcResultMatchers.flash().attribute("link", nullValue()));
	}
}