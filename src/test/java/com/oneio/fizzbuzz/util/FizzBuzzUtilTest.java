package com.oneio.fizzbuzz.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FizzBuzzUtilTest {

	private static FizzBuzzUtil fizzBuzzUtil;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		fizzBuzzUtil = new FizzBuzzUtil();
	}

	@Test
	public void testNumber() {
		String request = "1;";
		assertEquals("1;", fizzBuzzUtil.fizzBuzz(request));
	}

	@Test
	public void testFizz() {
		String request = "3;";
		assertEquals("Fizz;", fizzBuzzUtil.fizzBuzz(request));
	}

	@Test
	public void testBuzz() {
		String request = "5;";
		assertEquals("Buzz;", fizzBuzzUtil.fizzBuzz(request));
	}

	@Test
	public void testFizzMultiple() {
		String request = "6;";
		assertEquals("Fizz;", fizzBuzzUtil.fizzBuzz(request));
	}

	@Test
	public void testBuzzMultiple() {
		String request = "10;";
		assertEquals("Buzz;", fizzBuzzUtil.fizzBuzz(request));
	}

	@Test
	public void testFizzBuzz() {
		String request = "15;";
		assertEquals("FizzBuzz;", fizzBuzzUtil.fizzBuzz(request));
	}

	@Test
	public void testComplex() {
		String request = "1;2;3;4;5;6;7;8;9;10;11;12;13;14;15";
		assertEquals("1;2;Fizz;4;Buzz;Fizz;7;8;Fizz;Buzz;11;Fizz;13;14;FizzBuzz;", fizzBuzzUtil.fizzBuzz(request));
	}
}
