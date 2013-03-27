// Help with templatable stuff from Chris Card

package exercises;

import exercises.Node;

public class LinkedList<T> {
	// Fields
	private Node head;
	
	// Default LinkedList constructor
	public LinkedList() {
		head = null;
	}
	
	// Insert element at the head of the list
	public void insertAtHead(T newData) {
		Node<T> createNode = new Node<T>(newData);
		
		createNode.next = head;
		head = createNode;
	}
	
	// PrT the LinkedList
	public void printLinkedList() {
		Node<T> current = head;
		
		System.out.print("Current List: ");
		
		while(current.next != null) {
			current.printNode();
			current = current.next;
		}
		
		System.out.print(" ");
	}
	
	// Traversing the list to find a character at
	public void characterAt(T findChar) {
		Node<T> current = head;
		
		while(current.next != null) {
			if(current.compareTo(findChar)== 0) {
				System.out.print("FOUND IT!: ");
				current.printNode();
				current = current.next;
			}
			else
			{
				current = current.next;
			}
		}
	}
	
	// Append to the end of the list
	public void append(T addChar) {
		Node<T> current = head;
		Node<T> appendNode = new Node<T>(addChar);
		
		while(current.next != null) {
			current = current.next;
		}
		
		appendNode.next = current;
		current = appendNode;
	}
	
	// Concatenate
	public void concatenate() {
		
	}
	
	// RemoveChar
	public void removeChar(LinkedList<T> list, T startPos, T numRemove) {
		
	}
	
	
}