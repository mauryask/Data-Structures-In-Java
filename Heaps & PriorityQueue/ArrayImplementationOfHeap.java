/**
* Since for each element heapify operation 
* is being performed
Time complexity  : O(n * log n)
Space complexity : O(n)
*/

import static java.lang.System.*;

//creating Max Heap 

public class ArrayImplementationOfHeap
{
	//this is the number of elements in the array
	static int heapSize = 0; 
	static int A[] = new int[10];
	

    // T(n) = O(log n)
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
				
		if(r < heapSize && A[r]  > A[largest])
			largest = r;
		
		if(largest != i) //root is already heapified
		{
			int temp;
			temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			
			maxHeapify(largest);
		}
	}
  }
	
	
	static void printHeap()
	{
		for(int i=0; i<heapSize ; i++)
		{
			System.out.print(A[i]+" ");
		}
	}		
	
	
	// O(logn)
	static void deleteRoot() 
	{
		// replace root with the last element
		A[0] = A[heapSize-1];
		A[heapSize-1] = 0; // this step is not required
		heapSize--;
		
		// heapify all the elements again
		for(int i=0; i < heapSize; i++)
		   maxHeapify(i);
	}
	
	
	// T(n) = O(n * log n)
	// for each element O(log n) and there are total n 
	// elements
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
			 // total umber of nodes in the heap
			 heapSize++; 
			 
			 // we need to heapify only the non-leaf nodes
			 // in complete binary tree number of non leaf nodes = n/2
			 // And heap is a complete binary tree
			 // n : total number of nodes
			 // here if heapSize  = 4 then (heapSize/2)-1
			 // will produce -> 1, 0 (non-leaf indexes)
			 // we need to process only 0 and 1 not 2 and 3
			 
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