package unal.datastructures.taller2;

public class KSumPair{
	
	//Constructor
	public KSumPair(){}
	
	public static void main(String[] args){
		KSumPair llamado = new KSumPair();
		ArrayLinearList<Integer> A = new ArrayLinearList<>();
		ArrayLinearList<Integer> B = new ArrayLinearList<>();	
		A.add( 0, 20 );
		A.add( 1, 15);
		A.add( 2, 5 );
		A.add( 2, 0 );
		B.add( 0, 4 );
		B.add( 1, 3 );
		B.add( 2, 2 );
		B.add( 2, 1 );
		//Show Lists
		System.out.println( "+++++THE Kth LARGEST SUM+++++" );
		System.out.println( "List 1:" );
		System.out.println( A );
		System.out.println( "\nList 2:" );
		System.out.println( B +"\n");
		System.out.println(llamado.solve(A,B,8));
	}
	
	//Method
	public int solve(LinearList<Integer> A, LinearList<Integer> B, int k){
		MaxHeap<Integer> sumas = new MaxHeap<>();
		
		for( int i = 0 ; i < A.size( ) ; i++ ){
			for(int j = 0; j < B.size( ); j++ )
				sumas.put(  A.get( i ) + B.get( j ) );
		}
		
		for(int i = 0 ; i < k ; i++){
			sumas.removeMax();
		}
		return sumas.removeMax();
	}
}