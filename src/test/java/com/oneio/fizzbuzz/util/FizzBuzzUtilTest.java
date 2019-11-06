package com.oneio.fizzbuzz.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.oneio.fizzbuzz.constants.FizzBuzzTestingConstants;

class FizzBuzzUtilTest {

	@Test
	public void testNumber() {
		assertEquals("1", FizzBuzzUtil.calculateFizzBuzz("1"));
	}

	@Test
	public void testFizz() {
		assertEquals("Fizz", FizzBuzzUtil.calculateFizzBuzz("3"));
	}

	@Test
	public void testBuzz() {
		assertEquals("Buzz", FizzBuzzUtil.calculateFizzBuzz("5"));
	}

	@Test
	public void testFizzMultiple() {
		assertEquals("Fizz", FizzBuzzUtil.calculateFizzBuzz("6"));
	}

	@Test
	public void testBuzzMultiple() {
		assertEquals("Buzz", FizzBuzzUtil.calculateFizzBuzz("10"));
	}

	@Test
	public void testFizzBuzz() {
		assertEquals("FizzBuzz", FizzBuzzUtil.calculateFizzBuzz("15"));
	}

	@Test
	public void testComplex() {
		assertEquals(FizzBuzzTestingConstants.complexResponse,
				FizzBuzzUtil.calculateFizzBuzz(FizzBuzzTestingConstants.complexRequest));
	}
}