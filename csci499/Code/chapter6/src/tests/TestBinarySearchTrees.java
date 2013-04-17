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
		assertTrue(BinarySearchTrees.compareValues(root));
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
		
		assertTrue(BinarySearchTrees.compareValues(root));
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
		
		assertFalse(BinarySearchTrees.compareValues(root));
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
		
		assertFalse(BinarySearchTrees.compareValues(root));
	}

}
