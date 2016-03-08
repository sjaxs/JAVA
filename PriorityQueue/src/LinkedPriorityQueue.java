

public class LinkedPriorityQueue <T extends Comparable <? super T>> implements PriorityQueue<T> {

	private static class Node <E>{
		
		E value;
		Node<E> next;
		
		public Node (E x){
			
			value = x;
			next = null;
		}
	}
	
	private Node<T> first;
	private int size;

	public LinkedPriorityQueue() {
		first = null;
		size = 0;
	}
	
	@Override
	public void enqueue(T elem) {
		
		Node<T> n = new Node<T>(elem);
		if(isEmpty()){
			first = n;
		}else if(n.value.compareTo(first.value)<0) { // x<first.elem. x has highest priority
			n.next = first;
			first = n;
		}else{
			Node<T> prev = null;
			Node<T> aux = first;
			boolean encontrado = false;
			int i = 0;
			while(i < size && !encontrado){
				if((aux.value).compareTo(n.value)>=0){
					i++;
					prev = aux;
					aux = aux.next;
				}else{
					prev.next= n;
					n.next = aux;
					encontrado = true;
				}
				
			}
		}
		size++;
		
	}

	public void dequeue() {
		if(isEmpty()){
			throw new RuntimeException("Dequeue on empty queue");
		
		}else{
			first = first.next;
			size--;
		}
		
	}

	public T first() {
		if(isEmpty())
			throw new RuntimeException("first on empty priority queue");
		else
			return first.value;
	}

	public boolean isEmpty() {
		return size == 0;
	}

}
