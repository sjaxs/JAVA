package dataStructures.dictionary;

import dataStructures.hashTable.HashTable;
import dataStructures.hashTable.LinearProbingHashTable;
import dataStructures.tuple.Tuple2;

public class HashDictionary<K, V> implements Dictionary<K, V> {

	private HashTable<K,V> dict;
	
	public HashDictionary(){
		dict =  new LinearProbingHashTable <K,V>(20,10);
	}
	@Override
	public boolean isEmpty() {
		return dict.isEmpty();
	}

	@Override
	public int size() {
		return dict.size();
	}

	@Override
	public void insert(K k, V v) {

		dict.insert(k, v);
	}

	@Override
	public V valueOf(K k) {
		return dict.search(k);
	}

	@Override
	public boolean isDefinedAt(K k) {
		return dict.isElem(k);
	}

	@Override
	public void delete(K k) {

		dict.delete(k);
	}

	@Override
	public Iterable<K> keys() {
		return dict.keys();
	}

	@Override
	public Iterable<V> values() {
		return dict.values();
	}

	@Override
	public Iterable<Tuple2<K, V>> keysValues() {
		return dict.keysValues();
	}

}
