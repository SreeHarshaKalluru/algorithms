package queue.array.integer.test;

import queue.array.integer.Queue;

public class Main {

	public static void main(String arg[]) {
		Queue q = new Queue(5);
		q.printQueue();
		q.push(1);
		q.printQueue();
		q.push(2);
		q.printQueue();
		q.push(3);
		q.printQueue();
		q.push(4);
		q.printQueue();
		q.peek();
		q.printQueue();
		q.peek();
		q.printQueue();
		q.push(5);
		q.printQueue();
		q.push(6);
		q.printQueue();
		q.push(7);
		q.printQueue();
		q.push(8);
		q.printQueue();
		q.push(9);
		q.printQueue();
		q.push(10);
		q.printQueue();
		q.peek();
		System.out.println("isQEmpty : " + q.isEmpty());
		q.printQueue();
		System.out.println(q.peek());
		q.printQueue();
		System.out.println(q.peek());
		System.out.println("isQEmpty : " + q.isEmpty());
	}
}
