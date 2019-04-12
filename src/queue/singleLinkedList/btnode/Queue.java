package queue.singleLinkedList.btnode;

import common.node.singleNext.btnode.Node;
import common.node.tree.binary.integer.BTNode;

public class Queue {

	private long size;
	private Node head;
	private Node tail;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public long size() {
		return size;
	}
	
	public void push(BTNode d) {
		Node temp = new Node(d);
		if(isEmpty()) {
			head = tail = temp;
		} else {
			tail.next = temp;
			tail = tail.next;
		}
		size++;
	}
	
	public BTNode peek() {
		BTNode res = null;
		if(isEmpty()) 
			return res;
		res = head.d;
		if(head == tail) { head = tail = null; }
		else {
			head = head.next;
		}
		size--;
		return res;
	}
	
	public void printQueue() {
//		Node temp = head;
//		while(temp != null) {
//			System.out.print(temp.d + " -> ");
//			temp = temp.next;
//		}
		System.out.println("Queue : " + head);
	}
}
