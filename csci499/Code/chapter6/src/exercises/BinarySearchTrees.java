package exercises;

public class BinarySearchTrees {

	public Node head;

	public BinarySearchTrees() {
		head = null;
	}
	
	// THIS SOLUTION IS NOT CORRECT
	// GO DOWN FURTHER IN THE TREE
	public static boolean compareValues(Node root) {
		boolean leftValid = true;
		boolean rightValid = true;
		
		// Base Case
		if (root == null) {
			return true; // a BST with no nodes is still a BST
		}
		// If it's not null, I need to know its value because then that means it is a tree
		if (root.left != null) {
			leftValid = compareValues(root.left);
		}
		if (root.right != null) {
			rightValid = compareValues(root.right);
		}
		if ((root.left != null && root.left.data > root.data) || (root.right != null && root.right.data < root.data)) {
			return false; // Since it is valid, check the subtrees
		}
		
		return leftValid && rightValid;
	}	
}
