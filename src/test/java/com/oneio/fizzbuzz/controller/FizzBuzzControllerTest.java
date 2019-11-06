package com.oneio.fizzbuzz.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.oneio.fizzbuzz.constants.FizzBuzzConstants;
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
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzUtil.fizzBuzz(request))));
	}

	@Test
	public void testFizz() throws Exception {
		String request = "3";
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzUtil.fizzBuzz(request))));
	}

	@Test
	public void testBuzz() throws Exception {
		String request = "5";
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzUtil.fizzBuzz(request))));
	}

	@Test
	public void testFizzMultiple() throws Exception {
		String request = "6";
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzUtil.fizzBuzz(request))));
	}

	@Test
	public void testBuzzMultiple() throws Exception {
		String request = "10";
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzUtil.fizzBuzz(request))));
	}

	@Test
	public void testFizzBuzz() throws Exception {
		String request = "15";
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzUtil.fizzBuzz(request))));
	}

	@Test
	public void testComplex() throws Exception {
		String request = "1;2;3;4;5;6;7;8;9;10;11;12;13;14;15";
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzUtil.fizzBuzz(request))));
	}

	@Test
	public void testError() throws Exception {
		String request = "a";
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzConstants.requestError + "For input string: \"a\"")));
	}

	@Test
	public void testComplexError() throws Exception {
		String request = "1;2;3;b;5;";
		mvc.perform(MockMvcRequestBuilders.post(url + request).accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(FizzBuzzConstants.requestError + "For input string: \"b\"")));
	}
}