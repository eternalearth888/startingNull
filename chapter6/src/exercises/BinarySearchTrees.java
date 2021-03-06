package exercises;

public class BinarySearchTrees {

	public Node head;

	public BinarySearchTrees() {
		head = null;
	}

	// Assume that the binary tree is already a BST until proven otherwise
	public static boolean isBST(Node root) {
		boolean leftValid = true;
		boolean rightValid = true;

		// Base Case
		if (root == null) {
			return true;
		}
		// a lone leaf is still a BST
		if (root.left == null && root.right == null) {
			return true;
		}
		
		// If it's not null, I need to know its value because then that means it
		// is a tree
		if (root.left != null) {
			leftValid = isBST(root.left);
			if (!leftValid) {
				return false;
			}
		}
		
		if (root.right != null) {
			rightValid = isBST(root.right);
			if (!rightValid) {
				return false;
			}
		}
		
		if ((root.left != null && root.left.data > root.data) || (root.right != null && root.right.data < root.data)) {
			return false;
		}

		return true;
	}

}
