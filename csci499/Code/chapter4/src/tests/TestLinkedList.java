package tests;

import static org.junit.Assert.*;

import exercises.LinkedList;
import exercises.Node;
import org.junit.Test;

public class TestLinkedList<T> {
	// T = data type, e.g., int, char

	public Node head;

	public boolean testListContents(T[] values) {
		// handle case where both are empty
		if (head == null && values == null)
			return true;
		Node<T> curr = head;
		int ix = 0;
		while (curr != null) {
			// handle case where list has more value than array
			if (ix > values.length)
				return false;
			// handle case where values don't match
			if (curr.data != values[ix])
				return false;
			// move to next element in both list and array
			curr = curr.next;
			ix++;
		}
		// handle case where array has more elements than list
		if (ix < values.length)
			return false;
		// we've handled all errors, so we must match
		return true;
	}

	@Test
	public void testConcatenate() {
		LinkedList<Character> ll = new LinkedList<Character>();
		ll.append('a');
		ll.append('b');
		LinkedList<Character> l2 = new LinkedList<Character>();
		l2.append('c');
		l2.append('d');
		ll.concatenate(l2);
		assert (ll.testListContents(new Character[] { 'a', 'b', 'c', 'd' }));
	}
}