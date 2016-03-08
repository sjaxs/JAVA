package dataStructures.priorityQueue;

import dataStructures.heap.WBLeftistHeap;

/**
 * Priority queue with a Weight Biased Leftist Heap. 
 * SIFO + FIFO version
 * @param <T>
 */
public class WBLeftistHeapPriorityQueueFIFO<T extends Comparable<? super T>> implements PriorityQueue<T> {

	private WBLeftistHeap<Node<T>> heap;
	
	private static class Node<S extends Comparable<? super S>> implements Comparable<Node<S>> {
		S data;
		int stamp;
		static int stampGen = 0; 
		public Node(S data) {
			this.data = data;
			stamp = stampGen++;
		}
		public int compareTo(Node<S> node) {
			int res = data.compareTo(node.data);
			if (res == 0) {
				res = new Integer(stamp).compareTo(node.stamp);
			}
			return res;
		}
	}
	
	/**
	 * Creates an empty queue.
	 */	
	public WBLeftistHeapPriorityQueueFIFO() {
		heap = new WBLeftistHeap<>();
	}
	
	/** 
	 * {@inheritDoc}
	 * <p>Time complexity: O(1)
	 */
	public boolean isEmpty() {
		return heap.isEmpty();
	}

	/** 
	 * {@inheritDoc}
	 * Position of new element in queue depends on its priority.
	 * The less the value of the element, the higher its priority. 
	 * <p>Time complexity: O(log n)
	 */
	public void enqueue(T x) {
		heap.insert(new Node<>(x));
	}

	/** 
	 * {@inheritDoc}
	 * <p>Time complexity: O(1)
	 * @throws <code>EmptyQueueException</code> if queue stores no element.
	 */
	public T first() {
		if(isEmpty())
			throw new EmptyPriorityQueueException("first on empty priority queue");
		else
			return heap.minElem().data;
	}

	/** 
	 * {@inheritDoc}
	 * Position of new element in queue depends on its priority.
	 * The less the value of the element, the higher its priority. 
	 * <p>Time complexity: O(log n)
	 */
	public void dequeue() {
		if(isEmpty())
			throw new EmptyPriorityQueueException("dequeue on empty priority queue");
		else
			heap.delMin();
	}		
	
	/** 
	 * Returns representation of priority queue as a String.
	 */
	@Override public String toString() {
		WBLeftistHeap<Node<T>> clonedHeap = new WBLeftistHeap<>(heap);
		String className = getClass().getSimpleName();
		String s = className+"(";
		boolean stop = clonedHeap.isEmpty();
		while(!stop) {
			s += clonedHeap.minElem().data;
			clonedHeap.delMin();
			stop = clonedHeap.isEmpty();
			if(!stop)
				s += ",";
		}
		s += ")";
		return s;			
	}	

}
