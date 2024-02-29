package com.venkat.records;

import java.util.LinkedList;
import java.util.List;

public class RecordDemo {
	
	record Range(int begin, int end, List<Integer> values) {
		
		Range(int begin, int end, List<Integer> values ) {
			this.begin = begin;
			this.end = end;
			this.values= List.copyOf(values);// creates immutable copy of list 
		}
	}
	
	record Range1(int begin, int end) {
		
		Range1{
			if(end < begin) {
				throw new IllegalStateException("End should be greater than begin");
			}
		}
		
		Range1(int end){
			this(0,end);// you can't create constructor without calling canonical constructor
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(4);
		Range range = new Range(0,4,list);
		System.out.println("range = " + range);
		System.out.println("begin = " + range.begin());
		
		
		

		Range1 range1 = new Range1(0,4);
		System.out.println("range = " + range1);
		System.out.println("begin = " + range1.begin());
		
		
		
		
		
		
		
	}
}
