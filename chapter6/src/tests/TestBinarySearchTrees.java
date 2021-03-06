package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exercises.BinarySearchTrees;
import exercises.Node;

public class TestBinarySearchTrees {

	// 15
	@Test
	public void testBaseBST() {
		Node root = new Node(15);
		assertTrue(BinarySearchTrees.isBST(root));
	}

	// 15
	// /\
	// 10 20
	// /\
	// 5 13

	@Test
	public void testValidBST() {
		Node root = new Node(15);
		Node rootLeft = new Node(10);
		Node rootRight = new Node(20);
		Node leftLeft = new Node(5);
		Node leftRight = new Node(13);

		root.left = rootLeft;
		root.right = rootRight;
		rootLeft.left = leftLeft;
		rootLeft.right = leftRight;

		assertTrue(BinarySearchTrees.isBST(root));
	}

	// 15
	// /\
	// 10 20
	// /\
	// 5 13
	// /
	// 2

	@Test
	public void testValid2BST() {
		Node root = new Node(15);
		Node rootLeft = new Node(10);
		Node rootRight = new Node(20);
		Node leftLeft = new Node(5);
		Node leftRight = new Node(13);
		Node leftLeft2 = new Node(2);

		root.left = rootLeft;
		root.right = rootRight;
		rootLeft.left = leftLeft;
		rootLeft.right = leftRight;
		leftLeft.left = leftLeft2;

		assertTrue(BinarySearchTrees.isBST(root));
	}

	// 15
	// /\
	// 10 20
	// /\   \ 
	// 5 13  30
	//       /
	//      6

	@Test
	public void testValid3BST() {
		Node root = new Node(15);
		Node rootLeft = new Node(10);
		Node rootRight = new Node(20);
		Node leftLeft = new Node(5);
		Node leftRight = new Node(13);
		Node rightRight2 = new Node(30);
		Node right2Left = new Node(6);
		
		root.left = rootLeft;
		root.right = rootRight;
		rootLeft.left = leftLeft;
		rootLeft.right = leftRight;
		rootRight.right = rightRight2;
		rightRight2.left = right2Left;

		assertTrue(BinarySearchTrees.isBST(root));
	}

	// 10
	// /\
	// 20 10

	@Test
	public void testInValidBST() {
		Node root = new Node(10);
		Node left = new Node(20);
		Node right = new Node(10);

		root.left = left;
		root.right = right;

		assertFalse(BinarySearchTrees.isBST(root));
	}

	// 15
	// /\
	// 10 20
	// /\
	// 13 5
	@Test
	public void testInValid2BST() {
		Node root = new Node(15);
		Node rootLeft = new Node(10);
		Node rootRight = new Node(20);
		Node leftLeft = new Node(13);
		Node leftRight = new Node(5);

		root.left = rootLeft;
		root.right = rootRight;
		rootLeft.left = leftLeft;
		rootLeft.right = leftRight;

		assertFalse(BinarySearchTrees.isBST(root));
	}

	// 15
	// /\
	// 10 20
	// /\ \
	// 5 13 3
	@Test
	public void testInValid3BST() {
		Node root = new Node(15);
		Node rootLeft = new Node(10);
		Node rootRight = new Node(20);
		Node leftLeft = new Node(5);
		Node leftRight = new Node(13);
		Node rightRight = new Node(3);

		root.left = rootLeft;
		root.right = rootRight;
		rootLeft.left = leftLeft;
		rootLeft.right = leftRight;
		rootRight.right = rightRight;

		assertFalse(BinarySearchTrees.isBST(root));
	}

	// ( )
	
	@Test
	public void testNoNode() {
		// A tree of NOTHING YAAAAAAAAAAY!!
		Node root = null;
		
		assertTrue(BinarySearchTrees.isBST(root));
	}
	
	// 20
	//   \
	//   25
	//     \
	//      30
    //       /
	//      15
	//        \
	//         45
	
	@Test
	public void testAllRight() {
		Node root = new Node(20);
		Node right1 = new Node(25);
		Node right2 = new Node(30);
		Node left = new Node(15);
		Node right3 = new Node(45);
		
		root.right = right1;
		right1.right = right2;
		right2.left = left;
		left.right = right3;
		
		assertTrue(BinarySearchTrees.isBST(root));
	}
	
	// 20
	//   \
	//   25
	//     \
	//      30
    //       /
	//      55
	//        \
	//         45
	@Test
	public void testAllNotRight() {
		Node root = new Node(20);
		Node right1 = new Node(25);
		Node right2 = new Node(30);
		Node left = new Node(55);
		Node right3 = new Node(45);
		
		root.right = right1;
		right1.right = right2;
		right2.left = left;
		left.right = right3;
		
		assertFalse(BinarySearchTrees.isBST(root));
	}
	
	// 			20
	//   		/
	//	 	  15
	//		/
	//	   10
	@Test
	public void testAllLeft() {
		Node root = new Node(20);
		Node left = new Node(15);
		Node left2 = new Node(10);
		
		root.left = left;
		left.left = left2;
		
		assertTrue(BinarySearchTrees.isBST(root));
	}
	
	//			20
	//   		/
	//	 	  25
	//		/
	//	   10
	@Test
	public void testAllNotLeft() {
		Node root = new Node(20);
		Node left = new Node(25);
		Node left2 = new Node(10);
		
		root.left = left;
		left.left = left2;
		
		assertFalse(BinarySearchTrees.isBST(root));
	}
	
	//			20
	//   		/
	//	 	  15
	//		/
	//	   10
	//		\
	//		15
	@Test
	public void testAllNotLeft2() {
		Node root = new Node(20);
		Node left = new Node(15);
		Node left2 = new Node(10);
		Node right = new Node(15);
		
		root.left = left;
		left.left = left2;
		left2.right = right;
		
		assertTrue(BinarySearchTrees.isBST(root));
	}
	
}
