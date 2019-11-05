package com.oneio.fizzbuzz.util;

import java.util.ArrayList;

public class FizzBuzzUtil {

	public static String fizzBuzz(String stringToFizzBuzz) {
		String fizzBuzzedString = "";
		ArrayList<Integer> integers = fizzBuzzHelper(stringToFizzBuzz);
		for (Integer integer : integers) {
			if (integer.intValue() % 3 == 0 && integer.intValue() % 5 == 0) {
				fizzBuzzedString = fizzBuzzedString + "FizzBuzz";
			} else if (integer.intValue() % 3 == 0) {
				fizzBuzzedString = fizzBuzzedString + "Fizz";
			} else if (integer.intValue() % 5 == 0) {
				fizzBuzzedString = fizzBuzzedString + "Buzz";
			} else {
				fizzBuzzedString = fizzBuzzedString + integer;
			}
			fizzBuzzedString = fizzBuzzedString + ";";
		}
		return fizzBuzzedString;
	}

	private static ArrayList<Integer> fizzBuzzHelper(String request) {
		String[] numbers = request.split(";");
		ArrayList<Integer> response = new ArrayList<Integer>();
		for (String number : numbers) {
			response.add(Integer.parseInt(number));
		}
		return response;
	}
}
