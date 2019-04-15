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
		System.out.println(bt.findMinDepth());
		System.out.println(bt.findMinDepthRecursive());
		bt.preOrderNonRecursive();
		bt.inOrderNonRecursive();
		bt.postOrderNonRecursive();
		System.out.println(bt.findMaxDepthRecursive());
		bt.printMaxSumInPath();
		System.out.println(bt.checkPreOrder(null));
		System.out.println(bt.checkPreOrder(new int[]{}));
		System.out.println("...");
		System.out.println(bt.checkPreOrder(new int[]{2,4,3}));
		System.out.println(bt.checkPreOrder(new int[]{2,4,1}));
		System.out.println(bt.checkPreOrder(new int[]{40,30,35,80,100}));
		bt.printInOrder();
		System.out.println(bt.isFullBinaryTree());
		System.out.println(bt.isFullBinaryTreeRecursive());
		bt.printBottomView();
		bt.printTopView();
		bt.removeLongPathK(4);
		bt.printInOrder();
		System.out.println("...");
		System.out.println(bt.leastCommonAncestor(10, 14));
		System.out.println(bt.leastCommonAncestor(12, 14));
		System.out.println(bt.leastCommonAncestor(10, 12));
		System.out.println(bt.leastCommonAncestor(10, 22));
		System.out.println(bt.leastCommonAncestor(4, 14));
	}
	
}
