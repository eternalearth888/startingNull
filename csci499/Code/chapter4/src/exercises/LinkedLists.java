package exercises;

public class LinkedLists {

	Node head;
	int length;

	public LinkedLists() {
		length = 0;
		head = null;
	}

	//	Traverse the LinkedList
	public Node traversal(Node header) {
		Node current = header;
		
		System.out.print("Traversal: ( ");

		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println(")");
		
		return head;
	}

	//	Verify that the data we want Exits
	public boolean isTarget(Node head, Object data) {
		boolean isExist = false;

		while (head != null) {
			if (head.data == data) {
				isExist = true;
			}
			head = head.next;
		}

		System.out.println("isTarget: " + isExist);
		
		return isExist;
	}


	//	Find if the data we want exists in the node we are looking at
	public Object ex4_6_charAt(Node head, Object data)  throws RuntimeException {
		if (head.data != data) {
			throw new RuntimeException();
		}
		System.out.println("charAt: " + data);
		return data;
	}

	//	Concatenate/Append new data to the end of the current LinkedList
	public void ex4_7_concatenateAppend(Node head, Object data) {
		Node current = head;
		
		System.out.print("conApp: ( ");
		
//		//	Base case: Does the firstNode point to null
//		if (current == null) {
//			current = new Node(data, current);
//			System.out.println(current.data + " )");
//		}

		// Iterate to find the last node so that head refers to the last node
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		
		//	Then have the last node point to the newNode
		current = new Node(data, current);
		System.out.println(current.data + " )");
	}
	
//	public void ex4_8_removeChars(Node head, int beginPosition, int numChars) {
//		Node current = head;
//		
//		
//	}

	//	Add the new Node to the beginning of the list
	public void insertAtFront(Object data, Node header) {
		Node previous = null;
		Node current = header;
		
		System.out.print("insertAtFront: ( ");
	
		while (current != null) {
			if (previous == null) {
				previous = new Node(data, current);
				System.out.print(previous.data + " ");
				System.out.print(current.data + " ");
				previous = current;
				current = current.next;
			}
			else
			{
				System.out.print(current.data + " ");
				previous = current;
				current = current.next;
			}
		}
		System.out.println(")");
	}

	//	Remove a duplicate node
	public void removeDuplicate(Node header){
		Node current = header;
		Node duplicate = header.next;
		
		System.out.print("removeDuplicate: ( ");
		
		while(current.next != null) {
			if (current.data == duplicate.data)
			{
				System.out.print(current.data + " ");
				current = duplicate.next;
				duplicate = current.next;
			}
			else
			{
				System.out.print(current.data + " ");
				current = current.next;
				duplicate = duplicate.next;
			}
		}
		
		System.out.println(current.data + " )");
	}

	//	Reverse the list

	public static void main(String [] args) {
		LinkedLists run = new LinkedLists();

		//  Create Linked List
		//	firstNode -> secondNode -> thirdNode -> null
		Node thirdNode = new Node(3, null);
		Node secondNode = new Node(2, thirdNode);
		Node firstNode = new Node(1, secondNode);

		Node list = new Node(1, new Node(2, new Node(3, null)));

		Node list2 = new Node(1, new Node(2, new Node(2, new Node(3, new Node(4, null)))));
		
		System.out.println("LIST 1");
		run.traversal(list);
		
		run.isTarget(list, 2);
		run.isTarget(list, 4);
		
		run.ex4_7_concatenateAppend(list, 5);
		
		run.insertAtFront(5, list);
		
		run.removeDuplicate(list);
		
		System.out.println();
		System.out.println("LIST 2");
		run.traversal(list2);
		
		run.isTarget(list2, 3);
		run.isTarget(list2, 6);
		
		run.ex4_7_concatenateAppend(list2, 6);
		
		run.insertAtFront(6, list2);
		
		run.removeDuplicate(list2);
		
		System.out.println();
		System.out.println("CHAR_AT");
		run.ex4_6_charAt(thirdNode, 3);
		run.ex4_6_charAt(thirdNode, 2);
	} 
}
