package unal.datastructures;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimulatedPointerArrayLinearList<T> implements LinearList<T>,  Iterable<T> {

	protected int firstNode;
	protected int[] next;
	protected T[] element;
	
	
	@SuppressWarnings("unchecked")
	public SimulatedPointerArrayLinearList(){
		firstNode = -1;
		element = ( T[] ) new Object[10];
		next = new int[10];
	}
	
	public void setElement( int index, T theElement){
	//element[index] = theElement;
		add(index,theElement);
	}
	
	public T getElement( int index ){
		return element[index];
	}

	public boolean isEmpty(){
		return firstNode == -1;
	}

	public int size(){
		int count = 0;
		for(int i = 0; i < element.length; i++)
			if(element[i] != null) count++;
		return count;
	}

	void checkIndex(int index){
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException("index = " + index + "  size = " + size());
	}

	
	public T get( int index ){
		checkIndex(index);
		int aux = firstNode;
		for( int i = 0; i < index; i++)
			aux = next[aux];
		return element[aux];
	}

	public int indexOf( T theElement ){
		int aux = firstNode;
		int ans = 0;
		while(aux != -1 && !element[aux].equals(theElement)) {
			aux = next[aux];
			ans++;
		}
		if(aux == -1)
			return -1;
		return ans;
	}

	public T remove( int index ){
		checkIndex(index);
		T removedElement;
		if(index == 0) {
			removedElement = element[firstNode];
			element[firstNode] = null;
			firstNode = next[firstNode];
		}
		else {
			int aux = firstNode;
			for(int i = 0; i < index-1; i++)
				aux = next[aux];
			removedElement = element[next[aux]];
			element[next[aux]] = null;
			next[aux] = next[next[aux]];
		}
		return removedElement;
	}

	public void add(int index, T theElement) {
		if(index < 0 || index > size())
			throw new IndexOutOfBoundsException("index = " + index + "  size = " + size());
		
		if(size() == element.length) {
			int aux = size();
			T[] old = element;
			int[] nold = next;
			element = (T[]) new Object[aux*2];
			next = new int[aux*2];
			System.arraycopy( old, 0, element, 0 , aux);
			System.arraycopy( nold, 0, next, 0 , aux);
		}
		if(index == 0) {
			for(int i = 0; i < element.length; i++) 
				if(element[i] == null) {
					element[i] = theElement; 
					next[i] = firstNode;
					firstNode = i;
					break;
				}
		}
			
		else {
			int previous = firstNode;
			for(int i = 0; i < index-1; i++)
				previous = next[previous];
			for(int i = 0; i < element.length; i++) 
				if(element[i] == null) {
					element[i] = theElement;
					next[i] = next[previous];
					next[previous] = i;
					break;
				}
		}
	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder("[");
		int currentNode = firstNode;
		for(int i = 0; i < size(); i++) {
			str.append(Objects.toString(element[currentNode]) + ", ");
			currentNode = next[currentNode];
		}

		if(size() > 0)
			str.setLength(str.length() - 2);
		str.append("]");
		return str.toString();
	}
	
	public Iterator<T> iterator() {
		return new PointerIterator();
	}
	
	private class PointerIterator implements Iterator{

		int currentNode;
		
		public PointerIterator() {
			currentNode = firstNode;
		}
		@Override
		public boolean hasNext() {
			return currentNode != -1;
		}

		@Override
		public T next() {
			if(currentNode != -1){
				T theElement = element[currentNode];
				currentNode = next[currentNode];
				return theElement;
			}
			else
				throw new NoSuchElementException( "No next element" );
				
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException
				( "remove not supported" );
		}
	}

	public static void main(String[] args) {
		SimulatedPointerArrayLinearList<String> sp = new SimulatedPointerArrayLinearList<>();
		System.out.println(sp.isEmpty());
		sp.add(0, "Cero");
		sp.add(1, "Uno");
		sp.add(2, "Dos");
		sp.add(3, "Tres");
		System.out.println(sp.isEmpty());
		System.out.println(sp);
		System.out.println( sp.indexOf("Cero") );
		sp.remove(0);
		System.out.println(sp);
		sp.add(0, "Cero1");
		sp.add(1, "Uno1");
		sp.add(2, "Dos1");
		sp.add(3, "Tres1");
		sp.add(0, "Cero2");
		sp.add(1, "Uno2");
		sp.add(2, "Dos2");
		sp.add(3, "Tres2");
		System.out.println(sp);
		System.out.println(sp.size());
	}
	
}

