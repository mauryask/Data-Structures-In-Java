//insertion sort for sorting elements in ascending order

import static java.lang.System.*;

public class InsertionSort 
{
	public static void main(String [] args)
	{
		int A[] = new int[]{5,1,2,7,8,96,32,45,10};
		
		out.println("Array before sorting");
		for(int a: A)
			out.print(a+" ");
		out.println();
		
		InsertionSort.insertionSort(A);
		
		out.println("The array after sorting");
		for(int a : A)
			out.print(a+" ");
		out.println();
		
	}
	
	static void insertionSort(int A[])
	{
		int i,j,temp;
		
		for(i=1; i<A.length; i++)
		{
			temp = A[i];
			
			// in algorithm index starts with --> 1 
			// in our case index starts with --> 0
			// so here we taken j>=0 instead of --> j>0
			// as in the given array if j is not as above then it can't be sorted 
			// completely
			
			//To sort the array in descending order just change
			// temp > A[j] and keep remaining things as it is
			for(j=(i-1); j>=0 && temp<A[j]; j--)  
			{
			   A[j+1] = A[j];	
			}
			
			A[j+1] = temp;
		}
	}
}