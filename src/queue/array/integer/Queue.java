package queue.array.integer;

public class Queue {

	private int q[]; //we can have only int number of elements in array so maxsize should be int
	                 //cannot be long
	private int maxSize; //not required.. we can use q.length.. used just for readability
	private int head = -1, tail = -1;
	
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		q = new int[maxSize];
	}
	
	public boolean isEmpty() {
		return head == -1;
	}
	
	public boolean isFull() {
		return (head == 0 && tail == maxSize - 1) ||
			   (head != 0 && tail == head - 1);
	}
	
	public int size() {
		return isEmpty() ? 0 : (tail >= head) ? tail - head + 1 : (maxSize - head) + (tail + 1);
	}
	
	public void push(int d) {
		if(isFull()) return;
		if(isEmpty()) {
			head = tail = 0;
		} else {
			tail = (tail + 1) % maxSize;
		}
		q[tail] = d;
	}
	
	public int peek() {
		int res = -1;
		if(isEmpty()) return res;
		res = q[head];
		if(head == tail) head = tail = -1;
		else head = (head + 1) % maxSize;
		
		return res;
	}
	
	public void printQueue() {
		if(isEmpty()) return;
		boolean isHeadLess = head <= tail;
		for(int i=head; i <= (isHeadLess ? tail : maxSize - 1); i++) {
			System.out.print(q[i] + " ");
		}
		
		if(!isHeadLess) {
			for(int i=0; i<=tail; i++) {
				System.out.print(q[i] + " ");
			}
		}
		System.out.println();
	}
}
