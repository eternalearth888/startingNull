package tests;

import static org.junit.Assert.*;

import exercises.LinkedList;
import exercises.Node;
import org.junit.Test;

public class TestLinkedList {
	// T = data type, e.g., int, char

	// public Node<T> head;
	//
	// public boolean testListContents(T[] values) {
	// // handle case where both are empty
	// if (head == null && values == null)
	// return true;
	// Node<T> curr = head;
	// int ix = 0;
	// while (curr != null) {
	// // handle case where list has more value than array
	// if (ix > values.length)
	// return false;
	// // handle case where values don't match
	// if (curr.data != values[ix])
	// return false;
	// // move to next element in both list and array
	// curr = curr.next;
	// ix++;
	// }
	// // handle case where array has more elements than list
	// if (ix < values.length)
	// return false;
	// // we've handled all errors, so we must match
	// return true;
	// }

	@Test
	public void testInsertAtHead() {
		LinkedList<Character> ll = new LinkedList<Character>();
		ll.append('a');
		ll.append('b');
		ll.append('c');
		ll.append('d');
		ll.insertAtHead('z');
		assertTrue(ll.testListContents(new Character[] { 'z', 'a', 'b', 'c',
				'd' }));

		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.append(1);
		l2.append(2);
		l2.append(3);
		l2.insertAtHead(4);
		assertTrue(l2.testListContents(new Integer[] { 4, 1, 2, 3 }));

		LinkedList<Character> l3 = new LinkedList<Character>();
		l3.append('f');
		l3.append('a');
		l3.append('l');
		l3.append('s');
		l3.insertAtHead('e');
		assertFalse(l3.testListContents(new Character[] { 'f', 'a', 'l', 's',
				'e' }));
	}

	@Test
	public void testInsertAtTail() {
		LinkedList<Character> ll = new LinkedList<Character>();
		ll.append('a');
		ll.append('b');
		ll.append('c');
		ll.append('d');
		ll.insertAtTail('z');
		assertTrue(ll.testListContents(new Character[] { 'a', 'b', 'c', 'd',
				'z' }));

		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.append(1);
		l2.append(2);
		l2.append(3);
		l2.insertAtTail(4);
		assertTrue(l2.testListContents(new Integer[] { 1, 2, 3, 4 }));

		LinkedList<Character> l3 = new LinkedList<Character>();
		l3.append('f');
		l3.append('a');
		l3.append('l');
		l3.append('s');
		l3.insertAtTail('e');
		assertFalse(l3.testListContents(new Character[] { 'e', 'f', 'a', 'l',
				's' }));
	}

	@Test
	public void testCharacterAt() {
		LinkedList<Character> ll = new LinkedList<Character>();
		ll.append('D');
		ll.append('o');
		ll.append('b');
		ll.append('b');
		ll.append('y');
		assertTrue(ll.characterAt('y'));
		assertFalse(ll.characterAt('a'));
	}

	@Test
	public void testAppend() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.append(10);
		assertTrue(ll.characterAt(10));
		assertFalse(ll.characterAt(15));
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

	@Test
	public void testRemoveChar() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.append(5);
		ll.append(6);
		ll.append(7);
		ll.removeChar(2, 2);
		assertTrue(ll.testListContents(new Integer[] { 1, 2, 5, 6, 7 }));
	}

	@Test
	public void testRemoveDuplicate() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.append(2);
		ll.append(5);
		ll.removeDuplicate();
		assertTrue(ll.testListContents(new Integer[] { 1, 2, 3, 4, 5 }));
		assertFalse(ll.testListContents(new Integer[] { 1, 2, 3, 4, 2, 5 }));
	}

	@Test
	public void testInsert() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.insert(4);
		assertTrue(ll.testListContents(new Integer[] { 4, 1, 2, 3}));
		assertFalse(ll.testListContents(new Integer[] { 1, 2, 3}));
	}

	@Test
	public void testRemoveCharacter() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.removeCharacter(2);
		assertTrue(ll.testListContents(new Integer[] { 1, 3 }));
		assertFalse(ll.testListContents(new Integer[] { 1, 2, 3 }));
	}

}
