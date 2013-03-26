package tests;


import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

import exercises.variableLength;

public class TestVariableLength {
	public static char NULL = '\0';
	
	
	variableLength v;
	
	@Before
	public void setup() {
		v = new variableLength();
	}
	
	@Test
	public void testConcatenateAppend() {
		String first = "Harry Potter ";
		String second = "and the Sorcerer's Stone ";
		String expected = first + second;
		String actual = v.concatenateAppend(first, second);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCreateArray() {
		String input = "JK Rowling";
		char[] expected = input.toCharArray();
		char[] actual = v.createArray(input);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	// The character at that position doesn't exist
	@Test
	public void testCharacterAtBad() {
		String originalStr = "Draco ";
		char[] original = originalStr.toCharArray();
		original[original.length-1] = NULL;
		Assert.assertNotSame('x', v.characterAt(original, 3));
	}
	
	// The character is out of bounds
	@Test (expected = RuntimeException.class)
	public void testCharacterAtOutOfBounds() {
		String originalStr = "Lucius ";
		char[] original = originalStr.toCharArray();
		original[original.length-1] = NULL;
		assertEquals('u', v.characterAt(original, 7));
	}
	
	// The character at that position exists
	@Test
	public void testCharacterAtGood() {
		String originalStr = "Ginny ";
		char[] original = originalStr.toCharArray();
		original[original.length-1] = NULL;
		assertEquals('G', v.characterAt(original, 0));
	}
	
	// Remove characters from array
	@Test
	public void testRemoveCharGood() {
		String originalStr = "Dumbledore ";
		char[] original = originalStr.toCharArray();
		original[original.length-1] = NULL;
		String removeStr = "Dumblere ";
		char[] remove = removeStr.toCharArray();
		remove[remove.length-1] = NULL;
	    assertEquals(remove, v.removeChar(original, 6, 2));	
	}
}