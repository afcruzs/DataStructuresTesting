package unal.datastructures.taller2;

import java.util.*;

public class MyLBT<T> extends LinkedBinaryTree<T>{
	
	static <T> T thebro(BinaryTreeNode<T> t, T e){
		//only check the nodes with 2 childs
		if(t.rightChild==null || t.leftChild==null) {
			return null;
		}
		
		if(t.leftChild.element.equals(e))
			return t.rightChild.element;
		else if(t.rightChild.element.equals(e)){
			return t.leftChild.element;
		}
		
		T e1=thebro(t.leftChild,e);
		T e2=thebro(t.rightChild,e);
		if(e1==null){//if e1 ==null means that the node is probably in the root.rightchild
			return e2;
		}
		if(e2==null){//if e2 ==null means that the node is probably in the root.leftchild
			return e1;
		}
		//not found
		return null;
	}
	public T brother(T x){
		T element=null;
		element=thebro(root,x);
		return element;
	}
	
	
	public ArrayList<T> iInOrder(BinaryTreeNode<T>t){
		ArrayList<T>arr=new ArrayList<>();
		ArrayStack<BinaryTreeNode<T>>s=new ArrayStack<>();
		BinaryTreeNode<T>curr=root;
		while(!s.isEmpty() || curr != null){
            if(curr != null){
                s.push(curr);
                curr = curr.leftChild;
            }else{
                BinaryTreeNode<T>x = s.pop();
                arr.add(x.element);
                curr = x.rightChild;
            }
        }
		return arr;
	}
	public ArrayList<T> ii(){
		return iInOrder(root);
	}
	public ArrayList<T>iPreOrder(BinaryTreeNode<T>t){
		ArrayList<T>arr=new ArrayList<>();
        ArrayStack<BinaryTreeNode<T>> s = new ArrayStack<BinaryTreeNode<T>>();
        s.push(root);
        while(!s.isEmpty()){
            BinaryTreeNode<T> x = s.pop();
            arr.add(x.element);
             if(x.rightChild != null){
                s.push(x.rightChild);
            }
            if(x.leftChild != null){
                s.push(x.leftChild);
            }
         }
		return arr;
	}
	public ArrayList<T>ipre(){
		return iPreOrder(root);
    }
	public ArrayList<T> iPostOrder(BinaryTreeNode<T>t){
		ArrayList<T>arr=new ArrayList<>();
		if(root==null)
			return arr;
		ArrayStack<BinaryTreeNode<T>>s=new ArrayStack<>();
	        s.push(t);
	        BinaryTreeNode<T> prev = null;
	        while(!s.isEmpty()){
	            BinaryTreeNode<T> curr = s.peek();
	            if(prev == null || prev.leftChild == curr || prev.rightChild == curr){
	                if(curr.leftChild != null){
	                    s.push(curr.leftChild);
	                }else if(curr.rightChild != null){
	                   s.push(curr.rightChild);
	                }else{
	                    s.pop();
	                    arr.add(curr.element);
	                }
	 
	            }else if(curr.leftChild == prev){
	                if(curr.rightChild != null){
	                    s.push(curr.rightChild);
	                }else{
	                    s.pop();
	                    arr.add(curr.element);
	                }
	 
	            }else if(curr.rightChild == prev){
	                s.pop();
	                arr.add(curr.element);
	            }
	 
	            prev = curr;
	        }
		return arr;
	}
	public ArrayList<T>ipost(){
		return iPostOrder(root);
	}
	public int diameter(){
		return thediameter(root);//se manda todo  el arbol en general
	}
	//es NESESARIO poner return 0 en root pues se deven sumar enteros
	static<T> int thediameter(BinaryTreeNode<T> t){
		int d=0;
		if(t==null)
			return 0;
		//calculo de la altura
		int lh=theHeight(t.leftChild);
		int rh=theHeight(t.rightChild);
		//se calcula el radio izq y derecho del diametro DE CADA NODO mediante el calculo de su altura recursivamente
		int ld=thediameter(t.leftChild);
		int rd=thediameter(t.rightChild);
		int maxd=0;
		//total,obtiene la "distancia" mas larga en total si pasa por el root ,+1 pues el root, asi hallamos el diametro
		//max retorna la distancias que se convierte en diametro en caso contrario (que pase por el root)
		//luego retorno d que es el maximo entre max y total que son diametros
		int total=lh+rh+1;
		if(ld>=rd){
			maxd=ld;
		}
		else{
			maxd=rd;
		}
		
		if(total>=maxd){
			d=total;
		}
		else{
			d=maxd;
		}
		return d;
	}
	
