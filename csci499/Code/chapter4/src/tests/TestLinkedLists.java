package tests;

import org.junit.Test;

import exercises.LinkedLists;
import exercises.Node;

public class TestLinkedLists {
	// T = data type, e.g., int, char
	

	public boolean testListContents(Object[] values) {
		// handle case where both are empty
		if (head == null && values == null)
			return true;
		Node curr = head;
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
		LinkedLists ll = new LinkedLists();
		ll.ex4_7_concatenateAppend('a');
		ll.ex4_7_concatenateAppend('b');
		LinkedLists l2 = new LinkedLists();
		l2.ex4_7_concatenateAppend('c');
		l2.ex4_7_concatenateAppend('d');
		ll.ex4_7_concatenateAppend(l2);
		assert(ll.testListContents(new Character[] {'a', 'b', 'c', 'd'}));
	}

}
