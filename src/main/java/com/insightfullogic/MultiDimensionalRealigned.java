package com.insightfullogic;

import java.util.Random;

public class MultiDimensionalRealigned {

	public static void main(String[] args) {
		int x = 100 * 1024;
		int y = 1024;
		final int[] array = allocate(x, y);

		for (int j = 0; j < 1000000; j++) {
			run(array, x, y);
		}

		System.out.println(array[new Random().nextInt(array.length - 1)]);
	}

	private static int[] allocate(int ROWS, int COLS) {
		return new int[ROWS * COLS];
	}

	private static void run(final int[] array, int ROWS, int COLS) {
		for (int j = 0; j < COLS; j++) {
			for (int i = 0; i < ROWS; i++) {
				inc(array, i, j, COLS, ROWS);
			}
		}
	}

	private static void inc(final int[] array, int row, int col, int COLS, int ROWS) {
		// array[COLS * row + col]++; BAD
		array[ROWS * col + row]++; // GOOD
	}

}
