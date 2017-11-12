package com.java8.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class BuildStreams {

	public static void main(String[] args) {
		//streamIterate();
//		fileStream();
//		fibonacci();
		generateRandom();
	}

	public static void build() {
		Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);

		Stream<String> emptyStream = Stream.empty();

		int[] numbers = {2, 3, 4, 5, 7, 11, 13};
		int sum = Arrays.stream(numbers).sum();

		
	}
	
	public static void fileStream() {
		//String dpath = "C:\\projects\\usefulCode\\src\\goodcode\\src\\main\\java\\com\\java8\\stream\\data.txt";
		//String dpath = "C:/projects/usefulCode/src/goodcode/src/main/java/com/java8/stream/data.txt";
		String dpath = "src/main/java/com/java8/stream/data.txt";
		long uniqueWords = 0;
		try (Stream<String> lines = Files.lines(Paths.get(dpath), Charset.defaultCharset())) {
			uniqueWords = lines.flatMap((line -> Arrays.stream(line.split(" ")))).distinct().count();
			System.out.println("unique words = " + uniqueWords);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void streamIterate() {
		Stream.iterate(0, n -> n + 2)
		.limit(10)
		.forEach(System.out::println);
	}
	/*	Fibonacci tuples series
	The Fibonacci series is famous as a classic programming exercise. The numbers in the following
	sequence are part of the Fibonacci series: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55.... The first two numbers of
	the series are 0 and 1, and each subsequent number is the sum of the previous two.
	The series of Fibonacci tuples is similar; you have a sequence of a number and its successor in the
	series: (0, 1), (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13, 21)....
*/
	public static void fibonacci() {
		Stream.iterate(new int[]{0, 1},
				t -> new int[]{t[1], t[0]+t[1]})
				.limit(20)
				.forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
	}

	public static void generateRandom() {
		Stream.generate(Math::random)
		.limit(5)
		.forEach(System.out::println);
	}
}
