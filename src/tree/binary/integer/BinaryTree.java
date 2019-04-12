package tree.binary.integer;

import common.node.tree.binary.integer.BTNode;
import queue.singleLinkedList.btnode.Queue;
import stack.array.integer.Stack;

public class BinaryTree {

	private BTNode root;
	
	public void buildTree() {
		root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);

//		root = new BTNode(10);
//		root.left = new BTNode(5);
	}
	
	public boolean isTreeEmpty() {
		return root == null;
	}
	
	public void printPreOrder() {
		preOrder(root);
		System.out.println();
	}

	public void printInOrder() {
		inOrder(root);
		System.out.println();
	}
	
	public void printPostOrder() {
		postOrder(root);
		System.out.println();
	}
	
	private void preOrder(BTNode curr) {
		if(curr == null) return;
		System.out.print(curr.d + " ");
		preOrder(curr.left);
		preOrder(curr.right);
	}
	
	private void postOrder(BTNode curr) {
		if(curr == null) return;
		postOrder(curr.left);
		postOrder(curr.right);
		System.out.print(curr.d + " ");
	}

	public void inOrder(BTNode curr) {
		if(curr == null) return;
		inOrder(curr.left);
		System.out.print(curr.d + " ");
		inOrder(curr.right);
	}
	
	public boolean searchNode(int d) {
		boolean res = false;
		res = preOrderSearch(d, root);
		return res;
	}
	
	private boolean preOrderSearch(int d, BTNode curr) {
		if(curr == null) return false;
		boolean res = curr.d == d;
		res = res ? res : preOrderSearch(d, curr.left);
		res = res ? res : preOrderSearch(d, curr.right);
		return res;
	}

	public void searchAndPrintPath(int d) {
		Stack stack = new Stack(5);
		boolean res = preOrderSearchPath(d, root, stack);
		stack.printStack();
		System.out.println(stack.size()+"...");
	}
	
	private boolean preOrderSearchPath(int d, BTNode curr, Stack stack) {
		if(curr == null) return false;
		stack.push(curr.d);
		if(curr.d == d) return true;
		boolean res = preOrderSearchPath(d, curr.left, stack);
		if(!res) {
			res = preOrderSearchPath(d, curr.right, stack);
		}
		if(!res) stack.pop();
		return res;
	}

	public long findDepth(BTNode target) {
		long res = -1;
		if(root == null) return res;
		Queue tempq = new Queue();
		tempq.push(root);
		while(!tempq.isEmpty()) {
			BTNode curr = tempq.peek();
			if(target == curr)
			System.out.print(curr.d+" ");
			if(curr.left != null) tempq.push(curr.left);
			if(curr.right != null) tempq.push(curr.right);
		}
		System.out.println();
		return res;
	}
	public void printLevelOrder() {
		if(root == null) return;
		Queue tempq = new Queue();
		tempq.push(root);
		while(!tempq.isEmpty()) {
			BTNode curr = tempq.peek();
			System.out.print(curr.d+" ");
			if(curr.left != null) tempq.push(curr.left);
			if(curr.right != null) tempq.push(curr.right);
		}
		System.out.println();
	}
}
