
public class LinkedNOPriorityQueue <T extends Comparable <? super T>> implements PriorityQueue<T> {

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

	public LinkedNOPriorityQueue() {
		first = null;
		size = 0;
	}
	
	@Override
	public void enqueue(T elem) {
		
		Node<T> n = new Node<T>(elem);
		if(isEmpty()){
			first = n;
		}else{
			
			n.next = first;
			first = n;
		}
		
	}
	
	protected Node<T> minimo(){
		Node<T> aux =  first.next;
		Node<T> minimo = first;
		for(int i = 0;i <size;i++){
			if(minimo.value.compareTo(aux.value)>0){
				minimo = aux;
				aux=aux.next;
			}
		}
		return minimo;
	}

	public void dequeue() {
		
		Node<T> m = minimo();
		
		if(isEmpty()){
			throw new RuntimeException("Dequeue on empty queue");
		
		}else if(m.value.compareTo(first.value) == 0) { 

			first = first.next;
			size--;
		}else{
			Node<T> prev = null;
			Node<T> aux = first.next;
			boolean encontrado = false;
			int i = 0;
			while(i<size && !encontrado){
				if(aux.value.compareTo(m.value) == 0){
					prev.next = aux.next;
					size--;
					encontrado = true;
				}
				i++;
			}
		}
		
	}

	public T first() {
		if(isEmpty())
			throw new RuntimeException("first on empty priority queue");
		else
			return minimo().value;
	}

	public boolean isEmpty() {
		return size == 0;
	}

}
