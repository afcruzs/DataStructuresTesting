

package unal.datastructures;

class ChainDoubleNode<T>
{
   // package visible fields
   T element;
   ChainDoubleNode<T> next;
   ChainDoubleNode<T> prev;

   // package visible constructors
   ChainDoubleNode( T element, ChainDoubleNode<T> next,ChainDoubleNode<T> prev )
   {
      this.element = element;
      this.next = next;
	  this.prev = prev;
   }
   
   ChainDoubleNode( T element )
   {
      this( element, null, null );
   }

  
   
   ChainDoubleNode()
   {
      
   }
   
   

}
