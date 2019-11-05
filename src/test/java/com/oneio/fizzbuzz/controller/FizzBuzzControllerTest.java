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

@RunWith(SpringRunner.class)
@WebMvcTest(FizzBuzzController.class)
class FizzBuzzControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void fizzBuzzComplexRequestResponseTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/fizzbuzz?content=1;2;3;4;5;6;7;8;9;10;11;12;13;14;15;")
				.accept(MediaType.ALL_VALUE)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("1;2;Fizz;4;Buzz;Fizz;7;8;Fizz;Buzz;11;Fizz;13;14;FizzBuzz;")));
	}
}
