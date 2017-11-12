package com.algorithm.recursion;

public class Factorial {
	public static void main(String[] args) {
		long n = 4;
		System.out.println("factorialRecursive(" + n + ") = " + factorialRecursive(n));
		System.out.println("bifactorialRecursive(" + n + ") = " + bifactorialRecursive(n));
		System.out.println("bifactorialRecursive(" + n + ") = " + factorialTailRecursive(n));
	}

	// f(n) = n!;
	static long factorialRecursive(long n) {
		return n == 1 ? 1 : n * factorialRecursive(n - 1);
	}

	// f(n) = n + (n-1) + ... + 2 + 1 = n + f(n-1);
	static long bifactorialRecursive(long n) {
		System.out.println("in recursion, n = " + n);
		return n == 1 ? 1 : n + bifactorialRecursive(n - 1);
	}

	// f(n) = f(n-1) + f(n-2);
	static long trifactorialRecursive(long n) {
		System.out.println("in recursion, n = " + n);
		return n == 1 ? 1 : trifactorialRecursive(n - 1) + trifactorialRecursive(n - 2);
	}

	static long factorialTailRecursive(long n) {
		return factorialHelper(1, n);
	}

	static long factorialHelper(long acc, long n) {
		System.out.println("in factorial Helper(" + acc + ", " + n + ")");
		return n == 1 ? acc : factorialHelper(acc * n, n - 1);
	}
}
