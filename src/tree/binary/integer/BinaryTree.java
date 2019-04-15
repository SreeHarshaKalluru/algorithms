package tree.binary.integer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import common.node.tree.binary.integer.BTNode;
import queue.singleLinkedList.btnode.Queue;
import stack.array.integer.Stack;
/*
 * Full vs complete binary tree 
 * https://web.cecs.pdx.edu/~sheard/course/Cs163/Doc/FullvsComplete.html
 * https://stackoverflow.com/questions/12359660/difference-between-complete-binary-tree-strict-binary-tree-full-binary-tre
 * 
 */
public class BinaryTree {

	private BTNode root;
	private int noOfNodes;
	
	public void buildTree() {
//		root = new BTNode(1);
//		root.left = new BTNode(2);
//		root.right = new BTNode(3);
////		root.right.right = new BTNode(6);
//		root.left.left = new BTNode(4);
//		root.left.right = new BTNode(5);
//		root.left.right.right = new BTNode(-4);
//		root.right.left = new BTNode(4);
//		root.right.right = new BTNode(5);
//		root.left.right.left = new BTNode(6);
//		root.left.right.right = new BTNode(7);
//		root.left.right.right.right = new BTNode(8);

//		root = new BTNode(10);
//		root.left = new BTNode(5);
		
		//bst
		root = new BTNode(20);
		root.left = new BTNode(8);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(12);
		root.left.right.left = new BTNode(10);
		root.left.right.right = new BTNode(14);
		root.right = new BTNode(22);
		noOfNodes = 5;
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

	private boolean isLeaf(BTNode curr) {
		return curr != null && curr.left == null && curr.right == null;
	}
	public long findMaxDepthRecursive() {
		if(isTreeEmpty()) return 0;
		return maxDepth(root);
	}
	private long maxDepth(BTNode curr) {
		if(isLeaf(curr)) return 1;
		if(curr.left != null && curr.right != null) {
			return 1 + Math.max(maxDepth(curr.left), maxDepth(curr.right));
		} else if(curr.left != null) 
			return 1 + maxDepth(curr.left);
		else return 1 + maxDepth(curr.right);
	}
	
	public long findMinDepthRecursive() {
		if(isTreeEmpty()) return 0;
		return minDepth(root);
	}
	private long minDepth(BTNode curr) {
		if(isLeaf(curr)) return 1;
		if(curr.left != null && curr.right != null) {
			return 1 + Math.min(minDepth(curr.left), minDepth(curr.right));
		} else if(curr.left != null) 
			return 1 + minDepth(curr.left);
		else return 1 + minDepth(curr.right);
	}
	public long findMinDepth() {
		long res = -1;
		if(root == null) return res;
		Queue tempq = new Queue();
		HashMap<BTNode, Integer> nodeDepths = new HashMap<BTNode, Integer>();
		nodeDepths.put(root, 0);
		tempq.push(root);
		while(!tempq.isEmpty()) {
			BTNode curr = tempq.peek();
			int childDepth = nodeDepths.get(curr) + 1;
			boolean isLeaf = true;
			if(curr.left != null) {
				tempq.push(curr.left);
				nodeDepths.put(curr.left, childDepth);
				isLeaf = false;
			}
			if(curr.right != null) {
				tempq.push(curr.right);
				nodeDepths.put(curr.right, childDepth);
				isLeaf = false;
			}
			if(isLeaf) {
				res = nodeDepths.get(curr) + 1;
				break;
			}
		}
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
	
	public void preOrderNonRecursive() {
		if(root == null) return;
		stack.array.generic.Stack<BTNode> rights = new stack.array.generic.Stack<BTNode>(noOfNodes);
		rights.push(root);
		while(rights.size() > 0) {
			BTNode curr = rights.pop();
			while(curr != null) {
				System.out.print(curr.d + " ");
				if(curr.right != null) rights.push(curr.right);
				curr = curr.left;
			}
		}
		System.out.println();
	}
	
	public void inOrderNonRecursive() {
		if(root == null) return;
		stack.array.generic.Stack<BTNode> aux = new stack.array.generic.Stack<BTNode>(noOfNodes);
		BTNode curr = root;
		while(aux.size() > 0 || curr!=null) {
			while(curr != null) {
				aux.push(curr);
				curr = curr.left;
			}
			curr = aux.pop();
			System.out.print(curr.d + " ");
			curr = curr.right;
		}
		System.out.println();
	}
	
	public void postOrderNonRecursive() {
		if(root == null) return;
		stack.array.generic.Stack<BTNode> aux = new stack.array.generic.Stack<BTNode>(noOfNodes);
		BTNode curr = root;
		Set<BTNode> rightsVisited = new HashSet<BTNode>();
		while(aux.size() > 0 || curr!=null) {
			while(curr != null) {
				aux.push(curr);
				curr = curr.left;
			}
			curr = aux.pop();
			if(curr.right == null || rightsVisited.contains(curr)) {
				System.out.print(curr.d + " ");
				curr = null;
			} else {
				aux.push(curr);
				rightsVisited.add(curr);
				curr = curr.right;
			}
		}
		System.out.println();
	}
	
	private class Res {
		int val;
		Res(int val) {
			this.val = val;
		}
	}
	public void printMaxSumInPath() {
		Res res = new Res(Integer.MIN_VALUE);
		findMax(root, res);
		System.out.println(res.val);
	}

	private int findMax(BTNode curr, Res res) {
		if(curr == null) return 0;
		int l = findMax(curr.left, res);
		int r = findMax(curr.right, res);
		int max_single = Math.max(Math.max(l, r) + curr.d, curr.d);
		int max_total = Math.max(max_single, l + r + curr.d);
		if(res.val < max_total) res.val = max_total;
		return max_single;
	}
	
	public boolean checkPreOrder(int[] pre) {
		if(pre == null || pre.length == 0) return true;
		Stack s = new Stack(pre.length);
		s.push(pre[0]);
		int i=1;
		ArrayList<Integer> inOrderArr = new ArrayList<Integer>();
		while(i<pre.length) {
			int prev = s.pop();
			if(pre[i] < prev) {
				s.push(prev);
				s.push(pre[i]);
				i++;
			} else {
				inOrderArr.add(prev);
				if(s.isEmpty()) {
					s.push(pre[i]);
					i++;
				}
			}
		}
		while(!s.isEmpty()) {
			inOrderArr.add(s.pop());
		}
		System.out.println(inOrderArr);
		for(int j=0; j<inOrderArr.size()-1; j++) {
			if(inOrderArr.get(j) > inOrderArr.get(j+1)) return false;
		}
		return true;
	}
	
	public boolean isFullBinaryTree() {//this checks for perfect tree
		if(root == null) return true;
		Queue q = new Queue();
		q.push(root);
		int level = 0;
		while(!q.isEmpty()) {
			int noOfNodesInCurrLevel = (int) Math.pow(2, level);
			BTNode curr = q.peek();
			boolean isFirstFull = isFull(curr);
			boolean isFirstEmpty = (!isFirstFull) ? isEmpty(curr) : false;
			if(!isFirstFull && !isFirstEmpty) return false;
			if(isFirstFull) {
				q.push(curr.left);
				q.push(curr.right);
			}
			
			for(int i=1; i<noOfNodesInCurrLevel; i++) {
				if(q.isEmpty()) return false;
				curr = q.peek();
				boolean isCurrFull = isFull(curr);
				boolean isCurrEmpty = (!isCurrFull) ? isEmpty(curr) : false;
				if( (isFirstFull && !isCurrFull) || (isFirstEmpty && !isCurrEmpty)) 
					return false;
				if(isCurrFull) {
					q.push(curr.left);
					q.push(curr.right);
				}
			}
			level++;
		}
		return true;
	}

	private boolean isEmpty(BTNode curr) {
		return curr.left == null && curr.right == null;
	}

	private boolean isFull(BTNode curr) {
		return curr.left != null && curr.right != null;
	}
	
	public boolean isFullBinaryTreeRecursive() {
		//with definition that a full binary tree is a tree 
		//with all nodes having either 2 or 0 children
		return isFullBinaryTree(root);
	}

	private boolean isFullBinaryTree(BTNode curr) {
		if(curr == null) return true;
		if(curr.left == null && curr.right == null) return true;
		if(curr.left != null && curr.right != null) {
			return isFullBinaryTree(curr.left) && isFullBinaryTree(curr.right);
		}
		return false;
	}
	
	private class AuxBTNode {
		BTNode node;
		int dist;
		AuxBTNode(BTNode node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}
	
	public void printBottomView() {
		if(root == null) return;
		queue.singleLinkedList.generic.Queue<AuxBTNode> q = new queue.singleLinkedList.generic.Queue<>();
		q.push(new AuxBTNode(root, 0));
		Map<Integer, Integer> view = new TreeMap<Integer, Integer>();
		view.put(0, root.d);
		while(!q.isEmpty()) {
			 AuxBTNode curr = q.peek();
			 if(curr.node.left!=null){
				 q.push(new AuxBTNode(curr.node.left, curr.dist - 1));
				 view.put(curr.dist - 1, curr.node.left.d);
			 }
			 if(curr.node.right!=null){
				 q.push(new AuxBTNode(curr.node.right, curr.dist + 1));
				 view.put(curr.dist + 1, curr.node.right.d);
			 }
		}
		System.out.println(view.values());
	}
	
	public void printTopView() {
		if(root == null) return;
		queue.singleLinkedList.generic.Queue<AuxBTNode> q = new queue.singleLinkedList.generic.Queue<>();
		q.push(new AuxBTNode(root, 0));
		Map<Integer, Integer> view = new TreeMap<Integer, Integer>();
		view.put(0, root.d);
		while(!q.isEmpty()) {
			 AuxBTNode curr = q.peek();
			 if(curr.node.left!=null){
				 q.push(new AuxBTNode(curr.node.left, curr.dist - 1));
				 view.putIfAbsent(curr.dist - 1, curr.node.left.d);
			 }
			 if(curr.node.right!=null){
				 q.push(new AuxBTNode(curr.node.right, curr.dist + 1));
				 view.putIfAbsent(curr.dist + 1, curr.node.right.d);
			 }
		}
		System.out.println(view.values());
	}
	
	public void removeLongPathK(int k) {
		boolean res = removeLongPathK(root, 1, k);
		if(res) root = null;
	}
	
	public boolean removeLongPathK(BTNode curr, int currLen, int k) {
		if(isLeaf(curr)) {
			return currLen < k;
		}
		boolean left = (curr.left != null) ? removeLongPathK(curr.left, currLen+1, k):true;
		boolean right = (curr.right != null) ? removeLongPathK(curr.right, currLen+1, k):true;

		if(left) removeLeft(curr);
		if(right) removeRight(curr);
		return left && right;
	}

	private void removeLeft(BTNode curr) {
		if(curr.left != null) {
			curr.left = null;
		}
	}

	private void removeRight(BTNode curr) {
		if(curr.right != null) {
			curr.right = null;
		}		
	}
	
	public int leastCommonAncestor(int n1, int n2) {
		return leastCommonAncestor(root, n1, n2);
	}
	private int leastCommonAncestor(BTNode curr, int n1, int n2) {
		//assuming the nodes always present in the tree and bst
		if(curr.d < n1 && curr.d < n2) return leastCommonAncestor(curr.right, n1, n2);
		else if(curr.d > n1 && curr.d > n2) return leastCommonAncestor(curr.left, n1, n2);
		else return curr.d;
	}
	
	public void buildPerfectBinaryTree() {
		root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		root.left.left.left = new BTNode(8);
		root.left.left.right = new BTNode(9);
		root.left.right.left = new BTNode(10);
		root.left.right.right = new BTNode(11);
		root.right.left.left = new BTNode(12);
		root.right.left.right = new BTNode(13);
		root.right.right.left = new BTNode(14);
		root.right.right.right = new BTNode(15);
	}
	
	public void reverseAlternatePerfectBT() {
		
		if(root == null) return;
		int level=0;
		Queue q = new Queue();
		q.push(root);
		stack.array.generic.Stack<BTNode> s = new stack.array.generic.Stack(10);
		while(!q.isEmpty()) {
			if(level%2 == 0) {
				long noOfEle = q.size();
				for(int i=0; i<noOfEle; i++) {
					BTNode curr = q.peek();
					s.push(curr);
					if(!isLeaf(curr)) {
						q.push(curr.left);
						q.push(curr.right);
					}
				}
			} else {
				while(!s.isEmpty()) {
					BTNode curr = s.pop();
					curr.right = q.peek();
					curr.left = q.peek();
					swapChildren(curr.left, curr.right);
					if(!isLeaf(curr.left)) {
						q.push(curr.left.left);
						q.push(curr.left.right);
						q.push(curr.right.left);
						q.push(curr.right.right);
					}
				}
			} 
			level++;
//			if(level == 2) break;
		}
	}

	private void swapChildren(BTNode left, BTNode right) {
		BTNode temp = left.left;
		left.left = right.left;
		right.left = temp;
		
		temp = left.right;
		left.right = right.right;
		right.right = temp;
	}
}
