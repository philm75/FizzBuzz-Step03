package com.mcs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Phil
 * Sep 5, 2017
 * Description - Unit tests for FizzBuzz
 */
public class FizzBuzzTest {

	@Test
	public void testValidRange() {
		FizzBuzz fizzBuzz = new FizzBuzz(1, 20);	
		fizzBuzz.go();
	}
	
	@Test
	@SuppressWarnings("unused")
	public void testInvalidMinRange() {
		try {
			FizzBuzz fizzBuzz = new FizzBuzz(-1, 10);			
		} catch (IllegalArgumentException e) {
			assertEquals("Minimum Range must be 0 or greater - -1", e.getMessage());
		}
	}
	
	@Test
	@SuppressWarnings("unused")
	public void testInvalidMaxRange() {
		try {			
			FizzBuzz fizzBuzz = new FizzBuzz(10, 2);			
		} catch (IllegalArgumentException e) {
			assertEquals("Maximum Range must be greater than the Minimum Range - 2", e.getMessage());
		}		
	}
}
