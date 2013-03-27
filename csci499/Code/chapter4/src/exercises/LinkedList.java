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
}