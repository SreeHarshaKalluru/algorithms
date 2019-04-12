package common.node.singleNext.btnode;

import common.node.tree.binary.integer.BTNode;

public class Node {

	public BTNode d;
	public Node next;
	
	public Node(BTNode d) {
		this.d = d;
	}
	
	public String toString() {
		return d + " -> " + next;
	}
	
}
