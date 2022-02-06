import static java.lang.System.*;
import java.util.*;

public class MaxHeapFromArrayOfElements 
{
	// initialize the heap size
	// with the number of the elements in 
	// the heap 
	static int heapSize = 8;
	
	// O(logn)
	static void maxHeapify(int[] A, int i)
	{
		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		
		if(l < heapSize && A[l] > A[largest])
			largest = l;
		if(r < heapSize && A[r] > A[largest])
			largest = r;
		
		if(largest != i)
		{
		   int temp = A[largest];
		   A[largest] = A[i];
		   A[i] = temp;
		   maxHeapify(A, largest);
		}	
	}
    
    // print heap	
    static void printHeap(int A[])
	{
		for(int i=0; i<heapSize; i++)
			out.print(A[i]+" ");
		out.println();
	}
	  
	// O(n)
	// since it is done only once
	static void buildHeap(int A[])
	{
		for(int i=heapSize/2-1; i>=0 ; i--)
			maxHeapify(A, i);
	}
	
	//delete max
	// O(logn)
	static int deleteMax(int A[])
	{
		if(heapSize == 0)
			return -1;
		
		int temp = A[0];
		A[0] = A[heapSize-1];
		heapSize--;
		
		for(int i=heapSize/2-1; i>=0; i--)
			maxHeapify(A, i);
		
		return temp;
	}
	
	// insert element
	// O(logn)
	static void insertKey(int[] A, int key, int n)
	{
		if(heapSize == n)
		{
			out.println("Overflow!!");
			return;
		}
		
		A[heapSize] = key;
		heapSize++;
		
		for(int i=heapSize/2-1; i>=0; i--)
			maxHeapify(A, i);
	}
	
	public static void main(String [] args)
	{
	   int A[] = {10,12,45,78,96,41,20,14};	
	   int n = A.length; // heap size
	   buildHeap(A);
	   printHeap(A);
	   out.println(deleteMax(A));
	   out.println(deleteMax(A));
	   out.println(deleteMax(A));
	   out.println(deleteMax(A));
	   printHeap(A);
	   insertKey(A, 35, n);
	   printHeap(A);	   
	}
}