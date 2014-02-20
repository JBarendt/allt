package bst;

import bst.BSTVisualizer;

public class BinaryTreeTest {
	public static void main(String[] args){
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		BST.add(1);
		BST.add(3);
		BST.add(5);
		BST.add(7);
		BST.add(9);
		BST.add(11);
		BST.add(13);
		BST.printTree();
		BST.rebuild();
		System.out.println(" ");
		System.out.println("Height: " + BST.height());
		System.out.println("Size: " + BST.size());
		BSTVisualizer BSTV = new BSTVisualizer("BSTV", 400, 400);
		BSTV.drawTree(BST);
		BinarySearchTree<Character> BST2 = new BinarySearchTree<Character>();
		/*BST2.add('C');
		BST2.add('A');
		BST2.add('B');
		BST2.add('E');
		BST2.add('D');
		BSTV.drawTree(BST2);*/
		
	}
}
