package stack.array.integer;

public class Stack {

	private int[] aux;
	private int maxSize;
	private int top = -1;
	
	public Stack(int maxSize) {
		this.maxSize = maxSize;
		aux = new int[maxSize];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	public void push(int d) {
		if(!isFull()) {
			aux[++top] = d;
		}
	}
	
	public int pop() {
		if(isEmpty()) return -1;
		return aux[top--];
	}
	
	public int size() {
		return top;
	}
	
	public void printStack() {
		if(!isEmpty()) {
			for(int i=0; i<=top; i++) {
				System.out.print(aux[i] + " ");
			}
			System.out.println();
		}
	}
}
