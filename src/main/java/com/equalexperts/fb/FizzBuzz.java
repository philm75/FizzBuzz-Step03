package com.equalexperts.fb;

import java.util.stream.IntStream;

/**
 * Description - "FizzBuzz" program - Step 3.
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
	private static final String LUCKY = "lucky";
	private static final String	FIZZBUZZ = "fizzbuzz";
	private static final String	NUMBER = "integer";
	
	private static final String TOTAL = " %s: %s";
	
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
	}
	
	public void run() {
		this.fizzCtr = 0;	
		this.buzzCtr = 0;
		this.fizzbuzzCtr = 0;
		this.luckCtr = 0;
		this.numberCtr = 0;
		
		IntStream.rangeClosed(minRange, maxRange).forEach(number -> {
			print(number);
		});
		printTotals();
	}
		
	private void printTotals() {
		System.out.print(String.format(TOTAL, FIZZ, String.valueOf(fizzCtr)));
		System.out.print(String.format(TOTAL, BUZZ, String.valueOf(buzzCtr)));
		System.out.print(String.format(TOTAL, FIZZBUZZ, String.valueOf(fizzbuzzCtr)));
		System.out.print(String.format(TOTAL, LUCKY, String.valueOf(luckCtr)));
		System.out.print(String.format(TOTAL, NUMBER, String.valueOf(numberCtr)));
	}
		
	private void print(Integer value) {
		boolean isDivisableByThree = (value % 3 == 0);
		boolean isDivisableByFive = (value % 5 == 0);
		boolean isDivisableByFifteen = (value % 15 == 0);
		boolean containsAThree = String.valueOf(value).contains("3");

		if (containsAThree) {
			System.out.print(LUCKY);
			this.luckCtr++;
		} else if (isDivisableByFifteen) {
			System.out.print(FIZZ);
			System.out.print(BUZZ);
			fizzbuzzCtr++;
		} else if (isDivisableByFive) {
			System.out.print(BUZZ);
			buzzCtr++;
		} else if (isDivisableByThree) {
			System.out.print(FIZZ);	
			fizzCtr++;
		} else {
			System.out.print(value);			
			numberCtr++;
		}
		
		if (value.intValue() < maxRange) {
			System.out.print(" ");			
		}
	}

	/**
	 * Program entry point.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FizzBuzz fizzBuzz = new FizzBuzz(30, 30);
		fizzBuzz.run();
		System.out.println("");
		fizzBuzz.run();
	}
}