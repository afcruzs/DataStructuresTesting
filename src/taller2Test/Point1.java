package taller2Test;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import unal.datastructures.taller2.LinkedBinaryTree;
import unal.datastructures.taller2.MyLBT;
import unal.datastructures.taller2.StructureChecker;

public class Point1 {

	@Test
	public void brother() {
		
		MyLBT<Character> dummy = new MyLBT<>();
		MyLBT<Character> a = new MyLBT<>();
		MyLBT<Character> b = new MyLBT<>();
		MyLBT<Character> c = new MyLBT<>();
		MyLBT<Character> d = new MyLBT<>();
		MyLBT<Character> e = new MyLBT<>();
		MyLBT<Character> f = new MyLBT<>();
		MyLBT<Character> g = new MyLBT<>();
		
		d.makeTree('D', dummy, dummy);
		e.makeTree('E', dummy, dummy);
		g.makeTree('G', dummy, dummy);
		f.makeTree('F', g, dummy);		
		c.makeTree('C',f,dummy);
		b.makeTree('B', d, e);
		a.makeTree('A', b, c);
		
		if( a.brother('G') != null )
			fail("Fallo ");
		
		if( a.brother('F') != null )
			fail("Fallo ");
		
		if( !a.brother('B').equals('C') )
			fail("Fallo ");
		
		if( !a.brother('C').equals('B') )
			fail("Fallo ");
		
		if( !a.brother('D').equals('E') )
			fail("Fallo ");
		
		if( !a.brother('E').equals('D') )
			fail("Fallo ");
		
		if( b.brother('B') != null )
			fail();
		
		if( !b.brother('E').equals('D') )
			fail();
		
		if( a.brother('A') != null )
			fail("Fallo ");
		
		MyLBT<Character> justRoot = new MyLBT<>();
		
		justRoot.makeTree('x', dummy, dummy);
		
		MyLBT<Character> y = new MyLBT<>();
		MyLBT<Character> z = new MyLBT<>();
		y.makeTree('y', dummy, dummy);
		z.makeTree('z', y, dummy);
		
		if( y.brother('y') != null )
			fail();
		
		
		if( justRoot.brother('x') != null )
			fail("Fallo ");
		
	}
	
	private MyLBT<Character> buildTestTree(){
		MyLBT<Character> dummy = new MyLBT<>();
		MyLBT<Character> a = new MyLBT<>();
		MyLBT<Character> b = new MyLBT<>();
		MyLBT<Character> c = new MyLBT<>();
		MyLBT<Character> d = new MyLBT<>();
		MyLBT<Character> e = new MyLBT<>();
		MyLBT<Character> f = new MyLBT<>();
		MyLBT<Character> g = new MyLBT<>();
		
		d.makeTree('D', dummy, dummy);
		e.makeTree('E', dummy, dummy);
		g.makeTree('G', dummy, dummy);
		f.makeTree('F', g, dummy);		
		c.makeTree('C',f,dummy);
		b.makeTree('B', d, e);
		a.makeTree('A', b, c);
		
		return a;
	}
	
	private LinkedBinaryTree<Character> buildLinkedTestTree(){
		LinkedBinaryTree<Character> dummy = new LinkedBinaryTree<>();
		LinkedBinaryTree<Character> a = new LinkedBinaryTree<>();
		LinkedBinaryTree<Character> b = new LinkedBinaryTree<>();
		LinkedBinaryTree<Character> c = new LinkedBinaryTree<>();
		LinkedBinaryTree<Character> d = new LinkedBinaryTree<>();
		LinkedBinaryTree<Character> e = new LinkedBinaryTree<>();
		LinkedBinaryTree<Character> f = new LinkedBinaryTree<>();
		LinkedBinaryTree<Character> g = new LinkedBinaryTree<>();
		
		d.makeTree('D', dummy, dummy);
		e.makeTree('E', dummy, dummy);
		g.makeTree('G', dummy, dummy);
		f.makeTree('F', g, dummy);		
		c.makeTree('C',f,dummy);
		b.makeTree('B', d, e);
		a.makeTree('A', b, c);
		
		return a;
	}
	
	
	
