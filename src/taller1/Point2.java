package taller1;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import unal.datastructures.DoubleLinkedList;

public class Point2 {
	
	@Test
	public void addTest() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
		int n = 50;
		
		Random r = new Random();
		for(int i=n; i>=0; i--){
			list.add(0, i);
		}
		
		for (int i = 0; i <= n; i++) {
			if( i != list.get(i) )
				fail("Failed adding at zero");
		}
		
		list.add( 30, 323 );
		
		if( list.get(30) != 323 ) fail("Failed adding in between");
		
		int t = list.get(21);
		list.add( 20, 58 );
		list.add( 19, 6478 );
		list.add( 30, 6478 );
		
		if( list.get(23) != t ) fail("Failed adding some stuff");
		
		n = 100;
		for (int i = 0; i < n; i++) {
			list.add(list.size(),i);
		}
		
		t = list.get(5);
		/*list.setElement(4, 10);
		if(list.get(4)!=10) fail("Bad set element");
		if(list.get(5)!=t) fail("Bad set element");*/
		
	}
	
	
	@Test
	public void delete() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
		int n = 50;
		for (int i = 0; i < n; i++) {
			list.add(list.size(),i);
		}
		int t = list.get(27);
		list.remove(27);
		if( list.indexOf(27) != -1 )
			fail("Failed removing");
		
		int knownSize= 49;
		while(!list.isEmpty()){
			if(knownSize < 0) fail("did not remove");
			t = list.get(0);
			if( t != list.remove(0) )
				fail("did not return when removing");
			knownSize--;
		}
	}
	
	@Test
	public void indexing() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
		int n = 50;
		for (int i = 0; i < n; i++) {
			list.add(list.size(),i);
		}
		
		if( list.indexOf(30) != 30 ) fail("did not search quite good");
		
		for (int i = 0; i < 50; i++) {
			list.add(0,777);
		}
		
		if( list.indexOf(777) != 0 ) fail("did not search quite good");
	}


}
