package unal.datastructures;

import java.io.*;
import java.util.*;

public class SimulatedPointerArrayLinearList<T extends Serializable & Comparable<? super T>> implements LinearListImproved<T>
{
	//fields
	protected T[] element;
	protected int[] next;
	protected int firstNode;
	protected int size;
	
	//Constructors
	@SuppressWarnings( "unchecked" )
	public SimulatedPointerArrayLinearList( int initialCapacity )
	{
		if ( initialCapacity < 1 )
			throw new IllegalArgumentException
				( "initialCapacity must be >= 1" );
		element = ( T[ ] ) new Serializable[ initialCapacity ];
		next = new int[ initialCapacity ];
		firstNode = -1;
		size = 0;
	}
	
	public SimulatedPointerArrayLinearList( )
	{
		this ( 10 );
	}
	
	//Methods
	public boolean isEmpty( )
	{
		return size == 0;
	}
	
	public int size( )
	{
		return size;
	}
	
	void checkIndex( int index )
	{
	   if( index < 0 || index >= size )
	      throw new IndexOutOfBoundsException
	         ( "index = " + index + "  size = " + size );
	}
	
	public T get( int index )
	{
		checkIndex( index );
		int currentNode = firstNode;
	    for( int i = 0; i < index; i++ )
	       currentNode = next[ currentNode ];

	    return element[ currentNode ];
	}
	
	public int indexOf( T theElement )
	{
		int currentNode = firstNode;
		int index = 0;  
	    while( currentNode != -1 &&
	           !element[ currentNode ].equals( theElement ) )
		    {
		       currentNode = next[ currentNode ];
		       index = currentNode;
		    }	
	      
	    if( currentNode == -1 )
	       return -1;
	    else
	       return index;
	}
	
	public T remove( int index )
	{
		checkIndex( index );
		T removedElement;
		if ( index == 0 )
		{
			int temp = firstNode;
			removedElement = element [ firstNode ];
			firstNode = next [ firstNode ];
			next [ temp ] = -2;
			element [ temp ] = null;

		}
		else
		{
			int currentNode = firstNode;
			for (int i = 0; i < index - 1; i ++ )
				currentNode = next [ currentNode ];
			
			int temp = next[ next[ currentNode ] ];
			removedElement = element[ next[ currentNode ] ];
			next[ next[ currentNode ] ] = -2;
			element [ next[ currentNode ] ] = null;
			
			if ( index == size - 1 )
			{
				
				next [ currentNode ] = -1;
			}
			else
			{
				next[ currentNode ] = temp;
			}
		}		
	    
		size--;
	    return removedElement;
	}
	
	@SuppressWarnings ( "unchecked" )
	public void add( int index, T theElement )
	{
		if( index < 0 || index > size )
	         throw new IndexOutOfBoundsException
	            ( "index = " + index + "  size = " + size );

		if ( size == element.length )
		{
			T[] oldElement = element;
			int[] oldNext = next;
			element = ( T[] ) new Serializable[ 2 * size ];
			next = new int[ 2 * size ];
			System.arraycopy(oldElement, 0, element, 0, size);
			System.arraycopy(oldNext, 0, next, 0, size);
		}
		
		int vacio = 0;
		while ( element[ vacio ] != null )
			vacio++;
		element[ vacio ] = theElement;
		
		if ( index == 0 )
		{
			if ( size == 0 )
				next[ vacio ] = -1;
			else 
				next[ vacio ] = firstNode;
			firstNode = vacio;
		}
		else
		{
			int currentNode = firstNode;
			for ( int i = 0; i < index - 1; i++ )
				currentNode = next[ currentNode ];
			
			if ( index == size )
			{
				next[ currentNode ] = vacio;
				next [ vacio ] = -1;
			}
			else
			{
				next[ vacio ] = next [ currentNode ];
				next[ currentNode ] = vacio;
			}
		}
	    size++;
	}
	
	public String toString( )
	{
		StringBuilder s = new StringBuilder( "[ " );

		int currentNode = firstNode;
		for ( int i = 0; i < size; i++ )
		{
			s.append( Objects.toString( element[ currentNode ] ) + ", " );
			currentNode = next[ currentNode ];
		}
		
		if( size > 0 )
		       s.setLength( s.length( ) - 2 );  // remove last ", "

		    s.append( " ]" );
		
	    return new String( s );
	}
	
	public void save( String fn )
	{	
	    try( ObjectOutputStream os = new
	            ObjectOutputStream( new FileOutputStream( fn ) ) )
	          {
	            os.writeInt( size );
	            
	            int currentNode = firstNode;
	            for(int i = 0; i < size; i++)
	            {
	            	os.writeObject( element[ currentNode ] );
	            	currentNode = next[ currentNode ];
	            }
	          }
	       catch( IOException e )
	       {
	          e.printStackTrace( );
	       }
	       System.out.println( "Save done" );		
	}
	
	@SuppressWarnings ( "unchecked" )
	public void load( String fn )
	{	
	    try( ObjectInputStream is = new
	            ObjectInputStream( new FileInputStream( fn ) ) )
	          {
	             size = is.readInt( );
	             int cont = size;
	             
	             for( int i = 0; i < cont; i++ )
	             {
	            	 add( i, ( T ) is.readObject( ) );
	             }
	          }
	       catch( IOException | ClassNotFoundException e )
	       {
	          e.printStackTrace( );
	       }
	    size = size / 2;
	    System.out.println( "Load done" );		
	}
	
	public void sort( )
	{
	   Arrays.sort( element, 0, size );
	}

	public void sort( Comparator<T> c )
	{
	   Arrays.sort( element, 0, size, c );
	}
	
	public static void main(String[] args) 
	{
		SimulatedPointerArrayLinearList<Integer> s =
				new SimulatedPointerArrayLinearList<>( );
		
		System.out.println(s);
		System.out.println("\nisEmpty: " + s.isEmpty( ) );
		
		s.add( 0,2 );
		s.add( 0,22 );
		s.add( 0,12 );
		s.add( 0,23 );
		s.add( 0,1 );	
		s.add( 0,0 );
		s.add( 0,3 );

		System.out.println("\n" + s );
		
		System.out.println("isEmpty: " + s.isEmpty( ) );
		
		s.add( 1,3 );
		
		System.out.println("\n add 3 en pos 1 : \n" + s );
		
		s.add( 8,32 );
		
		System.out.println("\n add 32 en pos 8 : \n" + s );
		
		s.add( 5,13 );
		
		System.out.println("\n add 13 en pos 5 : \n" + s );
		
		s.add( 0,54 );
		System.out.println("\n add 54 en pos 0 : \n" + s );
		
		System.out.println("\n Borrado de posicion 0: " + s.remove( 0 ) );
		System.out.println( s );
		
		System.out.println("\n Borrado de posicion 8: " + s.remove( 8 ) );
		System.out.println( s );
		
		System.out.println("\n Borrado de posicion 3: " + s.remove( 3 ) );
		System.out.println( s );
		
		s.save( "Pointer.txt" );
		SimulatedPointerArrayLinearList<Integer> x =
				new SimulatedPointerArrayLinearList<>( );
		
		x.load( "Pointer.txt" );
		System.out.println( x );
		
		x.add( 5,13 );
		
		System.out.println("\n add 13 en pos 5 : \n" + x );
		System.out.println("\n indexOf 13 : \n" + x.indexOf( 13 ) );
		System.out.println("\n get 3 : \n" + x.get( 3 ) );
	}
}