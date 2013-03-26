package exercises;

public class LLists {
	// Fields
	
	private int data; // Element stored in the node
	private LLists next; // Refers to the next node in the list
	
	// Declaring LLists 
	LLists head;	// The lists first node
	LLists tail;	// The lists last node
	
	// Default constructor for the Node class
	
	// We want to initialize a node with specified initial data and link to the next node or the null reference
	public LLists(int givenData, LLists connectNodes) {
		data = givenData;
		next = connectNodes;
	}
	
	// Getters
	
	// Accessor method to get and return the data from this node
	public int getData() {
		return data;
	}
	
	//Accessor method to get a reference to the next node
	public LLists getNext() {
		return next;
	}
	
	// Setters
	
	// Modification method to set the data in the node
	public void setData(int newData) {
		data = newData;
	}
	
	// Modification method to set the reference to the next node
	public void setNext(LLists newNext) {
		next = newNext;
	}
	
	
	// A method to search for a target in a linked list
	public LLists nodeTarget(LLists head, int target) {
		LLists current = head;
		
		while (current.next != null) {
			if (target == current.data) {
				return current;
			}
		}
		
		return null;
	}
}