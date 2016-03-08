package dataStructures.set;

import java.util.Iterator;

public class LinkedSet<T> implements Set<T> {
	
	@SuppressWarnings("unused")
	static private class Node<E> {
		
		E elem;
		Node<E> next;
		Node<E> prev;
		public Node(E x, Node<E> node) {
			elem = x;
			next = node;			
		}
		public Node(E x) {
			elem = x;
			next = null;			
		}
	}

	private Node first, last;
	
	public LinkedSet(){
		first = null;
		last = null;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public int size() {
		Node n = first;
		int i = 0;
		if(isEmpty()){
			return 0;
		}
		while(n.next != null ){
			i++;
		}
		return i;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(T x) {
		Node<T> n = new Node<T>(x);
		if(isEmpty()){
			
			first = n;
			last = n;
			
		}else{
			n.prev =last;
			last.next = n;
			last = n;
		}
		
	}

	@Override
	public boolean isElem(T x) {
		Node n = first;
		boolean encontrado = false;
		while(n.next != null && !encontrado){
			if(n.elem == x){
				encontrado = true;
			}else{
				n = n.next;
			}
		}
		return encontrado;
	}

	@Override
	public void delete(T x) {

		if(isElem(x)){
			Node n = first;
			boolean encontrado = false;
			while(!encontrado){
				if(n.elem == x){
					encontrado = true;
					n.prev.next = n.next;
					n.next.prev = n.prev;
				}else{
					n = n.next;
				}
			}
		}
	}

}
