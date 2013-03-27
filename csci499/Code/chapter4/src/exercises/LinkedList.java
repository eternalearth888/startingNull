package exercises;

import exercises.Node;

public class LinkedList {
	// Fields
	private Node head;
	
	// Default LinkedList constructor
	public LinkedList() {
		head = null;
	}
	
	// Insert element at the head of the list
	public void insertAtHead(int newData) {
		Node createNode = new Node(newData);
		
		createNode.next = head;
		head = createNode;
	}
	
	// Print the LinkedList
	public void printLinkedList() {
		Node current = head;
		
		System.out.print("Current List: ");
		
		while(current.next != null) {
			current.printNode();
			current = current.next;
		}
		
		System.out.print(" ");
	}
	
	// Traversing the list to find a character at
	public void characterAt(int findChar) {
		Node current = head;
		
		while(current.next != null) {
			if(current.data == findChar) {
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
	public void append(int addChar) {
		Node current = head;
		Node appendNode = new Node(addChar);
		
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
	public void removeChar(LinkedList list, int startPos, int numRemove) {
		
	}
	
	
}