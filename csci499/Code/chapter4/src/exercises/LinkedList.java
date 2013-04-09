// Chris Card helped me with understanding Templates and how Comparable works

package exercises;

import exercises.Node;

public class LinkedList<T> {
	// Fields
	public Node<T> head;
	public Node<T> next;
	public Node<T> tail;

	// Default LinkedList constructor
	public LinkedList() {
		head = null;
		tail = head;
	}

	// Assigned by Rader
	// Insert element at the head of the list
	public void insertAtHead(T newData) {
		Node<T> createNode = new Node<T>(newData);

		createNode.next = head;

		if (head == null) {
			tail = createNode;
		} // this will only ever happen at the first insert

		head = createNode;
	}

	// Insert element at the end of the list
	// Helper function
	public void insertAtTail(T newData) {
		Node<T> createNode = new Node<T>(newData);

		tail.next = createNode;
		tail = createNode;
	}

	// Print the LinkedList
	public void printLinkedList() {
		Node<T> current = head;

		System.out.print("Current List: ");

		while (current.next != null) {
			current.printNode();
			current = current.next;
		}

		System.out.print(" ");
	}

	// Chapter 4 Problem 6, Chapter 5 Problem 3
	// Traversing the list to find a specific character
	// returns true if found, false if not
	public boolean characterAt(T findChar) {
		Node<T> current = head;
		boolean isFound = false;

		while (current != null) {
			if (current.compareTo(findChar) == 0) {
				current.printNode();
				current = current.next;
				isFound = true;
			} else {
				current = current.next;
			}
		}
		return isFound;
	}

	// Chapter 4 Problem 6, Chapter 5 Problem 3
	// Append to the end of the list
	public void append(T addChar) {
		Node<T> current = head;

		// Base Case
		if (head == null) {
			insertAtHead(addChar);
			// current.printNode();
		} else {
			while (current.next != null) {
				current = current.next;
			}
			insertAtTail(addChar);
		}
	}

	// Chapter 4 Problem 7, Chapter 5 Problem 3
	// Concatenate two lists together
	public LinkedList<T> concatenate(LinkedList<T> secondList) {
		LinkedList<T> listCopied = new LinkedList<T>();

		Node<T> current = head;
		// Copy data from the first list into the new list
		listCopied.append(current.data);

		Node<T> secondHead = secondList.head;
		// Copy data from the second list in the new list
		listCopied.append(secondHead.data);
		
		return listCopied;
	}

	// Chapter 4 Problem 8, Chapter 5 Problem 5
	// RemoveChar - still not sure if I did this one correctly
	public void removeChar(LinkedList<T> thisList, int startPos, int numRemove) {
		Node<T> thisCurrent = thisList.head;
		Node<T> thisNext = thisList.next;
		int countPos = 0;

		while (thisNext != null) {
			if (countPos == startPos) {
				for (int i = 0; i < numRemove; i++) {
					thisCurrent = thisCurrent.next;
				}
				thisNext = thisNext.next;
			} else {
				thisCurrent = thisCurrent.next;
				thisNext = thisNext.next;
				countPos++;
			}
		}
	}

	// Assigned by Rader
	// Remove Duplicate Values
	public void removeDuplicate() {
		Node<T> current = head;
		Node<T> duplicate = head.next;
		Node<T> before = head;

		while (current != null) {
			if (current.data == duplicate.data) {
				before = duplicate.next;
				duplicate = duplicate.next;
			} else {
				duplicate = duplicate.next;
				before = before.next;
			}
			current = current.next;
		}

	}

	// Assigned by Rader
	// Add the new Node to beginning of the list, assuming the list is not null
	// Not sure if I still technically have to do this, or if I have it covered
	// in the insertAtHead function above
	public void insert(T addToFront) {
		Node<T> previous = null;
		Node<T> current = head;

		while (current != null) {
			if (previous == null) {
				insertAtHead(addToFront);
			} else {
				previous = current;
				current = current.next;
			}
		}
	}

	// Assigned by Rader
	// Remove a character from the list
	public void removeCharacter(T removeMe) {
		Node<T> previous = null;
		Node<T> current = head;

		while (current != null) {
			if (current.compareTo(removeMe) == 0) {
				current = current.next;
			} else {
				previous = current;
				current = current.next;
			}
		}
	}

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

}