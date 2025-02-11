//heapSort 
public class HeapSort 
{
	static void buildMaxHeap(int A[])
	{
		int heapSize = A.length;
		for(int i= A.length/2 -1 ; i>=0; i--)
		{
			maxHeapify(A,i, heapSize);
		}
	}
	
	static void maxHeapify(int A[], int i, int heapSize)
	{
		int largest = i; 
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if(l < heapSize && A[l] > A[largest])
			largest = l;

		if(r < heapSize && A[r] > A[largest])
			largest = r;
		
		if(largest != i) //alreay heapified
		{
			int temp = A[i];
			A[i]  = A[largest];
			A[largest] = temp;	
			maxHeapify(A,largest,heapSize);
		}		
	}
	
	static void heapSort(int A[])
	{
	   buildMaxHeap(A);	 
	   
	   //extract max element from root and swap with 
	   //farthest leaf element and apply maxHeapify at root(index: 0) 
	   
	   for(int i= A.length-1; i>=0; i--)
	   {
		   //Removing the largest element from top of the heap maxHEapifying the rest of the tree
		   int temp = A[0];
		   A[0] = A[i];
		   A[i] = temp;
		   
		   maxHeapify(A,0,i); //i is reduced heapSize here (we need to leave this element (at index i) since it is at right place now)
	   }
	}
		
	public static void main(String [] args)
	{
		int A[] = {10,12,7,5,89,41,20,36};
		heapSort(A);

		for(int x : A)
		  System.out.println(x+" ");
	}
}
