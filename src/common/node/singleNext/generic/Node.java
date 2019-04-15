package common.node.singleNext.generic;


public class Node<T> {

	public T d;
	public Node next;
	
	public Node(T d) {
		this.d = d;
	}
	
	public String toString() {
		return d + " -> " + next;
	}
	
}
