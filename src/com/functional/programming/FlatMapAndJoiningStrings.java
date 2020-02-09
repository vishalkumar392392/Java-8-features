package com.functional.programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapAndJoiningStrings {

	public static void main(String[] args) {

		List<String> names = List.of("vishal", "loves", "nobody", "because", "noone", "deserves", "him");

		List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));

		List<Course> courses2 = List.of(new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));

		String finalString = names.stream().collect(Collectors.joining(" "));
		System.out.println(finalString);

		System.out
				.println(names.stream().map(name -> name.split("")).flatMap(Arrays::stream).collect(Collectors.toList())

				);

		System.out.println(names.stream().map(name -> name.split("")).flatMap(Arrays::stream).distinct()
				.collect(Collectors.toList())

		);

		System.out.println(

				courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2))).collect(Collectors.toList()));

	}

}
