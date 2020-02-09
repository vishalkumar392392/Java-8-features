package com.functional.programming;

import java.util.ArrayList;
import java.util.List;

public class RemoveIf {

	public static void main(String[] args) {

		List<String> course = List.of("spring","boot","microservices","aws","react","docker","jpa and hibernate","lamdas and functional");

		List<String> modifiedList = new ArrayList<>(course);
		
		modifiedList.replaceAll(str->str.toUpperCase());
		modifiedList.stream().forEach(System.out::println);
	}

}
