package exercises;

public class BinarySearchTrees {

	public Node head;

	public BinarySearchTrees() {
		head = null;
	}
	
	public static boolean compareValues(Node root) {
		// Base Case
		if (root == null) {
			return true; // a BST with no nodes is still a BST
		} else if (root.left == null && root.right == null) {
			return true;
		} else if (root.left == null) {
			if (root.right.data > root.data) {
				return true;
			}
		} else if (root.right == null) {
			if (root.left.data < root.data) {
				return true;
			}
		} else if (root.left.data < root.data && root.right.data > root.data) {
			return compareValues(root.left) && compareValues(root.right); // Since it is valid, check the subtrees
		}
		
		return false; // If none of them apply
	}
	
}
