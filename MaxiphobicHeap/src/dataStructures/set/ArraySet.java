package dataStructures.set;

import java.util.Arrays;
import java.util.Iterator;

public class ArraySet<T> implements Set<T> {

	protected T[] elements;
	protected int nextFree;

	private static final int DEFAULT_INITIAL_CAPACITY = 128;

	@SuppressWarnings("unchecked")
	public ArraySet(int n) {
		elements = (T[]) new Object[n];
		nextFree = 0;
	}

	public ArraySet() {
		this(DEFAULT_INITIAL_CAPACITY);
	}

	@Override
	public boolean isEmpty() {
		return nextFree == 0;
	}

	@SuppressWarnings("unused")
	private void ensureCapacity() {
		if (nextFree >= elements.length) {
			elements = Arrays.copyOf(elements, 2 * elements.length);
		}
	}

	@Override
	public int size() {
		return nextFree;
	}

	@Override
	public void insert(T x) {
		if (!isElem(x)) {
			ensureCapacity();
			elements[nextFree] = x;
			nextFree++;
		}
	}

	@Override
	public boolean isElem(T x) {

		boolean encontrado = false;
		int i = 0;

		while (i < size() && !encontrado) {
			if (elements[i] == x) {
				encontrado = true;
			}
		}
		return encontrado;
	}

	public int buscar(T x) {
		boolean encontrado = false;
		int i = 0;

		while (i < size() && !encontrado) {
			if (elements[i] == x) {
				encontrado = true;
				return i;
			}
		}
		return -1;
	}

	@Override
	public void delete(T x) {

		int i = buscar(x);
		if (i >= -1) {
			for (int j = i; j < size(); j++) {
				elements[j] = elements[j + 1];
			}
			nextFree--;
		} else {
			throw new RuntimeException("Elemento no encontrado");
		}
	}

	@Override
	public String toString() {
		String className = getClass().getName().substring(getClass().getPackage().getName().length() + 1);
		String s = className + "(";
		for (int i = 0; i < nextFree - 1; i++)
			s += elements[i] + (i <  nextFree - 2 ? "," : "");
		s += ")";
		return s;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
