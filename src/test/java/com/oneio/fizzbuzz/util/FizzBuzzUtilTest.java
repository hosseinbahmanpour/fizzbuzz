package com.oneio.fizzbuzz.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FizzBuzzUtilTest {

	@Test
	public void testNumber() {
		assertEquals("1;", FizzBuzzUtil.fizzBuzz("1"));
	}

	@Test
	public void testFizz() {
		assertEquals("Fizz;", FizzBuzzUtil.fizzBuzz("3"));
	}

	@Test
	public void testBuzz() {
		assertEquals("Buzz;", FizzBuzzUtil.fizzBuzz("5"));
	}

	@Test
	public void testFizzMultiple() {
		assertEquals("Fizz;", FizzBuzzUtil.fizzBuzz("6"));
	}

	@Test
	public void testBuzzMultiple() {
		assertEquals("Buzz;", FizzBuzzUtil.fizzBuzz("10"));
	}

	@Test
	public void testFizzBuzz() {
		assertEquals("FizzBuzz;", FizzBuzzUtil.fizzBuzz("15"));
	}

	@Test
	public void testComplex() {
		assertEquals("1;2;Fizz;4;Buzz;Fizz;7;8;Fizz;Buzz;11;Fizz;13;14;FizzBuzz;",
				FizzBuzzUtil.fizzBuzz("1;2;3;4;5;6;7;8;9;10;11;12;13;14;15"));
	}
}
