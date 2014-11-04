package taller2Test;

import java.util.Scanner;

import unal.datastructures.taller2.ArrayLinearList;
import unal.datastructures.taller2.LinearList;
import unal.datastructures.taller2.MaxHeap;

public class MyKsumPair {
	LinearList<Integer> a,b;
	public int solve(LinearList<Integer> a, LinearList<Integer> b, int k){
		this.a = a;
		this.b = b;
		MaxHeap<Sum> heap = new MaxHeap<>();

		boolean v[][] = new boolean[a.size()][b.size()];
		
		heap.put( new Sum(0,0) );
		
		Sum max = null;
		for(int i=0; i<k; i++){
			//System.out.println(heap);
			max = heap.removeMax();
			
			if( max.idxa + 1 < a.size() && !v[max.idxa+1][max.idxb] ){
				Sum p = new Sum(max.idxa + 1, max.idxb);
				heap.put( p );
				v[ max.idxa+1 ][ max.idxb ] = true;
			}
			if( max.idxb + 1 < b.size() && !v[max.idxa][max.idxb+1] ){
				Sum p = new Sum(max.idxa, max.idxb + 1);
				heap.put( p );
				v[max.idxa][max.idxb+1] = true;
			}
		}
		//System.out.println("Out!");
		//System.out.println(heap);
		max = heap.removeMax();
		//System.out.println();
		return max.sum;
	}
	
	class Sum implements Comparable<Sum>{
		int idxa, idxb, sum, x,y;
		
		public Sum(int i, int j){
			idxa = i;
			idxb = j;
			x = a.get(i);
			y = b.get(j);
			sum = x+y;
		}
		
		public boolean equals(Object o){
			Sum s  = (Sum)o;
			return x==s.x && y==s.y;
		}
		
		public int hashCode(){
			return (x+y)*(x+y+1)/2+y;
		}

		@Override
		public int compareTo(Sum arg0) {
			return sum - arg0.sum;
		}
		
		public String toString(){
			return x + " + " + y + " = " + sum;
		}
	}
}
