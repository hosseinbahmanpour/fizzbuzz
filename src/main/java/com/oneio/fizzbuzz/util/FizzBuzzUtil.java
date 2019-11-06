package com.oneio.fizzbuzz.util;

import java.util.ArrayList;

public class FizzBuzzUtil {

	public static String calculateFizzBuzz(String request) {
		StringBuilder responseBuilder = new StringBuilder();
		ArrayList<Integer> integers = splitToIntegers(request);
		for (Integer integer : integers) {
			int i = (int) integer;
			if (i % 3 == 0 && i % 5 == 0) {
				responseBuilder.append("FizzBuzz");
			} else if (i % 3 == 0) {
				responseBuilder.append("Fizz");
			} else if (i % 5 == 0) {
				responseBuilder.append("Buzz");
			} else {
				responseBuilder.append(i);
			}
			responseBuilder.append(";");
		}
		return responseBuilder.toString().substring(0, responseBuilder.toString().length() - 1);
	}

	private static ArrayList<Integer> splitToIntegers(String request) {
		String[] numbers = request.split(";");
		ArrayList<Integer> response = new ArrayList<>();
		for (String number : numbers) {
			response.add(Integer.parseInt(number));
		}
		return response;
	}
}