package com.geekidentity.datastructures.tree;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
	
	BinarySearchTree<Integer> bst;
	
	@Before
	public void init() {
		List<Integer> list = Arrays.asList(1,4,6,-1,34,3,21);
		bst = new BinarySearchTree<>(list);
		
	}
	
	@Test
	public void preOrderTest() {
		bst.preOrder(bst.getRoot());
	}

}
