package com.functional.programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterface {

	public static void main(String[] args) {

		List<Integer> list = List.of(5, 3, 7, 2, 9, 3, 8, 12, 4);

		printSquareEvenNumbers(list);

	}

	private static void printSquareEvenNumbers(List<Integer> list) {

		Function<? super Integer, ? extends Integer> mapper = i -> i * i;
		
		Consumer<Integer> action = System.out::print;
		
		Predicate<? super Integer> predicate = i -> i % 2 == 0;
		
		list.stream().filter(predicate).map(mapper).forEach(action);

	}

	public static void printSum(List<Integer> list) {

		BinaryOperator<Integer> accumulator = Integer::sum;

		list.stream().filter(i -> i % 2 == 0).map(i -> i * i).reduce(0, accumulator);
	}

}
