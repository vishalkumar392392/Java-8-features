package com.functional.programming;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {
	
	public static void main(String arg[]) {
		
		System.out.println(IntStream.range(1, 10).sum());
		
		System.out.println(IntStream.rangeClosed(1, 10).sum());
		
		System.out.println(IntStream.iterate(1, e->e+2).limit(10).sum());
		
		System.out.println(IntStream.iterate(1, e->e+2).limit(10).peek(System.out::println).sum());
		
		System.out.println(IntStream.iterate(1, e->e+2).limit(10).boxed().collect(Collectors.toList()));
		
		System.out.println(IntStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply));


	}

}
