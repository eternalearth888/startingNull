// Help with templatable stuff from Chris Card

package exercises;

import exercises.Node;

public class LinkedList<T> {
	// Fields
	public Node<T> head;
	public Node<T> tail;

	// Default LinkedList constructor
	public LinkedList() {
		head = null;
		tail = head;
	}

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
	private void insertAtTail(T newData) {
		Node<T> createNode = new Node<T>(newData);

		tail.next = createNode;
		tail = createNode;
	}

	// PrT the LinkedList
	public void printLinkedList() {
		Node<T> current = head;

		System.out.print("Current List: ");

		while (current.next != null) {
			current.printNode();
			current = current.next;
		}

		System.out.print(" ");
	}

	// Traversing the list to find a character at
	public void characterAt(T findChar) {
		Node<T> current = head;

		while (current.next != null) {
			if (current.compareTo(findChar) == 0) {
				System.out.print("FOUND IT!: ");
				current.printNode();
				current = current.next;
			} else {
				current = current.next;
			}
		}
	}

	// Append to the end of the list
	public void append(T addChar) {
		Node<T> current = head;
		Node<T> appendNode = new Node<T>(addChar);

		// Base Case
		if (head == null) {
			insertAtHead(addChar);
		} else {
			while (current.next != null) {
				current = current.next;
			}
			insertAtTail(addChar);
		}

	}

	// Concatenate
	public void concatenate(LinkedList<T> list) {
		LinkedList<T> newList = new LinkedList<T>();

		Node<T> current = head;

		if (head == null) {
			newList = list;
		} else {
			while (current.next != null) {

			}
		}

	}

	// RemoveChar
	public void removeChar(LinkedList<T> list, T startPos, T numRemove) {

	}

	// Remove Duplicate Values
	public void removeDuplicate() {
		Node<T> current = head;
		Node<T> duplicate = head.next;

		while (current.next != null) {
			if (current.data == duplicate.data) {
				current = duplicate.next;
				duplicate = current.next;
			} else {
				current = current.next;
				duplicate = duplicate.next;
			}
		}
	}

	// Add the new Node to beginning of the list, assuming the list is not null
	// Not sure if I still techinically have to do this, or if I have it covered
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
	
	
}