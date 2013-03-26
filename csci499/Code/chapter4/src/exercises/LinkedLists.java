package exercises;

import exercises.Node;

public class LinkedLists {
	
	Node head;
	
	// A method to search for a target in a linked list
	public Node listTarget(int target) {
		while (head.getNext() != null) {
			if (target == head.getData()) {
				return head;
			}
		}

		return null;
	}

	// A method to find a specific location in a linked list
	public Node listPosition(int position) throws RuntimeException {

		if ( position < 0) {
			throw new RuntimeException("ERROR: This position is out of bounds.");
		}

		for (int i = 0; (i < position) && (head.getNext() != null); i++) { 
			head = head.getNext();
		}

		return head;
	}
}