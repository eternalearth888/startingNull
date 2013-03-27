package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import exercises.Strings;




public class TestStrings {
	public static char NULL = '\0';

	//	public void printCharArray(char[] arr) {
	//		for (int i = 0; i < arr.length; ++i) {
	//			System.out.print(arr[i]);
	//		}
	//		System.out.println("");
	//	}
	//	printCharArray(expected);
	//	printCharArray(actual);

	@Test
	public void testSubstring1() {
		char[] original = {'h', 'e', 'l', 'l','o', ' ', 'w', 'o', 'r', 'l', 'd'};
		char[] expected = {'w', 'o', 'r', 'l', 'd'};
		char[] actual = Strings.ex4_2_substring(original, 6, 5);
//		int[] nums  = {1, 2, 3};
//		int[] num2 = {1, 2, 3};
		assertTrue(Arrays.equals(expected, actual));
	}
	@Test
	public void testSubstring2() {
		char[] original = {'h', 'e', 'l', 'l','o', ' ', 'w', 'o', 'r', 'l', 'd'};
		char[] expected = {'h'};
		char[] actual = Strings.ex4_2_substring(original, 0, 1);
		assertTrue(Arrays.equals(expected, actual));
	}

	// Test where we don't want to remove anything
	@Test
	public void testSubstring3() {
		char[] original = {'h', 'e', 'l', 'l','o', ' ', 'w', 'o', 'r', 'l', 'd'};
		char[] expected = {};
		char[] actual = Strings.ex4_2_substring(original, 0, 0);
		assertTrue(Arrays.equals(expected,actual));
	}
	
	// Test where we remove everything
	@Test
	public void testSubstring4() {
		char[] original = {'h', 'e', 'l', 'l','o', ' ', 'w', 'o', 'r', 'l', 'd'};
		char[] expected = {'h', 'e', 'l', 'l','o', ' ', 'w', 'o', 'r', 'l', 'd'};
		char[] actual = Strings.ex4_2_substring(original, 0, 11);
		assertTrue(Arrays.equals(expected,actual));
	}
	
	
	@Test
	public void test() {
		String originalStr = "I love C++ and cats but C++ doesn't love me";
		char[] original = originalStr.toCharArray();
		String expectedStr = "I love Java and cats but Java doesn't love me";
		char[] expected = expectedStr.toCharArray();
		char[] target = {'C', '+', '+' };
		char[] replaceText = {'J', 'a', 'v', 'a' };
		char[] actual = Strings.ex4_3_replaceStr(original, target, replaceText);
		assertTrue(Arrays.equals(expected, actual));
	}
	@Test
	public void testSimpleReplace() {
		String originalStr = "C++";
		char[] original = originalStr.toCharArray();
		String expectedStr = "Java";
		char[] expected = expectedStr.toCharArray();
		char[] target = {'C', '+', '+' };
		char[] replaceText = {'J', 'a', 'v', 'a' };
		char[] actual = Strings.ex4_3_replaceStr(original, target, replaceText);
		assertTrue(Arrays.equals(expected, actual));
	}
	@Test
	public void testNoReplace() {
		String originalStr = "c++";
		char[] original = originalStr.toCharArray();
		String expectedStr = "c++";
		char[] expected = expectedStr.toCharArray();
		char[] target = {'C', '+', '-' };
		char[] replaceText = {'J', 'a', 'v', 'a' };
		char[] actual = Strings.ex4_3_replaceStr(original, target, replaceText);
		assertTrue(Arrays.equals(expected, actual));
	}

	@Test
	public void testIsTarget() {
		//  01234567890123456789012345678901234567890  
		String originalStr = "cat of black and a white cat and orange cat";
		char[] original = originalStr.toCharArray();
		char[] target = {'c', 'a', 't' };
		assertTrue(Strings.isTarget(original, 0, target));
		assertTrue(Strings.isTarget(original, 25, target));
		assertTrue(Strings.isTarget(original, 40, target));
		assertFalse(Strings.isTarget(original, 2, target));
	}

	@Test
	public void testCharAt() {
		String originalStr = "cat ";
		char[] original = originalStr.toCharArray();
		original[original.length-1] = NULL;
		assertEquals('c', Strings.ex4_4_charAt(original, 0));
		assertEquals('a', Strings.ex4_4_charAt(original, 1));
		assertEquals('t', Strings.ex4_4_charAt(original, 2));			
	}

	@Test (expected = RuntimeException.class)
	public void testCharAtBad() {
		String originalStr = "cat ";
		char[] original = originalStr.toCharArray();
		original[original.length-1] = NULL;
		assertEquals('x', Strings.ex4_4_charAt(original, 3));
	}

	@Test
	public void testConcatenate() {
		String originalStr = "cat ";
		char[] original = originalStr.toCharArray();
		original[original.length-1] = NULL;
		String secondStr = "dog ";
		char[] second = secondStr.toCharArray();
		second[second.length-1] = NULL;
		char[] actual = Strings.ex4_4_concatenate(original, second);
		String expectedStr = "catdog ";
		char[] expected = expectedStr.toCharArray();
		expected[expected.length-1] = NULL;
		assertTrue(Arrays.equals(expected, actual));
	}

	// Test where the first list is empty and the second isn't
	@Test
	public void testConcatenate2() {
		String originalStr = "  ";
		char[] original = originalStr.toCharArray();
		original[original.length-1] = NULL;
		String secondStr = "dog ";
		char[] second = secondStr.toCharArray();
		second[second.length-1] = NULL;
		char[] actual = Strings.ex4_4_concatenate(original, second);
		String expectedStr = " dog ";
		char[] expected = expectedStr.toCharArray();
		expected[expected.length-1] = NULL;
		assertTrue(Arrays.equals(expected,actual));
	}

	// Test where the second list is empty the first isn't
	@Test
	public void testConcatenate3() {
		String originalStr = "cat ";
		char[] original = originalStr.toCharArray();
		original[original.length-1] = NULL;
		String secondStr = "  ";
		char[] second = secondStr.toCharArray();
		second[second.length-1] = NULL;
		char[] actual = Strings.ex4_4_concatenate(original, second);
		String expectedStr = "cat  ";
		char[] expected = expectedStr.toCharArray();
		expected[expected.length-1] = NULL;
		assertTrue(Arrays.equals(expected,actual));

	}

	// Test where both lists are empty
	@Test
	public void testConcatenate4() {
		String originalStr = "  ";
		char[] original = originalStr.toCharArray();
		original[original.length-1] = NULL;
		String secondStr = "  ";
		char[] second = secondStr.toCharArray();
		second[second.length-1] = NULL;
		char[] actual = Strings.ex4_4_concatenate(original, second);
		String expectedStr = "   ";
		char[] expected = expectedStr.toCharArray();
		expected[expected.length-1] = NULL;
		assertTrue(Arrays.equals(expected,actual));

	}

}
