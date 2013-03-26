package exercises;

public class Node {
	// Fields

	private int data; // Element stored in the node
	private Node next; // Refers to the next node in the list

	// Declaring Node 
	Node head;	// The lists first node
	Node tail;	// The lists last node

	// Default constructor for the Node class

	// We want to initialize a node with specified initial data and link to the next node or the null reference
	public Node(int givenData, Node connectNodes) {
		data = givenData;
		next = connectNodes;
	}

	// Getters

	// Accessor method to get and return the data from this node
	public int getData() {
		return data;
	}

	//Accessor method to get a reference to the next node
	public Node getNext() {
		return next;
	}

	// Setters

	// Modification method to set the data in the node
	public void setData(int newData) {
		data = newData;
	}

	// Modification method to set the reference to the next node
	public void setNext(Node newNext) {
		next = newNext;
	}

}