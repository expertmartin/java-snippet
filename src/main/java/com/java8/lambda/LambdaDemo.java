package com.java8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LambdaDemo {
	public static void main(String[] arg) {
		try {
			run1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		String filepath = "src\\main\\resources\\testdata\\data.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			return p.process(br);
		}
	}

	public static void run1() throws IOException {
		String oneLine =
				processFile((BufferedReader br) -> br.readLine());
		
		System.out.println("read line: " + oneLine);
	}
}
