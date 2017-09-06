package com.mcs;

import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * @author Phil Merrilees
 * Sep 5, 2017
 * Description - "FizzBuzz" program
 */
public class FizzBuzz {

	/**
	 * Minimum range value.
	 */
	private final int minRange;
	
	/**
	 * Maximum range value.
	 */
	private final int maxRange;

	/**
	 * Counters.
	 */
	private int fizzCtr;	
	private int buzzCtr;
	private int fizzbuzzCtr;
	private int luckCtr;
	private int numberCtr;
	
	/**
	 * Exception messages.
	 */
	private static final String MIN_RANGE_ERROR = "Minimum Range must be 0 or greater - %s";
	private static final String MAX_RANGE_ERROR = "Maximum Range must be greater than the Minimum Range - %s";
	
	/**
	 * Output messages.
	 */
	private static final String FIZZ = "fizz";
	private static final String BUZZ = "buzz";
	private static final String LUCK = "luck";
	private static final String	FIZZBUZZ = "fizzbuzz";
	private static final String	NUMBER = "number";
	
	/**
	 * @param minRange
	 * @param maxRange
	 */
	public FizzBuzz(int minRange, int maxRange) {
        if (minRange < 0) {
            throw new IllegalArgumentException(String.format(MIN_RANGE_ERROR, String.valueOf(minRange)));
        }
        if (minRange > maxRange) {
            throw new IllegalArgumentException(String.format(MAX_RANGE_ERROR, String.valueOf(maxRange)));
        }
		this.minRange = minRange;
		this.maxRange = maxRange;
		this.fizzCtr = 0;	
		this.buzzCtr = 0;
		this.fizzbuzzCtr = 0;
		this.luckCtr = 0;
		this.numberCtr = 0;
	}
	
	public void go() {
		Iterator<Integer> it = IntStream.rangeClosed(minRange, maxRange).iterator();
		while (it.hasNext()) {
			System.out.print(output(it.next()));
		}
		outputTotals();
	}
	
	private void outputTotals() {
		System.out.println("\n" + outputTotalLine(FIZZ, fizzCtr));
		System.out.println(outputTotalLine(BUZZ, buzzCtr));
		System.out.println(outputTotalLine(FIZZBUZZ, fizzbuzzCtr));
		System.out.println(outputTotalLine(LUCK, luckCtr));
		System.out.println(outputTotalLine(NUMBER, numberCtr));
	}
	
	private String outputTotalLine(String heading, int total) {
		return new StringBuilder(heading).append(": ").append(String.valueOf(total)).toString();
	}
	
	private String output(Integer value) {
		StringBuilder output = new StringBuilder();
		boolean isDivisable = false;
		if (isDivisableBy(value, 3) && !containsAThree(value)) {
			output.append(FIZZ);
			isDivisable = true;
		}
		
		if (isDivisableBy(value, 5) && !containsAThree(value)) {
			output.append(BUZZ);
			isDivisable = true;
		}

		if (isDivisableBy(value, 3) && !isDivisableBy(value, 5) && !containsAThree(value)) {
			fizzCtr++;
		}

		if (!isDivisableBy(value, 3) && isDivisableBy(value, 5) && !containsAThree(value)) {
			buzzCtr++;
		}
		
		if (isDivisableBy(value, 3) && isDivisableBy(value, 5)) {
			fizzbuzzCtr++;
		}
		
		if (!isDivisable && !containsAThree(value)) {
			output.append(String.valueOf(value));
			numberCtr++;
		}
		
		if (containsAThree(value)) {
			output.append(LUCK);
			luckCtr++;
		}		
		output.append(" ");
		return output.toString();
	}
	
	private static boolean containsAThree(int value) {
		return String.valueOf(value).contains("3");
	}
	
	private static boolean isDivisableBy(int value, int divider) {
		return (value % divider == 0);
	}

	/**
	 * Program entry point.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FizzBuzz fizzBuzz = new FizzBuzz(1, 20);
		fizzBuzz.go();
	}
}