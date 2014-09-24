package unal.datastructures;

import java.util.LinkedList;

public class DoubleLinkedList<T> implements LinearList<T> {
	
	LinkedList<T> list;
	public DoubleLinkedList(){
		list = new LinkedList<>();
	}
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return list.get(index);
	}

	@Override
	public int indexOf(T theElement) {
		// TODO Auto-generated method stub
		return list.indexOf(theElement);
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return list.remove(index);
	}

	@Override
	public void add(int index, T theElement) {
		list.add(index,theElement);
	}

}
