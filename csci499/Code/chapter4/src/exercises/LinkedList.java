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
		LinkedList<T> magic = new LinkedList<T>();

	}

	// RemoveChar
	public void removeChar(LinkedList<T> list, T startPos, T numRemove) {

	}

}