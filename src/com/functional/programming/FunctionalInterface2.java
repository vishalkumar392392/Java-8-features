package com.functional.programming;

import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterface2 {
	
	public static void main(String args[]) {
		
		List<Integer> list = List.of(5,3,7,2,9,3,8,12,4);

		
		Predicate<? super Integer> evenPredicate = i->i%2==0;
		extracted(list, evenPredicate);
		
		
		Predicate<? super Integer> oddPredicate = i->i%2!=0;
		extracted(list, oddPredicate);
		
	}

	private static void extracted(List<Integer> list, Predicate<? super Integer> predicate) {
		list.stream()
        .filter(predicate)
        .map(i->i*i)
        .forEach(System.out::print);
	}

}
