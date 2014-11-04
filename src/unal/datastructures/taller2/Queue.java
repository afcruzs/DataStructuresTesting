package unal.datastructures.taller2;

public interface Queue<T>
{
   boolean isEmpty( );
   T getFrontElement( );
   T getRearElement( );
   void put( T theObject );
   T remove( );
}
