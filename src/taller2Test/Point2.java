package taller2Test;

import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;

import unal.datastructures.taller2.LinearListPriorityQueue;
import unal.datastructures.taller2.MaxHeap;
import unal.datastructures.taller2.MaxPriorityQueue;

public class Point2 {

	@Test
	public void put() {
		MaxPriorityQueue<Integer> pq = buildQueue();
		int times = new Random().nextInt(1444);
		while(times-- > 0){
			pq.put( new Random().nextInt(89709870) );
		}
	}
	
	@Test
	public void sizeAndIsEmpty(){
		MaxPriorityQueue<Integer> pq = new LinearListPriorityQueue();
		if( !pq.isEmpty() )
			fail();
		
		for( int i=0; i<140; i++ )
			pq.put( 233 );
		
		if( pq.size() != 140 || pq.isEmpty() )
			fail();
	}
	
	@Test
	public void getAndRemove(){
		MaxPriorityQueue<Integer> pq = new LinearListPriorityQueue();
		for(int i=149; i>=100; i--)
			pq.put(i);
		
		for(int i=0; i<100; i++)
			pq.put( i );
		
		for( int i=200; i >= 150; i-- )
			pq.put(i);
		
		int ans = 200;
		while( pq.size() > 0 ){
			if( pq.getMax() != ans )
				fail(pq.getMax() + " " + ans);
			if( pq.removeMax() != ans )
				fail();
			ans--;
		}
	}
	
	private MaxPriorityQueue<Integer> buildQueue(){
		MaxPriorityQueue<Integer> pq = new LinearListPriorityQueue();
		pq.put(45);
		for (int i = 0; i <= 50; i++) {
			pq.put(i);
		}
		pq.put(32);
		pq.put(42);
		pq.put(34);
		pq.put(50);
		return pq;
	}

}
