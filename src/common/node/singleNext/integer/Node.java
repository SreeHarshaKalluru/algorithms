package common.node.singleNext.integer;

public class Node {

	public int d;
	public Node next;
	
	public Node(int d) {
		this.d = d;
	}
	
	public String toString() {
		return d + " -> " + next;
	}
	
}
