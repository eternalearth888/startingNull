package exercises;

public class Node {

	// Fields
	public int data;
	public Node next;
	
	// Default Node constructor
	public Node(int newData) {
		data = newData;
	}
	
	// Print the Node
	public String printNode() {
		return "{" + data + "}";
	}
	
}
