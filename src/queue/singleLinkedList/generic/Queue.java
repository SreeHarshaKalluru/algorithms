package queue.singleLinkedList.generic;

import common.node.singleNext.generic.Node;

public class Queue <T>{

	private long size;
	private Node head;
	private Node tail;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public long size() {
		return size;
	}
	
	public void push(T d) {
		Node temp = new Node(d);
		if(isEmpty()) {
			head = tail = temp;
		} else {
			tail.next = temp;
			tail = tail.next;
		}
		size++;
	}
	
	public T peek() {
		T res = null;
		if(isEmpty()) 
			return res;
		res = (T) head.d;
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
