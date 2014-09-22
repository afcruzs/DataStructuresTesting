package taller1;

import static org.junit.Assert.fail;

import java.util.Random;

import javax.swing.text.AsyncBoxView.ChildLocator;

import org.junit.Test;

import unal.datastructures.ArrayLinearList;
import unal.datastructures.ChainTaller1;

public class Point3 {

	private ChainTaller1<Integer> buildList(){
		ChainTaller1<Integer> list = new ChainTaller1<>();
		
		for(int i=0; i<45; i++)
			if(i%2 == 0)
				list.add(0, i);
			else
				list.add(list.size(), i);
		
		for(int i=32; i<=48; i++)
			list.add(0,i);
		
		for(int i=0; i<=5; i++)
			list.add(0,i);
		
		return list;
	}
	
	private void removeStuff(ChainTaller1 list){
		int n = Math.max(1,list.size()/10);
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			list.remove(r.nextInt(list.size()));
		}
	}
	
	@Test
	public void maxElement() {
		ChainTaller1<Integer> list = buildList();
		if( list.maxElement() != 44 );
			fail("Bad Max Element");
	}
	
	@Test
	public void minElement() {
		ChainTaller1<Integer> list = buildList();
		if( list.minElement() != 0 );
			fail("Bad Min Element");
	}
	
	@Test
	public void replace() {
		ChainTaller1<Integer> list = buildList();
		removeStuff(list);
		int idx = list.size()/2;
		int prev = list.get(idx);
		int t = list.replace(idx, 1 << 12);
		
		if(t!=prev) fail("Bad return");
		if( list.get(idx) != (1<<12) )
			fail("Bad replacement");
		
	}
	
	public void reverse(){
		ChainTaller1<Integer> xd = new ChainTaller1<>();
		for (int i = 0; i < 20; i++) {
			xd.add(0, i);
		}
		
		xd.reverse();
		for (int i = 0; i < 20; i++) {
			if( xd.get(i) != i )
				fail("Bad reverse...");
		}
		
	}
	
	@Test
	public void compare(){
		ChainTaller1<Integer> ch = buildList();
		ChainTaller1<Integer> ch2 = buildList();
		if( !ch.compare(ch2) ) fail("Failed comparison");
		removeStuff(ch2);
		ChainTaller1<Integer> ch3 = buildList();
		for (int i = 0; i < ch.size(); i++) {
			ch3.add(0, 4841);
		}
		if( ch.compare(ch3) ) fail("Failed comparison");
	}
	
	@Test
	public void listCopy(){
		/*
		 * Asuma que L es un ArrayLinearList con 
		elementos [1,7,6,5,4,8] y que C es una Chain con elementos [11, 3, 9, 12, 2]. Después 
		del comando L.listCopy(3, C, 1, 2) la lista L contiene [1,7,6,3,9,5,4,8].
		 */
		
		ChainTaller1<Integer> L = new ChainTaller1<>();
		L.add(L.size(),1);
		L.add(L.size(),7);
		L.add(L.size(),6);
		L.add(L.size(),5);
		L.add(L.size(),4);
		L.add(L.size(),8);
		ChainTaller1<Integer> C = new ChainTaller1<>();
		C.add(C.size(), 11);
		C.add(C.size(), 3);
		C.add(C.size(), 9);
		C.add(C.size(), 12);
		C.add(C.size(), 2);
		
		L.listCopy(3, C, 1, 2);
		ArrayLinearList<Integer> goodList = new ArrayLinearList<>();
		goodList.add(goodList.size(), 1);
		goodList.add(goodList.size(), 7);
		goodList.add(goodList.size(), 6);
		goodList.add(goodList.size(), 3);
		goodList.add(goodList.size(), 9);
		goodList.add(goodList.size(), 5);
		goodList.add(goodList.size(), 4);
		goodList.add(goodList.size(), 8);
		
		if( goodList.size() != L.size() ) fail("Bad list copy");
		
		ChainTaller1<Integer> list1 = new ChainTaller1<>();
		ChainTaller1<Integer> list2 = new ChainTaller1<>();
		for(int i=0; i<=5; i++)
			list1.add(list1.size(), i);
		//6-10
		for(int i=11; i<=20; i++)
			list1.add(list1.size(), i);
		
		for(int i=6; i<=10; i++)
			list2.add(list2.size(), i);
		list2.add(list2.size(), 3000);
		list2.add(list2.size(), 3001);
		list2.add(0, 3000);
		list2.add(0, 3001);
		
		list1.listCopy(6, list2, 2, list2.size()-2);
		for(int i=0; i<=20; i++)
			if(list1.get(i) != i)
				fail("Bad list copy");
	}
	
	@Test
	public void rotate(){
		ChainTaller1<Integer> list = new ChainTaller1<>();
		for (int i = 0; i < 10; i++) {
			list.add(list.size(), i);
		}
		
		list.rotate(2);
		if( list.get(0) != 8 || list.get(1) != 9 )
			fail("Bad positive rotation plz");
		for (int i = 2; i < 10; i++) {
			if(list.get(i)!=i-2)
				fail("Bad positive rotation plz");
		}
		
		list.rotate(-2);
		
		for (int i = 0; i < 10; i++) {
			if( list.get(i) != i )
				fail("Bad negative rotation plz");
		}
		
		list.rotate(list.size());
		for(int i=0; i<list.size(); i++){
			if(list.get(i) != i)
				fail("Bad positive complete rotation");
		}
		
		list.rotate(-1*list.size());
		for(int i=0; i<list.size(); i++){
			if(list.get(i) != i)
				fail("Bad negative complete rotation");
		}
		
	}

}
