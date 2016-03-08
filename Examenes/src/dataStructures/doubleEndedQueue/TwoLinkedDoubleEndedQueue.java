package dataStructures.doubleEndedQueue;

public class TwoLinkedDoubleEndedQueue<T> implements DoubleEndedQueue<T> {
	private static class Node<E> {
		private E elem;
		private Node<E> next;

		public Node(E x, Node<E> nxt) {
			elem = x;
			next = nxt;
		}		
	}
	
	private Node<T> first, last;
	boolean simetric = false;

	public TwoLinkedDoubleEndedQueue() {
		first = null;
		last = null;
	}
	
	@Override
	public boolean isEmpty() {
		return first == null && last == null;
	}

	@Override
	public void addFirst(T x) {
		Node<T> node = new Node<>(x, first);
		first = node;
	}
	
	@Override
	public void addLast(T x) {
		flipDeq();
		addFirst(x);
		flipDeq();
	}

	@Override
	public T first() {
		if(isEmpty())
			throw new EmptyDoubleEndedQueueException((simetric?"last":"first") + " on empty double ended queue");
		else if (first == null)
			balance();
		return first.elem;
	}

	@Override
	public T last() {
		flipDeq();
		T elem = first();
		flipDeq();
		return elem;
	}

	@Override
	public void deleteFirst() {
		if(isEmpty())
			throw new EmptyDoubleEndedQueueException((simetric?"deleteLast":"deleteFirst") + " on empty double ended queue");
		else if (first == null) 
			balance();
		first = first.next;
	}

	@Override
	public void deleteLast() {
		flipDeq();
		deleteFirst();
		flipDeq();
	}

	private void flipDeq() {
		Node<T> temp = first;
		first = last;
		last = temp;
		simetric = !simetric;
	}

	private void balance() {
		int count = 0;
		for (Node<T> aux = last; aux != null; aux = aux.next) 
			count++;
		int half = count / 2;
		Node<T> lastOfLast = null;
		Node<T> toFirst = last;
		for (int i = 0; i <  half; i++) {
			lastOfLast = toFirst;
			toFirst = toFirst.next;
		}
		if (lastOfLast != null) {
			lastOfLast.next = null;
		} else {
			last = null;
		}
		while (toFirst != null) {
			Node<T> aux = toFirst.next;
			toFirst.next = first;
			first = toFirst;
			toFirst = aux;
		}
	}
	
	/** 
	 * Returns representation of queue as a String.
	 */
	@Override
	public String toString() {
    String className = getClass().getSimpleName();
		String s = className+"(";
		String firtsStr = "";
		for (Node<T> node = first; node != null; node = node.next)
			firtsStr += node.elem + (node.next != null ? "," : "");
		String nextStr = "";
		for (Node<T> node = last; node != null; node = node.next)
			nextStr =  node.elem + (nextStr.equals("") ? "" : ",")  + nextStr;
		s += firtsStr + ((!firtsStr.equals(""))?",":"") + nextStr + ")";
		return s;
	}	
	
}
