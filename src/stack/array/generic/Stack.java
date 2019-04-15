package stack.array.generic;

public class Stack<T> {

	private Object[] aux;
	private int maxSize;
	private int top = -1;
	
	public Stack(int maxSize) {
		this.maxSize = maxSize;
		aux = new Object[maxSize];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	public void push(T d) {
		if(!isFull()) {
			aux[++top] = d;
		}
	}
	
	public T pop() {
		if(isEmpty()) return null;
		return (T) aux[top--];
	}
	
	public int size() {
		return top + 1;
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
