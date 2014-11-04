package unal.datastructures.taller2;


public class KSumPair <T extends Comparable<? super T>> extends MaxHeap<T> {
	public static int solve(LinearList<Integer>a,LinearList<Integer>b,int k){
		//hallar en que nivel esta
		int n=fewK(a,k);
		//Tamaño de la lista
		int N=a.size();
		int max=0;
		//System.out.println(a);
		//System.out.println(b);
		KSumPair<Integer>heap=new KSumPair<>();
		heap.put(a.get(0)+b.get(0));
		for(int i=0;i<n;i++){
			for(int j=1;j<N;j++){
				if(j>=i){
					if(i==j){
						heap.put(a.get(i)+b.get(j));
					}
					else{
						heap.put(a.get(i)+b.get(j));
						heap.put(a.get(j)+b.get(i));
					}
					}
			}
		}
		System.out.println(heap);
		for(int i=0;i<k;i++){
			max=heap.removeMax();
		}
	
		return max;
	}

	public static int fewK(LinearList<Integer>a, int k){
		//doesnt matter if i get Arr A or Arr B since they have the same size
		int N=a.size();
		int kth=0;
		ArrayLinearList<Integer>arr=new ArrayLinearList<>();
		for(int n=0;n<N;n++){
			kth=formula(N,n+1);
			if (n==0)
			arr.add(n, kth);
			if(n>0){
				int prev= arr.get(n-1);
				arr.add(n, prev+kth);
			}
		}
		for(int i=0;i<arr.size();i++){
			if(k<=arr.get(i)){
				return i+1;//level
			}
		}
		
	return 0;
	}

 public static int formula(int N,int n){
		int kth=2*(N-(n-1))-1;
		return kth;
	}
 
	public static void main(String[] args) {
		
		
	
		ArrayLinearList<Integer>a=new ArrayLinearList<>();
		ArrayLinearList<Integer>b=new ArrayLinearList<>();
		a.add(0, 13);
		a.add(1, 4);
		a.add(2, 2);
		b.add(0,15);
		b.add(1,8);
		b.add(2,1);
		System.out.println("la sexta suma es :"+KSumPair.solve(a,b,6));
		System.out.println("la 3 suma es :"+KSumPair.solve(a,b,3));
		System.out.println("la novena suma es :"+KSumPair.solve(a,b,9));
		
	}
}
