package exercises;

public class Node {
	
	Node next;
//	Object data;
	Integer data;
	
	public Node() {
		next = null;
		data = 0;
	}
	
	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}
	
}
