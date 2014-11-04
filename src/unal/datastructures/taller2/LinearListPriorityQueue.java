package unal.datastructures.taller2;
import java.util.*;


public class LinearListPriorityQueue<T extends Comparable<? super T>> implements MaxPriorityQueue<T>{
/////////////////////////////   SIZE   /////////////////////////////
	int front;
	int rear;
	int size;
	T[] queue;
/////////////////////////   CONSTRUCTORS   /////////////////////////
	@SuppressWarnings( "unchecked" )
	public LinearListPriorityQueue(int initialCapacity){
		if( initialCapacity < 1 )
			throw new IllegalArgumentException( "initialCapacity must be >= 1" );
		queue = ( T[] ) new Comparable[ initialCapacity + 1 ];
		front = rear = 0;
	}
	public LinearListPriorityQueue(){
		this(10);		
	}
////////////////////////////   METHODS   ///////////////////////////	
	public boolean isEmpty(){
		return size==0;
	}
	public int size(){
		return size;
	}
	public T getMax(){
		if (size==0) throw new IllegalArgumentException("La cola esta vacía");
		T max= queue[0];
		for (int i=1; i<size;i++){
			if (queue[i].compareTo(max)>0) max=queue[i];
		}
		return max;
	}
	@SuppressWarnings( "unchecked" )
	public void put (T theObject){
		if( ( rear + 1 ) % queue.length == front ){
			T[] newQueue = ( T[] ) new Comparable [ 2 * queue.length ];
			int start = ( front + 1 ) % queue.length;
			if( start < 2 )System.arraycopy( queue, start, newQueue, 0, queue.length - 1 );
			else{
				System.arraycopy( queue, start, newQueue, 0, queue.length - start );
				System.arraycopy( queue, 0, newQueue, queue.length - start, rear + 1 );
			}
			front = newQueue.length - 1;
			rear = queue.length - 2;
			queue = newQueue;
		}
		rear = ( rear + 1 ) % queue.length;
		queue[ rear ] = theObject;
		size++;
	}
	public T removeMax(){
		if (size==0) throw new IllegalArgumentException("La cola esta vacÃ­a");
		T max= queue[0];
		int id = 0;
		for (int i=1; i < size;i++){
			if (queue[i].compareTo(max)>0){
			       	max=queue[i];
				id = i;
			}
		}
		size--;
		for( int i = id; i < size;i++ )
			queue[i] = queue[i+1];
		return max;
	}
	
	@Override
	public String toString( ){
		StringBuilder s = new StringBuilder( );
		s.append( "The " + size + " elements are [ " );
		if( size > 0 ){
			s.append( Objects.toString( queue[ 0 ] ) );
			for( int i = 1; i < size; i++ )
				s.append( ", " + Objects.toString( queue[ i ] ) );
		}
		s.append( " ]" );
		return new String( s );
	}
//////////////////////////////   MAIN   /////////////////////////////	
	public static void main( String[] args ){
		LinearListPriorityQueue< Integer > q = new LinearListPriorityQueue<>( 3 );
		/////////////////////// FASE 1 ///////////////////////
		int j=0;
		Random ale= new Random();
		long time = System.currentTimeMillis();
		for (int i=0; i<100000;i++){
			j=(int) (ale.nextDouble() * 100000000+1);
			q.put(new Integer(j));
		}
		time = System.currentTimeMillis() - time;
		System.out.println("El tiempo de la Fase 1 en micro segundos fue: " + time);
		// System.out.println( q );
		/////////////////////// FASE 2 ///////////////////////
		long time2 = System.currentTimeMillis();
		for (int i=0; i<50000;i++){
			q.removeMax();
			q.getMax();
		}
		time2 = System.currentTimeMillis() - time2;
		System.out.println("El tiempo de la Fase 2 en micro segundos fue: " + time2);
	}
}