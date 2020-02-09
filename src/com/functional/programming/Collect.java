package com.functional.programming;

import java.util.List;
import java.util.stream.Collectors;

public class Collect {
	
	public static void main(String arg[]) {
		
		List<Integer> list = List.of(5,3,7,2,9,3,8,12,4);
		List<String> course = List.of("spring","boot","microservices","aws","react","docker","jpa and hibernate","lamdas and functional");


		List<Integer> doubleList = doubletheList(list);
		
		List<Integer> evenList = evenList(list);
		System.out.println(evenList);
		System.out.println(listWithLengthOfCourse(course));
	}

	private static List<Integer> listWithLengthOfCourse(List<String> course) {

		
		return course.stream().map(i->i.length()).collect(Collectors.toList());
	}

	private static List<Integer> evenList(List<Integer> list) {
		
		return list.stream().filter(num->num%2==0).collect(Collectors.toList());
	}

	private static List<Integer> doubletheList(List<Integer> list) {
		
		 list.stream().map(num->num*num).collect(Collectors.toList()).forEach(i->System.out.print(i+" "));
		 return list.stream().map(num->num*num).collect(Collectors.toList());
	}
	
	
	

}
