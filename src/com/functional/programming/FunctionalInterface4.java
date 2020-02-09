package com.functional.programming;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterface4 {

	public static void main(String[] args) {

		List<Integer> list = List.of(5, 3, 7, 2, 9, 3, 8, 12, 4);

		Supplier<Integer> supplier = ()->{
			
			Random random = new Random();
			return random.nextInt(100);
		};
		
		System.out.println(supplier.get());
		
		UnaryOperator<Integer> uni = x->3*x;
		
		System.out.println(uni.apply(10));
		
		BiPredicate<Integer,String> predicate = (number,string)->{
			
			return number>5&&string.length()>6;
		};
		
		System.out.println(predicate.test(10, "jasmine"));
		
		BiFunction<Integer,String,String> bipredicate = (number,string)->{
			
			return number+" "+string;
		};
		
		System.out.println(bipredicate.apply(176, "priyanka"));
		
		BiConsumer<String,String> biConsumer = (str1,str2)->{
			
			System.out.println(str1+" "+str2);
		};
		
		biConsumer.accept("vishal ", "vema");
	}

}
