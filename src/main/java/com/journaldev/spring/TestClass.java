package com.journaldev.spring;

public class TestClass {

	public static void main(String[] args) {
		int [] a = {10,10,10};
		int [] b = {20,20,20};
		
		m1(a,b);

	}
	
	public static void m1(int[]...x) {
		int count = 0;
		for(int[] x1:x) {
			for(int x2:x1) {
				count = count+x2;
			}
			System.out.println("sum is"+count);
			count = 0;
		}
	}

}
