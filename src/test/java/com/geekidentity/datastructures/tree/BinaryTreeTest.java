package com.geekidentity.datastructures.tree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
	
	private Tree<Integer> root;
	
	@Before
	public void init() {
		root = new BinaryTree<Integer>(1);
		Tree<Integer> t2 = new BinaryTree<Integer>(2);
		Tree<Integer> t3 = new BinaryTree<Integer>(3);
		root.create(1, t2, t3);
	}
	
	@Test
	public void preOrderTest() {
		BinaryTree<Integer> t = (BinaryTree<Integer>)root;
		t.inOrderRecursion(t.getRoot());
	}

}
