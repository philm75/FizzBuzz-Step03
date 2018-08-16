package com.equalexperts.fb;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.equalexperts.fb.FizzBuzz;

/**
 * Description - Unit tests for FizzBuzz - Step 03.
 *
 */
public class FizzBuzzTest {

	@Test
	public void testValidRangeArguments() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		final PrintStream originalOutput = System.out;
		
		System.setOut(new PrintStream(outContent));
				
		FizzBuzz fizzBuzz = new FizzBuzz(1, 20);	
		fizzBuzz.run();
		
		assertEquals("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz fizz: 4 buzz: 3 fizzbuzz: 1 lucky: 2 integer: 10", outContent.toString());
		
		System.setOut(originalOutput);		
	}
	
	@Test
	public void testIllegalMinRangeArgument() {
		try {
			new FizzBuzz(-1, 10);			
		} catch (IllegalArgumentException e) {
			assertEquals("Minimum Range must be 0 or greater - -1", e.getMessage());
		}
	}
	
	@Test
	public void testIllegalMaxRangeArgument() {
		try {			
			new FizzBuzz(10, 2);			
		} catch (IllegalArgumentException e) {
			assertEquals("Maximum Range must be greater than the Minimum Range - 2", e.getMessage());
		}		
	}
}
