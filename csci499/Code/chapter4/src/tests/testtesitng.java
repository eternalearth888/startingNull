package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import exercises.LinkedList;

public class testtesitng {
//
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
//	

	@Test
	public void testConcatenate() {
		LinkedList<Character> ll = new LinkedList<Character>();
		ll.append('a');
		ll.append('b');
		LinkedList<Character> l2 = new LinkedList<Character>();
		l2.append('c');
		l2.append('d');
//		ll.concatenate(l2);
//		assert (ll.testListContents(new Character[] { 'a', 'b', 'c', 'd' }));
	}

}
