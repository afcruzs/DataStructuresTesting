package taller1;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import unal.datastructures.LinearListImproved;
import unal.datastructures.SimulatedPointerArrayLinearList;

public class Point1 {

	@Test
	public void addTest() {
		SimulatedPointerArrayLinearList<Integer> list = new SimulatedPointerArrayLinearList<>();
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
	public void saveAndLoad(){
		LinearListImproved<Integer> list = new SimulatedPointerArrayLinearList<>();
		for(int i=0; i<10; i++)
			list.add(0, i);
		
		list.save("plz");
		LinearListImproved<Integer> list2 = new SimulatedPointerArrayLinearList<>();
		list.load("plz");
		
		if( list.size() != list2.size() ) fail("Different size when loading a saved list");
		for(int i=0; i<10; i++){
			if (list.get(i) != list2.get(i))
				fail("Different element when comparing loaded and saved");
		}
	}
	
	@Test
	public void sort(){
		SimulatedPointerArrayLinearList<Integer> list = new SimulatedPointerArrayLinearList<>();
		for(int i=0; i<10; i++)
			list.add(0, i);
		
		
		list.add(0, 9);
		list.sort();
		
		for (int i = 0; i < 10; i++) {
			if( list.get(i) != i ) fail("Failed sorting");
		}
		
		if( list.get(list.size()-1) != 9 ) fail("Failed sorting");
	}
	
	@Test
	public void delete() {
		SimulatedPointerArrayLinearList<Integer> list = new SimulatedPointerArrayLinearList<>();
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
		SimulatedPointerArrayLinearList<Integer> list = new SimulatedPointerArrayLinearList<>();
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