	@Test
	public void shuffle() {
		MyLBT<Character> tree = buildTestTree();
		StructureChecker<Character> checker1 = new StructureChecker<Character>( tree );
		int[] structure1 = checker1.structure();
		List<Character> list1 = checker1.getElements();
		tree.shuffle();
		
		checker1 = new StructureChecker<Character>( tree );
		int[] structure2 = checker1.structure();
		List<Character> list2 = checker1.getElements();
		
		boolean equalStructure = Arrays.equals(structure1, structure2);
		boolean sameOrder = list1.equals(list2);
		Collections.sort(list1);
		Collections.sort(list2);
		boolean sameElements = list1.equals(list2);
		
		if( !(equalStructure && !sameOrder && sameElements) )
			fail();
		
	}
	
	@Test
	public void iterative(){
		MyLBT<Character> tree = buildTestTree();
		LinkedBinaryTree<Character> linkedTree = buildLinkedTestTree();
		
		tree.preOrderOutput();
		System.out.println();
		linkedTree.preOrderOutput();
		
		System.out.println("\n");
		
		tree.postOrderOutput();
		System.out.println();
		linkedTree.postOrderOutput();
		
		System.out.println("\n");
		
		tree.inOrderOutput();
		System.out.println();
		linkedTree.inOrderOutput();
	}
	
	@Test
	public void diameter(){
		MyLBT<Character> dummy = new MyLBT<>();
		MyLBT<Character> e = new MyLBT<>();
		MyLBT<Character> f = new MyLBT<>();
		MyLBT<Character> g = new MyLBT<>();
		MyLBT<Character> h = new MyLBT<>();
		MyLBT<Character> d = new MyLBT<>();
		MyLBT<Character> b = new MyLBT<>();
		MyLBT<Character> c = new MyLBT<>();
		MyLBT<Character> a = new MyLBT<>();
		
		
		e.makeTree('e', dummy, dummy);
		f.makeTree('f', dummy, dummy);
		g.makeTree('g', dummy, dummy);
		h.makeTree('h', dummy, dummy);
		
		d.makeTree('d', e, f);
		c.makeTree('c', g, h);
		b.makeTree('b', d, dummy);
		a.makeTree('a', b, c);
		
		if( a.diameter() != 6 )
			fail();
		
		if( b.diameter() != 3 )
			fail();
		
		if( e.diameter() != 1 )
			fail();
		
		MyLBT<Character> i = new MyLBT<>();
		MyLBT<Character> j = new MyLBT<>();
		MyLBT<Character> k = new MyLBT<>();
		MyLBT<Character> l = new MyLBT<>();
		MyLBT<Character> m = new MyLBT<>();
		MyLBT<Character> n = new MyLBT<>();
		MyLBT<Character> o = new MyLBT<>();
		MyLBT<Character> p = new MyLBT<>();
		
		o.makeTree('o', dummy, dummy);
		p.makeTree('p', dummy, dummy);
		
		m.makeTree('m', o, dummy);
		k.makeTree('k', m, dummy);
		i.makeTree('i', k, dummy);
		
		n.makeTree('n', dummy, p);
		l.makeTree('l', dummy, n);
		j.makeTree('j',dummy,l);
		
		e.makeTree('e', i, dummy);
		f.makeTree('f', dummy, j);
		
		d.makeTree('d', e, f);
		c.makeTree('c', g, h);
		b.makeTree('b', d, dummy);
		a.makeTree('a', b, c);
		
		a.levelOrderOutput();
		if( a.diameter() != 11 )
			fail();
		
		MyLBT<Integer> zero = new MyLBT<>();
		MyLBT<Integer> dummy2 = new MyLBT<>();
		
		MyLBT<Integer> two = new MyLBT<Integer>();
		MyLBT<Integer> three = new MyLBT<Integer>();
		three.makeTree(3,dummy2,dummy2);
		two.makeTree(2, three, dummy2);
		zero.makeTree(0, two, dummy2);
		
		if( zero.diameter() != 3 )
			fail();
		
		MyLBT<String> dummy3 = new MyLBT<String>();
		MyLBT<String> fe = new MyLBT<String>();
		MyLBT<String> pe = new MyLBT<String>();
		MyLBT<String> er = new MyLBT<String>();
		MyLBT<String> q = new MyLBT<String>();
		MyLBT<String> z = new MyLBT<String>();
		MyLBT<String> t = new MyLBT<String>();
		MyLBT<String> op = new MyLBT<String>();
		
		
		op.makeTree("o", dummy3, dummy3);
		z.makeTree("z", dummy3, dummy3);
		t.makeTree("t", op, dummy3);
		q.makeTree("q", dummy3, t);
		er.makeTree("r",q,z);
		pe.makeTree("p", dummy3, er);
		fe.makeTree("fe", pe, dummy3);
		if( fe.diameter() != 6 )
			fail();
		
	}

}


