package dataStructures.bag;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import dataStructures.hashTable.HashTable;
import dataStructures.hashTable.LinearProbingHashTable;

public class HashBag<T extends Comparable<? super T>> implements  Bag<T>{

	private final static int INITIAL_CAPACITY = 5;
	 protected HashTable<T, Integer> elements;
	 
	 public HashBag (int n){
		 elements = new LinearProbingHashTable<T, Integer>(2*INITIAL_CAPACITY, INITIAL_CAPACITY);
	 }
	 
	 
	@Override
	public Iterator<T> iterator() {
		return new HashBagIterator();
	}

	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	
	@Override
	public void insert(T item) {

		if(!elements.isElem(item)){
			elements.insert(item, 1);
		}else{
			elements.insert(item, occurrences(item)+1);
		}
	}

	@Override
	public int occurrences(T item) {

		if(elements.search(item)==null)
			return 0;
		return elements.search(item);
	}

	@Override
	public void delete(T item) {

		elements.delete(item);
	}


private class HashBagIterator implements Iterator<T>{
		
		T current;
		int ocurrencias;
		
		public HashBagIterator(){
			current = 0;
			ocurrencias = 0;
		}

		@Override
		public boolean hasNext() {
			boolean next = false;
			if(current != nextFree && ocurrencias >0){
				ocurrencias--;
				next = true;
			}else if(current != nextFree && ocurrencias == 0){
				current++;
				ocurrencias = count[current];
				next = current != nextFree;
			}
			return next;
		}

		@Override
		public T next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			return value[current];
		}
		
	}
}