	public void shuffle(){
		BinaryTreeNode<T> cur;
		ArrayQueue<BinaryTreeNode<T>> q = new ArrayQueue<>();		
		ArrayLinearList<T> l = new ArrayLinearList<>();
		q.put(root);
		int count=0;
		while(!q.isEmpty()){
			cur=q.remove();
			l.add(count, cur.element);
			if(cur.leftChild!=null)q.put(cur.leftChild);
			if(cur.rightChild!=null)q.put(cur.rightChild);
			count++;
		}
		BinaryTreeNode<T> curn;
		q.put(root);
		while(!q.isEmpty()){
			curn=q.remove();
			int i=0;
			do{
				i=Math.abs(new Random( new Date().getTime()).nextInt() )%count;
			}
			while(l.get(i).equals(curn.element));
			curn.element=l.get(i);
			l.remove(i);
			if(curn.leftChild!=null)q.put(curn.leftChild);
			if(curn.rightChild!=null)q.put(curn.rightChild);			
			count--;
		}
	}

	public static void main(String[] args) {
		MyLBT<Integer>a=new MyLBT<Integer>();
		MyLBT<Integer>x=new MyLBT<Integer>();
		MyLBT<Integer>y=new MyLBT<Integer>();
		MyLBT<Integer>z=new MyLBT<Integer>();
		MyLBT<Integer>w=new MyLBT<Integer>();
		
		MyLBT<Integer>m=new MyLBT<Integer>();
		MyLBT<Integer>n=new MyLBT<Integer>();
		MyLBT<Integer>o=new MyLBT<Integer>();
		MyLBT<Integer>u=new MyLBT<Integer>();
		
		x.makeTree(3, a, a);
		y.makeTree(20, a, a);
		z.makeTree(17, y, a);
		y.makeTree(5, x, z);
		x.makeTree(6, a, a);
		z.makeTree(11, x, a);
		x.makeTree(1, a, a);
		w.makeTree(12, a, x);
		x.makeTree(10, z, w);
		z.makeTree(7, y, x);
		x.makeTree(21, a, a);
		y.makeTree(8, a, x);
		x.makeTree(18, a, a);
		w.makeTree(19, x, a);
		x.makeTree(9, y, w);
		y.makeTree(16, a, a);
		w.makeTree(4, a, a);
		a.makeTree(0, y, w);
		y.makeTree(4, a, x);
		x.makeTree(2, z, y);
		System.out.println("level order:");
		x.levelOrderOutput();		
		
		System.out.println();
		System.out.println("the brother of 1 is "+x.brother(1)); 
		System.out.println("the brother of 19 is "+x.brother(19));
		
		System.out.println("El levelOrder inicial es:");
		x.levelOrderOutput();
		x.shuffle();
		System.out.println();
		System.out.println("El levelOrder despues de shuffle es:");
		x.levelOrderOutput( );
		
		System.out.println("Iterative preoder: ");
		System.out.println(x.ipre());
		System.out.println("Recursive preorder:");
		x.preOrderOutput();
		System.out.println();
		System.out.println();
		System.out.println("Iterative inoder: ");
		System.out.println(x.ii());
		System.out.println("Recursive inorder:");
		x.inOrderOutput();
		System.out.println();
		System.out.println();
		System.out.println("Iterative postoder: ");
		System.out.println(x.ipost());
		System.out.println("Recursive postorder:");
		x.postOrderOutput();
		
		//2do arbol para el caso especial del diametro
		//					5
		//			6				9
		//		7	    1
		//	 4				2
		//0						3
		
		
		m.makeTree(0, u, u);
		n.makeTree(4, m, u);
		m.makeTree(7, n, u);
		n.makeTree(3, u, u);
		o.makeTree(2, u, n);
		n.makeTree(1, u, o);
		o.makeTree(6, m, n);
		n.makeTree(9, u, u);
		m.makeTree(5, o, n);
		System.out.println("level order output is ");
		m.levelOrderOutput();
		System.out.println();
		
		System.out.println("diameter of 1st tree: "+x.diameter());
		System.out.println();
		//prueba caso especial
		m.levelOrderOutput();
		System.out.println();
		System.out.println("diameter of 2nd tree: "+m.diameter());
		
	
	}
}