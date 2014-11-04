/** linked implementation of LinearList */

package unal.datastructures;

import static org.junit.Assert.fail;

import java.util.*;

public class DoubleLinkedList<T> implements LinearList<T>{


	   int size = 0;
	   EspecialNode<T> jojo;
   
	   public DoubleLinkedList(){
	      jojo = null;
	      size = 0;
   
	}
	public boolean isEmpty(){
		return size==0;
	}

	public int size(){
		return size;	
	}

	public T get(int index){

		EspecialNode<T> aux = jojo;
	
		if (index<0||index>size){

			throw new IndexOutOfBoundsException("Out of limit");
	
	}
		

		for (int i=0; i<index-1;i++){

			aux = aux.next;

		}

		return aux.element;

	}	

	public int indexOf(T theElement){

		EspecialNode<T> curr = jojo;

		int k=0;

		while (curr!=null && !curr.element.equals(theElement)){
		
	     		curr = curr.next;
	     		k++;
		}

		if (curr==null){
	
			return -1;	
		}

		else 
		
		return k;
	}





   public void add(int index,T el){

      if( index < 0 || index > size){
         throw new IndexOutOfBoundsException("index out of range");
      }

      if( size == 0){
         jojo = new EspecialNode<T>(el,null,null);
         ++size;
         return;
      }else if ( size == index){
         EspecialNode<T> actualNode = jojo;
         for(int i = 0 ; i < index - 1 ; ++i){
            actualNode = actualNode.next;
         }
         EspecialNode<T> newNode = new EspecialNode<T>(el,null,null);
         newNode.previous = actualNode;
         actualNode.next = newNode;
         ++size;
         return;
      }

      EspecialNode<T> actualNode = jojo;
      for(int i = 0 ; i < index ; ++i){
         actualNode = actualNode.next;
      }

      EspecialNode<T> newNode = new EspecialNode<T>(el,null,null);
      
      if( actualNode.previous == null){
         newNode.next = actualNode;
         actualNode.previous = newNode;
         jojo = newNode;
      }else{
         newNode.previous = actualNode.previous;
         newNode.next = actualNode;
         newNode.previous.next = newNode;
         newNode.next.previous = newNode;
      }
      size++;
   }

   public void add(T element){
      add(0,element);
   }

   public String toString(){
      String tmp = "";
      EspecialNode<T> ac = jojo;
      while(ac != null){
         tmp += ac.element.toString()+" ";
         ac = ac.next;
      }
      return tmp;
   }

    public T remove(int index){

	T removedElement=null;
	EspecialNode<T> currentNode = jojo;

	if( index < 0 || index > size){
         throw new IndexOutOfBoundsException("Indice invalido");
         //throw new Exception("las ranas vuelan");
      }
		
	if (size==0){
		System.out.println("Está vacío");
	}

	if(index==0){

		removedElement = jojo.element; 
		jojo = jojo.next;
		jojo.previous = null;			
		
		
	}
	else{
		if (index==size){
	
			while (currentNode.next!=null){		
				currentNode = currentNode.next;
			}

		removedElement = currentNode.element;
                currentNode = currentNode.previous;
		currentNode.next.previous = null;
		currentNode.next=null;
		

	       }
       }
		
	

	if (index<size&&index>0){	

		for(int i = 0; i<index-1 ; i++){
			currentNode = currentNode.next;	
		}
		removedElement = currentNode.element;		  
		 currentNode.previous.next = currentNode.next;
		   currentNode.next.previous =  currentNode.previous;		
		   currentNode.previous = null;
		   currentNode.next = null;
                 }
	
		size--;
		return removedElement;	
		
	}

   public static void main(String[] args){
	   DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
	//   Chain<Integer> list = new Chain<>();
		int n = 50;
		for (int i = 0; i < n; i++) {
			list.add(list.size(),i);
		}
		System.out.println(list);
		list.remove(27);
		System.out.println( list.indexOf(27) );
		
		
		
	   /*int n = 50;
		
		Random r = new Random();
		for(int i=n; i>=0; i--){
			list.add(0, i);
		}
		
		for (int i = 0; i <= n; i++) {
			System.out.println(list.get(i));
		}*/
}
}	

class EspecialNode<T>{

   T element;
   EspecialNode<T> next,previous;
   
   public EspecialNode(T el,EspecialNode<T> pv, EspecialNode<T> nx){
      element = el;
      next = nx;
      previous = pv;
   }

}








