package taller2Test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.junit.Test;

import unal.datastructures.taller2.ArrayLinearList;
import unal.datastructures.taller2.LinearList;
import unal.datastructures.taller2.KSumPair;

public class Point3 {

	@Test
	public void ksumpair() {
		
		FileInputStream st = null;
		FileInputStream ansStream = null;
		try {
			st = new FileInputStream(new File("dataset.txt"));
			ansStream = new FileInputStream(new File("outksum.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(st));
		BufferedReader inAns = new BufferedReader(new InputStreamReader(ansStream));
		int cases,m,k,t;
		String s;
		try{
			cases = Integer.parseInt(in.readLine());
			//System.out.println(n);
			for(int xd=0; xd<cases; xd++){
				LinearList<Integer> a = new ArrayLinearList<Integer>();
				LinearList<Integer> b = new ArrayLinearList<Integer>();
				
				String[] lel = in.readLine().split(" ");
				m =Integer.parseInt(lel[0]);
				k =Integer.parseInt(lel[1]);
				
				
				lel = in.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					a.add(a.size(), Integer.parseInt(lel[j]));
				}
				
				lel = in.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					b.add(b.size(), Integer.parseInt(lel[j]));
				}
				//System.out.println(a);
				//System.out.println(b);
				KSumPair ksum = new KSumPair();
				int theAns = Integer.parseInt(inAns.readLine());
				if( ksum.solve(a, b, k) != theAns )
				//if( KSumPair.solve(a, b, k) != theAns )
					fail(ksum.solve(a, b, k)+" " +theAns);
				in.readLine();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
