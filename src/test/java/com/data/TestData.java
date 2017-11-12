package com.data;

import java.util.Arrays;
import java.util.List;

import com.java8.stream.Dish1;

public class TestData {

	public static List<Dish1> getMenu() {
		List<Dish1> menu = Arrays.asList(
				new Dish1("pork", false, 800, Dish1.Type.MEAT),
				new Dish1("beef", false, 700, Dish1.Type.MEAT),
				new Dish1("chicken", false, 400, Dish1.Type.MEAT),
				new Dish1("french fries", true, 530, Dish1.Type.OTHER),
				new Dish1("rice", true, 350, Dish1.Type.OTHER),
				new Dish1("season fruit", true, 120, Dish1.Type.OTHER),
				new Dish1("pizza", true, 550, Dish1.Type.OTHER),
				new Dish1("prawns", false, 300, Dish1.Type.FISH),
				new Dish1("salmon", false, 450, Dish1.Type.FISH) );
		
		return menu;
	}
}
