package com.functional.programming;

import java.util.stream.LongStream;

public class Parallelism {

	public static void main(String[] args) {

		long time = System.currentTimeMillis();
		
		System.out.println(LongStream.range(1, 40000000).sum());
		
		
		System.out.println(System.currentTimeMillis() -time);
		
		
long time1 = System.currentTimeMillis();
		
		System.out.println(LongStream.range(1, 40000000).parallel().sum());
		
		
		System.out.println(System.currentTimeMillis() -time1);
	}

}
