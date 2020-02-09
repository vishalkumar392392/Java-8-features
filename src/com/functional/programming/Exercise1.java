package com.functional.programming;

import java.util.Comparator;
import java.util.List;

public class Exercise1 {
	
	public static void main(String args[]) {
		
		List<Integer> list = List.of(5,3,7,2,9,3,8,12,4);
		List<String> course = List.of("spring","boot","microservices","aws","react","docker","jpa and hibernate","lamdas and functional");
		printOddNumbers(list);
		printCourse(course);
		printCourseContainsSpring(course);
		printCourseHasFourLetters(course);
		printOfSquaresOfNumbers(list);
		printTheCubesOfOddNumbers(list);
		printSumOfSquaresOfEvenNumbers(list);
		printTheNumberOfCharactersInCourse(course);
		printMaxNumberInList(list);
		printDistinct(list);
		printSorted(list);
		printSortedCourse(course);

	}
	
	private static void printSortedCourse(List<String> course) {
		
		course.stream()
		.sorted(Comparator.naturalOrder());
	}

	private static void printSorted(List<Integer> list) {

		list.stream().sorted()
		.forEach(i->System.out.print(i+" "));
		
		list.stream().sorted(Comparator.reverseOrder())
		.forEach(i->System.out.print(i+" "));
	}

	private static void printDistinct(List<Integer> list) {

		list.stream().distinct().forEach(System.out::println);
	}

	private static void printMaxNumberInList(List<Integer> list) {

      System.out.println(list.stream().max(Integer::compare));
	
	}

	private static void printTheNumberOfCharactersInCourse(List<String> course) {

		course.stream()
		.map(i->i.length())
		.forEach(System.out::println);
	}

	private static void printTheCubesOfOddNumbers(List<Integer> list) {

		list.stream().filter(i->i%2!=0)
		.map(i->i*i*i)
		.forEach(System.out::println);
		
	}

	private static void printSumOfSquaresOfEvenNumbers(List<Integer> list) {

		int sum = list.stream()
		            .filter(i->i%2==0)
		            .map(i->i*i)
		            .reduce(0,Integer::sum); //reduce(0,(c,e)->c+e)
		
		System.out.println(sum);
		            
	}

	private static void printOfSquaresOfNumbers(List<Integer> list) {

		list.stream().map(i->i*i).forEach(System.out::println);
	}

	private static void printCourseHasFourLetters(List<String> course) {

		course.stream().filter(i->i.length()==4).forEach(i->System.out.println(i));
	}

	public static boolean course(String course) {
		return course.equalsIgnoreCase("spring");
	}

	private static void printCourseContainsSpring(List<String> course) {

		course.stream().filter(Exercise1::course).forEach(System.out::println); // method reference
		
		course.stream().filter(i->i.equalsIgnoreCase("spring")).forEach(i->System.out.println(i+" ")); // lamda expression
	}

	private static void printCourse(List<String> course) {
        
		course.stream().forEach(System.out::println);
	}

	private static void printOddNumbers(List<Integer> list) {
		list.stream().filter(i->i%2!=0).forEach(System.out::print);
	}

}
