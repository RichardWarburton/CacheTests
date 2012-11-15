package com.insightfullogic;

public final class CachePrefetchingTest {

	private final int TIMES = 5;

	private final int[] someArray;

	public CachePrefetchingTest(final int size) {
		someArray = new int[size];
	}

	public void increment(final int skip) {
		for (int j = 0; j < TIMES; j++) {
			for (int i = 0; i < someArray.length; i += skip) {
				someArray[i]++;
			}
		}
	}

	public long time(final int skip) {
		final long time = System.currentTimeMillis();
		increment(skip);
		return System.currentTimeMillis() - time;
	}

	public static void main(final String[] args) {
		final int SIZE = 1024 * 1024 * 100;
		final int[] skips = { 1, 1, 1, 2, 4, 8, 16, 32, 64, 128 };
		final String format = "%10s, %10s\n";
		System.out.printf(format, "Skip", "Runtime (ms)");
		for (final int skip : skips) {
			final CachePrefetchingTest test = new CachePrefetchingTest(SIZE);
			System.out.printf(format, skip, test.time(skip));
		}
	}

}
