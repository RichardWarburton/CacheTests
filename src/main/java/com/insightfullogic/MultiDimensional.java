package com.insightfullogic;

import java.util.Random;

public class MultiDimensional {

	public static void main(String[] args) {
		int x = 100 * 1024 * 500;
		int y = 2;
		final int[][] array = allocate(x, y);

		for (int j = 0; j < 1000000; j++) {
			run(array);
		}

		System.out.println(array[new Random().nextInt(array.length - 1)]);
	}

	private static int[][] allocate(int x, int y) {
		int[][] array = new int[x][];
		for (int i = 0; i < x; i++) {
			array[i] = new int[y];
		}
		return array;
	}

	private static void run(final int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j]++;
			}
		}
	}

}
