//creating Max Heap 

public class CreateHeap 
{
	//this is the number of elements in the array
	static int heapSize = 0; 
	static int A[] = new int[10];
	
	/**
	* O(log(n)) (for all the cases)
	*/
	static void maxHeapify(int i) 
	{
		if(heapSize == 1)
			System.out.println("only root is present..");
		else
		{
			int largest = i;
			int l = 2*i + 1;
			int r = 2*i + 2;
			
			// for minHeap use '<'
			// in both 'ifs' A[l] & A[r] < A[largest]
			
		if(l< heapSize && A[l] > A[largest])
			largest = l;
		else
			largest = i;
		
		if(r < heapSize && A[r]  > A[largest])
			largest = r;
		
		if(largest != i) //swap 
		{
			int temp;
			temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			
			maxHeapify(largest);
		}
	}
  }
	
	
	/**
	* O(n) >> worst case
	* O(1) >> best case
	*/
	static void printHeap()
	{
		for(int i=0; i<heapSize ; i++)
		{
			System.out.print(A[i]+" ");
		}
	}		
	
	
	/**
     * O(log(n)) >> worst case
	 * O(log(n)) >> best case
	*/
	static void deleteRoot() 
	{
		A[0] = A[heapSize-1];
		heapSize--;
		for(int i=0; i < heapSize; i++)
		   maxHeapify(i);
	}
	
	/**
	* O(1) >> best case
	* O(log(n)) >> worst case
	*/

	static void insertKey(int value)
	{
		 if(heapSize == 0)
		 {
			 A[0]  = value;
			 heapSize++;
		 }
		 else
		 {
			 A[heapSize] = value;
			 heapSize++;
			 for(int i = heapSize/2 - 1 ; i>=0; i--)
			 {
				 maxHeapify(i);
			 }
			 
		 }
	}
	
	public static void main(String [] args)
	{
						
		insertKey(10);
		insertKey(45);
		insertKey(32);
		insertKey(14);
		insertKey(36);
		insertKey(89);
		insertKey(47);
		
		printHeap();
		
		System.out.println();
		deleteRoot();
		printHeap();
		
		System.out.println();
		deleteRoot();
		printHeap();
	} 
}