package com.java8.stream;

import java.util.stream.IntStream;

/*IntStream,
DoubleStream, and LongStream,*/
public class Numeric {

/*	calculate the number of calories in the menu as follows:
		int calories = menu.stream()
		.map(Dish::getCalories)
		.reduce(0, Integer::sum);
Behind the scenes each Integer
needs to be unboxed to a primitive
		*/
/*	The most common methods you’ll use to convert a stream to a specialized version are mapToInt,
	mapToDouble, and mapToLong.*/
	
/*	int calories = menu.stream()
			.mapToInt(Dish::getCalories)
			.sum();*/
	
/*	Converting back to a stream of objects:
		IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
Stream<Integer> stream = intStream.boxed();*/
	
/*	OptionalInt maxCalories = menu.stream()
			.mapToInt(Dish::getCalories)
			.max();
	
	IntStream evenNumbers = IntStream.rangeClosed(1,  100).filter(n -> n % 2 == 0);
	
	
	IntStream evenNumbers = IntStream.range(1,  100).filter(n -> n % 2 == 0);
	
	Pythagorean triple
	triples of numbers (a, b, c) satisfy the formula a * a + b * b = c * c where a, b, and c are
	integers
	
	test whether the square root of a * a + b * b is an integer number:
		filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
	
		Stream<int[]> pythagoreanTriples =
		IntStream.rangeClosed(1, 100).boxed()
		.flatMap(a ->
		IntStream.rangeClosed(a, 100)
		.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
		.mapToObj(b ->
		new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
		);
		
The current solution isn’t optimal because you calculate the square root twice.One possible way to
make your code more compact is to generate all triples of the form (a*a, b*b, a*a+b*b) and then
filter the ones that match your criteria:
		Stream<int[]> pythagoreanTriples2 =
		IntStream.rangeClosed(1, 100).boxed()
		.flatMap(a -> IntStream.rangeClosed(a, 100)
		.mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)}).filter(t -> t[2] % 1 == 0));

		*
		*
		*
		*/
}
