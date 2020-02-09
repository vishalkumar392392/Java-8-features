package com.functional.programming;

import java.util.List;

public class Functional_Class1 {

	public static void main(String[] args) {

		printAllElementsInOldWway(List.of(12, 45, 6, 9, 3, 2));
		System.out.println();

		printAllElementsInFunctionalWay(List.of(12, 45, 6, 9, 3, 2));
		System.out.println();

		printEvenNumberInList(List.of(12, 45, 6, 9, 3, 2));
	}

	public static void print(int num) {
		System.out.print(num + " ");
	}
	
	public static boolean isEven(int number) {
		return number%2==0;
	}

	private static void printAllElementsInFunctionalWay(List<Integer> list) {

		list.stream()
		.forEach(Functional_Class1::print);// method reference
		
		list.stream()
		.forEach(System.out::print);// method references

		list.stream()
		.forEach(i->System.out.println(i+" "));
	}
	
	private static void printEvenNumberInList(List<Integer> list) {

		System.out.println("even numbers in the list");
		
		list.stream()
		.filter(i->i%2==0)
		.forEach(i->System.out.println(i+" ")); // lamada expression

        list.stream()
        .filter(Functional_Class1::isEven)
        .forEach(i->System.out.println(i+" ")); // method refernce and lamda expression
	}

	private static void printAllElementsInOldWway(List<Integer> numbers) {

		for (Integer num : numbers) {

			System.out.print(num + " ");

		}
	}

}
