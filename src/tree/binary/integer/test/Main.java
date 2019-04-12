package tree.binary.integer.test;

import tree.binary.integer.BinaryTree;

public class Main {

	public static void main(String arg[]) {
		
		BinaryTree bt = new BinaryTree();
		bt.buildTree();
		bt.printPreOrder();
		bt.printInOrder();
		bt.printPostOrder();
		bt.printLevelOrder();
		System.out.println(bt.searchNode(1));
		System.out.println(bt.searchNode(2));
		System.out.println(bt.searchNode(3));
		System.out.println(bt.searchNode(4));
		System.out.println(bt.searchNode(5));
		System.out.println(bt.searchNode(6));
		bt.searchAndPrintPath(1);
		bt.searchAndPrintPath(2);
		bt.searchAndPrintPath(3);
		bt.searchAndPrintPath(4);
		bt.searchAndPrintPath(5);
		bt.searchAndPrintPath(6);
	}
	
}
