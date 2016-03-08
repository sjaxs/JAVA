/**
 * @author Pepe Gallardo, Data Structures, Grado en Informática. UMA.
 *
 * Doubly linked implementation of a double ended queue, dqueue or deque
 */

package dataStructures.doubleEndedQueue;

public class LinkedDoubleEndedQueuePepe<T> implements DoubleEndedQueue<T> {

	private static class Node<E> {
		private E elem;
		private Node<E> next;
		private Node<E> prev;

		public Node(E x, Node<E> nxt, Node<E> prv) {
			elem = x;
			next = nxt;
			prev = prv;
		}		
	}

	/* Invariants:
	 *  if queue is empty then first is null
	 *  if queue is non-empty:
	 *  	* first is ref to first node and last is ref to last node
	 *  	* first.prev is null
	 *  	* last.next is null
	 *  	* rest of nodes are doubly linked
	 */
	
	private Node<T> first, last;
	
	public LinkedDoubleEndedQueuePepe() {
		first = null;
	}
	
	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public void addFirst(T x) {
		Node<T> node = new Node<>(x,first,null);
		if(isEmpty()) 
			last = node; // first insertion; result is singleton queue
		else 
			first.prev = node; // link previous front node to new one
		first = node;
	}

	@Override
	public void addLast(T x) {
		Node<T> node = new Node<>(x,null,last);
		if(isEmpty()) {
			first = node; // first insertion; result is singleton queue
			node.prev = null;
		} else
			last.next = node; // link previous last node to new one
		last = node;
		
	}

	@Override
	public T first() {
		if(isEmpty())
			throw new EmptyDoubleEndedQueueException("first on empty double ended queue");
		else
			return first.elem;
	}

	@Override
	public T last() {
		if(isEmpty())
			throw new EmptyDoubleEndedQueueException("last on empty double ended queue");
		else
			return last.elem;
	}

	@Override
	public void deleteFirst() {
		if(isEmpty())
			throw new EmptyDoubleEndedQueueException("deleteFirst on empty double ended queue");
		else {
			first = first.next;
			if(first != null)
				first.prev = null; // first is now new first linked node
		}
	}

	@Override
	public void deleteLast() {
		if(isEmpty())
			throw new EmptyDoubleEndedQueueException("deleteLast on empty double ended queue");
		else {
			last = last.prev;
			if(last == null)
				first = null; // queue has become empty
			else
				last.next = null; // last is now new last linked node
		}
		
	}

	/** 
	 * Returns representation of queue as a String.
	 */
	@Override
	public String toString() {
    String className = getClass().getSimpleName();
		String s = className+"(";
		for (Node<T> node = first; node != null; node = node.next)
			s += node.elem + (node.next != null ? "," : "");
		s += ")";
		return s;
	}	
	
	
}
