package com.java8.optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

import java.util.Optional;

public class OptionalUtility {

	public static Optional<Integer> stringToInteger(String s) {
		try {
			return of(Integer.parseInt(s));
		} catch (NumberFormatException e) {
			return empty();
		}
	}

	public static Optional<Double> stringToDouble(String s) {
		try {
			return of(Double.parseDouble(s));
		} catch (NumberFormatException e) {
			return empty();
		}
	}

	public static Optional<Long> stringToLong(String s) {
		try {
			return of(Long.parseLong(s));
		} catch (NumberFormatException e) {
			return empty();
		}
	}
}
