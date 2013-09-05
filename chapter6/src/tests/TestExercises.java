package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import exercises.Exercises;

public class TestExercises {

	@Test
	public void testex6_1_iteration() {
		int correct[] = { -1, 2, 0, 4, -6, 10 };
		int expectedC = 16;
		assertEquals(expectedC, Exercises.ex6_1_iterative(correct));
		int incorrect[] = { -3, 4, 5 };
		int expectedI = 5;
		assertNotSame(expectedI, Exercises.ex6_1_iterative(incorrect));
		int nothing[] = { -10, -7, -8, 0, 0, -9 };
		int expectedN = 0;
		assertEquals(expectedN, Exercises.ex6_1_iterative(nothing));
		int base[] = {};
		int expectedB = 0;
		assertEquals(expectedB, Exercises.ex6_1_iterative(base));
	}

	@Test
	public void testex6_1_recursive() {
		int correct[] = { -1, 2, 0, 4, -6, 10 };
		int expectedC = 16;
		assertEquals(expectedC, Exercises.ex6_1_recursive(correct, 0));
		int incorrect[] = { -3, 4, 5 };
		int expectedI = 5;
		assertNotSame(expectedI, Exercises.ex6_1_recursive(incorrect, 0));
		int nothing[] = { -10, -7, -8, 0, 0, -9 };
		int expectedN = 0;
		assertEquals(expectedN, Exercises.ex6_1_recursive(nothing, 0));

	}

	@Test
	public void testex6_2_iterative() {
		String odd[] = { "0", "1", "0" };
		assertTrue(Exercises.ex6_2_iterative(odd));
		String even[] = { "1", "0", "1"};
		assertFalse(Exercises.ex6_2_iterative(even));
		String blank[] = {};
		assertFalse(Exercises.ex6_2_iterative(blank));
		String none[] = { "0", "0", "0"};
		assertFalse(Exercises.ex6_2_iterative(none));
	}
	
	@Test
	public void testex6_2_recursive() {
		String odd[] = { "0", "1", "0" };
		assertTrue(Exercises.ex6_2_recursive(odd, 0, 0));
		String even[] = { "1", "0", "1"};
		assertFalse(Exercises.ex6_2_recursive(even, 0, 0));
		String blank[] = {};
		assertFalse(Exercises.ex6_2_recursive(blank, 0, 0));
		String none[] = { "0", "0", "0"};
		assertFalse(Exercises.ex6_2_recursive(none, 0, 0));
	}

	@Test
	public void testex6_3_iteration() {
		int correct[] = { -1, 2, 0, 4, 2, 2 };
		int expectedC = 3;
		assertEquals(expectedC, Exercises.ex6_3_iterative(correct, 2));
		int incorrect[] = { -3, 4, 5 };
		int expectedI = 5;
		assertNotSame(expectedI, Exercises.ex6_3_iterative(incorrect, 5));
		int nothing[] = { -10, -7, -8, 0, 0, -9 };
		int expectedN = 0;
		assertEquals(expectedN, Exercises.ex6_3_iterative(nothing, 5));
		int base[] = {};
		int expectedB = 0;
		assertEquals(expectedB, Exercises.ex6_3_iterative(base, 5));
	}

	@Test
	public void testex6_3_recursive() {
		int correct[] = { -1, 2, 0, 4, 2, 2 };
		int expectedC = 3;
		assertEquals(expectedC, Exercises.ex6_3_recursive(correct, 2, 0));
		int incorrect[] = { -3, 4, 5 };
		int expectedI = 5;
		assertNotSame(expectedI, Exercises.ex6_3_recursive(incorrect, 5, 0));
		int nothing[] = { -10, -7, -8, 0, 0, -9 };
		int expectedN = 0;
		assertEquals(expectedN, Exercises.ex6_3_recursive(nothing, 5, 0));
		int base[] = {};
		int expectedB = 0;
		assertEquals(expectedB, Exercises.ex6_3_recursive(base, 5, 0));
	}
}
