package com.venkat.streams;

import java.util.List;

public class StreamsPOC {

	public static void main(String[] args) {

		int[] factor = new int[] {2};
		var numbers = List.of(1,2,3);
		
		var stream=numbers.stream()
				.map(number -> number * factor[0]);
		
		factor[0] = 0;
		
		stream.forEach(System.out::print);
		
		// what is the out put of this code? 
		
		// functional programming relies on lazy evaluation for efficiency 
		// lazy evaluation relies on purity of functions 
		
		
		
		
		
		
		
		
	}
}















