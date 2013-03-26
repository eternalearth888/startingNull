package tests;

import org.junit.Test;

import exercises.LinkedLists;
import exercises.Node;

public class TestLinkedLists {
	int T;

			public boolean testListContents(T[] values) {
		// handle case where both are empty
		if (head == null && values == null)
			return true;
		LLNode<T> curr = head;
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
		LL<Character> ll = new LL<Character>();
		ll.append('a');
		ll.append('b');
		LL<Character> l2 = new LL<Character>();
		l2.append('c');
		l2.append('d');
		ll.concatenate(l2);
		assert(ll.testListContents(new Character[] {'a', 'b', 'c', 'd'}));
	}

}