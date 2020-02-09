package com.functional.programming;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", category=" + category + ", reviewScore=" + reviewScore + ", noOfStudents="
				+ noOfStudents + "]";
	}

}

public class CustomClass {

	
	public static void main(String[] args) {

		List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));

		Predicate<? super Course> reviewVariableGreaterThan90Prediacte = course -> course.getReviewScore() > 90;

		Predicate<? super Course> reviewVariableGreaterThan96Prediacte = course -> course.getReviewScore() > 96;

		Predicate<? super Course> reviewVariableGreaterThan100Prediacte = course -> course.getReviewScore() > 100;

		System.out.println(courses.stream().allMatch(reviewVariableGreaterThan90Prediacte));
		System.out.println(courses.stream().noneMatch(reviewVariableGreaterThan100Prediacte));
		System.out.println(courses.stream().anyMatch(reviewVariableGreaterThan90Prediacte));

		Comparator<Course> comparator = Comparator.comparing(Course::getNoOfStudents);

		Comparator<Course> comparingByNoOfStudentsAndReviewScore = Comparator.comparing(Course::getNoOfStudents)
				.thenComparing(Course::getReviewScore);

		Comparator<Course> comparator2 = Comparator.comparing(Course::getName);

		System.out.println(courses.stream().sorted(comparator.reversed()).collect(Collectors.toList()));

		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsAndReviewScore.reversed()).collect(Collectors.toList()));

		System.out.println(courses.stream().sorted(comparator2.reversed()).collect(Collectors.toList()));

		System.out.println(courses.stream().sorted(comparator2.reversed()).limit(5).collect(Collectors.toList()));

//				[Course [name=Spring Boot, category=Framework, reviewScore=95, noOfStudents=18000], Course [name=Spring, category=Framework, reviewScore=98, noOfStudents=20000], Course [name=Microservices, category=Microservices, reviewScore=96, noOfStudents=25000], Course [name=Kubernetes, category=Cloud, reviewScore=91, noOfStudents=20000], Course [name=FullStack, category=FullStack, reviewScore=91, noOfStudents=14000]]

		System.out.println(courses.stream().sorted(comparator2.reversed()).skip(3).collect(Collectors.toList()));

		System.out
				.println(courses.stream().sorted(comparator2.reversed()).skip(3).limit(5).collect(Collectors.toList()));

		System.out.println(courses);

		// [Course [name=Spring, category=Framework, reviewScore=98,
		// noOfStudents=20000],
		// Course [name=Spring Boot, category=Framework, reviewScore=95,
		// noOfStudents=18000],
		// Course [name=API, category=Microservices, reviewScore=97,
		// noOfStudents=22000],
		// Course [name=Microservices, category=Microservices, reviewScore=96,
		// noOfStudents=25000],
		// Course [name=FullStack, category=FullStack, reviewScore=91,
		// noOfStudents=14000],
		// Course [name=AWS, category=Cloud, reviewScore=92, noOfStudents=21000],
		// Course [name=Azure, category=Cloud, reviewScore=99, noOfStudents=21000],
		// Course [name=Docker, category=Cloud, reviewScore=92, noOfStudents=20000],
		// Course [name=Kubernetes, category=Cloud, reviewScore=91, noOfStudents=20000]]

		System.out.println(

				courses.stream().takeWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList()));

		System.out.println(
				courses.stream().dropWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList()));

		courses.stream().filter(course -> course.getNoOfStudents() >= 25000).forEach(System.out::println);
		System.out.println(courses.stream().max(comparingByNoOfStudentsAndReviewScore));

		System.out.println(courses.stream().filter(reviewVariableGreaterThan96Prediacte)
				.min(comparingByNoOfStudentsAndReviewScore));

		System.out.println(courses.stream().filter(reviewVariableGreaterThan100Prediacte)
				.min(comparingByNoOfStudentsAndReviewScore).orElse(new Course("Kubernetes", "Cloud", 91, 20000)));

		System.out.println(courses.stream().filter(reviewVariableGreaterThan90Prediacte).findFirst());
		System.out.println(courses.stream().filter(reviewVariableGreaterThan90Prediacte).findAny());

		System.out.println(
				courses.stream().filter(reviewVariableGreaterThan90Prediacte).mapToInt(Course::getNoOfStudents).sum());

		System.out.println(courses.stream().mapToInt(Course::getNoOfStudents).average());

		System.out.println(courses.stream().filter(reviewVariableGreaterThan90Prediacte)
				.mapToInt(Course::getNoOfStudents).count());

		System.out.println(
				courses.stream().filter(reviewVariableGreaterThan90Prediacte).mapToInt(Course::getNoOfStudents).max());

		System.out.println(
				courses.stream().filter(reviewVariableGreaterThan90Prediacte).mapToInt(Course::getNoOfStudents).min());

		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory))

		);

		Map<String, List<Course>> hashmap = courses.stream().collect(Collectors.groupingBy(Course::getCategory));

        hashmap.forEach((key, value) -> System.out.println("[Key] : " + key + " [Value] : " + value));

		hashmap.forEach((key, value) -> System.out.println("[KEY] : " + key + "[VALUE] :" + value));
		
		for(Map.Entry<String,List<Course>> entry :hashmap.entrySet()) {
			System.out.println(" Key ::" +entry.getKey()+" value :: "+entry.getValue());
		}

		
		 System.out.println(
		  courses.stream()
		  .collect(Collectors.groupingBy(Course::getCategory,Collectors.counting()))
		  );
		 
		 Map<String, Optional<Course>> map = courses.stream()
		 .collect(Collectors.groupingBy(Course::getCategory,
				 Collectors.maxBy(Comparator.comparing(Course::getReviewScore))));	 
		 
		 map.forEach((key,value)->System.out.println("Category :: "+key +", value : "+value));
		 
		 System.out.println(
				 courses.stream()
				 .collect(Collectors.groupingBy(Course::getCategory,
						 Collectors.mapping(Course::getName, Collectors.toList()))));
		
		  //Key ::Cloud value :: [Course [name=AWS, category=Cloud, reviewScore=92, noOfStudents=21000], Course [name=Azure, category=Cloud, reviewScore=99, noOfStudents=21000], Course [name=Docker, category=Cloud, reviewScore=92, noOfStudents=20000], Course [name=Kubernetes, category=Cloud, reviewScore=91, noOfStudents=20000]]
	     // Key ::FullStack value :: [Course [name=FullStack, category=FullStack, reviewScore=91, noOfStudents=14000]]
		// Key ::Microservices value :: [Course [name=API, category=Microservices, reviewScore=97, noOfStudents=22000], Course [name=Microservices, category=Microservices, reviewScore=96, noOfStudents=25000]]
		// Key ::Framework value :: [Course [name=Spring, category=Framework, reviewScore=98, noOfStudents=20000], Course [name=Spring Boot, category=Framework, reviewScore=95, noOfStudents=18000]]

		 System.out.println(
				 courses.stream()
				 .collect(Collectors.groupingBy(Course::getCategory,
						 Collectors.summarizingInt(Course::getNoOfStudents))));
		 
		Map<String, IntSummaryStatistics> mapGroupBy = courses.stream()
		 .collect(Collectors.groupingBy(Course::getCategory,
				 Collectors.summarizingInt(Course::getNoOfStudents)));
		
		mapGroupBy.forEach((key,value)->System.out.println("{}"+key+"-> "+value.getSum()));
		
	}

}
