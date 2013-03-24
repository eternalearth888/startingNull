package exercises;

import exercises.Node;

public class LinkedLists {
	
	Node head;
	int data;
	
	// A method to search for a target in a linked list
	public LinkedLists listTarget(int target) {
		while (head.next != null) {
			if (target == head.data) {
				return head;
			}
		}

		return null;
	}

	// A method to find a specific location in a linked list
	public LinkedLists listPosition(int position) throws RuntimeException {

		if ( position < 0) {
			throw new RuntimeException("ERROR: This position is out of bounds.");
		}

		for (int i = 0; (i < position) && (head.next != null); i++) { 
			head = head.next;
		}

		return head;
	}
}
