package com.insightfullogic;

public class Simple {

	public static void main(String[] args) {
		int index = 100 * 1024 * 1024;
		final int[] someArray = new int[index];
		
		for (int increment = 1; increment < 16; increment *= 2) {
			System.out.println(increment);
			for (int j = 0; j < 100; j++) {			
				run(someArray, increment);
			}
		}

		System.out.println(someArray[index - 1]);
	}

	private static void run(final int[] someArray, int increment) {
		for (int i=0; i<someArray.length; i += increment) {
			someArray[i]++;
		}
	}

}
