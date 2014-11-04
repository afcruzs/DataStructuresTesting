package unal.datastructures.taller2;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import  unal.datastructures.taller2.LinkedBinaryTree;;


public class StructureChecker<T> {
	LinkedBinaryTree<T> tree;
	static List list;
	static Method put;

	public StructureChecker(LinkedBinaryTree<T> tree) {
		this.tree = tree;
		Class<StructureChecker> lbt = StructureChecker.class;
		try {
			put = lbt.getMethod( "put", BinaryTreeNode.class );
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	

	public int[] structure(){
		BinaryTreeNode<T> c = tree.root;
		int[] arr = new int[tree.size()];
		Queue<BinaryTreeNode<T>> q = new LinkedList<BinaryTreeNode<T>>();
		int i=0;
		while(!q.isEmpty()){
			c = q.poll();
			int t = 0;
			if( c.getLeftChild() != null ){
				t++;
				q.add(c.getLeftChild());
			}
			if( c.getRightChild() != null ){
				t++;
				q.add(c.getRightChild());
			}
			arr[i++] = t; 
		}
		
		return arr;
	}
	
	public List<T> getElements(){
		list = new LinkedList<>();
		tree.preOrder(put);
		return list;
	}
	
	
	public static <T> void put(  BinaryTreeNode<T> t ){
		list.add(t.element);
	}
	
	
}
