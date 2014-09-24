package unal.datastructures;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ChainTaller1<T extends Object & Comparable<? super T>>  extends ArrayLinearList<T> {
	
	public T maxElement(){
		T max = get(0);
		for(T xd : this){
			if(xd.compareTo(max) > 0)
				max = xd;
		}
		
		return max;
		
	}
	
	public T minElement(){
		T min = get(0);
		for(T xd : this){
			if(xd.compareTo(min) < 0)
				min = xd;
		}
		
		return min;
	}
	
	public void reverse(){
		ChainTaller1<T> lel = new ChainTaller1<>();
		for(int i=0; i<size(); i++){
			lel.add(0, remove(i));
		}
		
		for(T xd : lel){
			add(size(),xd);
		}
	}
	
	public T replace( int idx, T t ){
		T lel = get(idx);
		remove(idx);
		add(idx,t);
		return lel;
	}
	
	public boolean compare(LinearList<T> otro){
		if(otro.size() != size()) return false;
		for(int i=0; i<otro.size(); i++)
			if( get(i) != otro.get(i) )
				return false;
		
		return true;
	}
	
	public void suffle(){
		
	}
	
	public void listCopy(int index1, LinearList<T> otro, int index2, int size){
		for (int i = size-1; i >= 0; i--) {
			add( index1, otro.get(i+index2) );
		}
	}
	
	public void rotate(int pos){
		if(pos > 0){
			while(pos > 0){
				T xd = remove(size()-1);
				add(0,xd);
				pos--;
			}
		}else if(pos < 0){
			pos = -1*pos;
			while(pos > 0){
				T xd = remove(0);
				add(size(),xd);
				pos--;
			}
		}
	}
	
}
