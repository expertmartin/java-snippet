package com.java8.stream;
/*queries combine all the elements in the stream
repeatedly to produce a single value such as an Integer.
These queries can be classified as reduction
operations (a stream is reduced to a value).
*/

public class Reduce {

	
/*	reduce takes two arguments:
 * 	An initial value, here 0.
 * 	A BinaryOperator<T> to combine two elements and produce a new value;
 *  here you use the lambda (a, b) -> a + b.
 *  int sum = numbers.stream().reduce(0, (a, b) -> a + b);
 *  int product = numbers.stream().reduce(1, (a, b) -> a * b);
 *  Optional<Integer> max = numbers.stream().reduce(Integer::max);
 *  Optional<Integer> min = numbers.stream().reduce(Integer::min);
 *  Optional<Integer> min = numbers.stream().reduce((x,y) -> x < y ? x : y);
 *  
 *  count the number of dishes in a stream using the map and reduce methods:
 *  int count = menu.stream().map(d -> 1).reduce(0, (a, b) -> a + b);
 *
 *  */
}
