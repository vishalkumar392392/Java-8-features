package com.functional.programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student{
	private int id;
	private String name;
	private String email;
	private int marks;
	public Student(int id, String name, String email, int marks) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.marks = marks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", marks=" + marks + "]";
	}
	
	
}

class Toppers{
	
	private List<Student> listStudents = new ArrayList<Student>();
	public void setStudents(Student student) {
		listStudents.add(student);
	}
	@Override
	public String toString() {
		return "Toppers [listStudents=" + getListStudents() + "]";
	}
	public List<Student> getListStudents() {
		return listStudents;
	}
	

}



public class CustomClassPractice {

	static Toppers toppers;
	public static void main(String[] args) {
		
		List<Student> students = List.of(
				new Student(101,"vishal","vishal@gmail.com",966),
				new Student(102,"vikas","vikas@gmail.com",900),
				new Student(103,"tanuja","tanuja@gmail.com",966),
				new Student(104,"hari","hari@gmail.com",920));
		
		Comparator<Student> comparator = Comparator.comparing(Student::getMarks).reversed().thenComparing(Student::getName);
		System.out.println(students.stream().sorted(comparator).collect(Collectors.toList()));
	
		students.stream().filter(student->student.getMarks()>950)
		.map(student->{
			 toppers = new Toppers();
			toppers.setStudents(student);
			return student;
		}).forEach(System.out::println);;
		
		System.out.println(toppers);

	}
	
	

}
