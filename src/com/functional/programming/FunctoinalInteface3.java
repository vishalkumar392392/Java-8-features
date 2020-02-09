package com.functional.programming;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctoinalInteface3 {

	public static void main(String args[]) {

		List<Integer> list = List.of(5, 3, 7, 2, 9, 3, 8, 12, 4);

		Function<? super Integer, ? extends Integer> mapper = i -> i * i;

		extracted(list, i -> i * i);

	}

	private static void extracted(List<Integer> list, Function<? super Integer, ? extends Integer> mapper) {
		System.out.println(list.parallelStream().map(mapper).collect(Collectors.toList()));
	}

}
