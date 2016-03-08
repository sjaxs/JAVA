package dataStructures.queue;

import dataStructures.stack.ArrayStack;
import dataStructures.stack.Stack;

public class TwoStacksQueue<T> implements Queue<T>{

	protected Stack<T> s1;
	protected Stack<T> s2;
	protected int first, last, size;
	
	private static final int DEFAULT_INITIAL_CAPACITY = 128;

	
	public TwoStacksQueue(int n){
		s1 = new ArrayStack<T>(n);
		s2 = new ArrayStack<T>(n);
	}
	
	public TwoStacksQueue(){
		this(DEFAULT_INITIAL_CAPACITY);
		
	}
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public void volcar (){
		while( !s2.isEmpty()){
			s1.push(s2.top());
			s2.pop();
		}
	}
	@Override
	public void enqueue(T x) {
		s2.push(x);
		
	}

	@Override
	public T first() {
		if(s1.isEmpty()){
			volcar();
		}
		return s1.top();
	}

	@Override
	public void dequeue() {
		if(s1.isEmpty()){
			volcar();
		}
		s1.pop();
	}

}
