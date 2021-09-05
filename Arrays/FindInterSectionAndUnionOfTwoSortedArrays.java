// Queation Number : #7 
 
import java.util.*; 
import static java.lang.System.*;

public class FindInterSectionAndUnionOfTwoSortedArrays
{
	public static void main(String [] args)
	{
		int A[] = {0,1,4,5,7,9,10};
		int B[] = {4,7,9,10,20};
		
		// union(A, B);
		intersection(A,B);
	}
	
	// finding union of two sorted arrays
	
	static void union(int A[], int B[]) // Time Complexity : O(m+n)
	{
		int m = A.length;
		int n = B.length;
	    
		Map<Integer, Boolean> map = new HashMap<>();	
		
		for(int i=0;i<m; i++)
		{
			if(!map.containsKey(A[i]))
			{
				out.print(A[i]+" ");
				map.put(A[i], false);
			}
		}
		
		for(int i=0;i<n; i++)
		{
			if(!map.containsKey(B[i]))
			{
				out.print(B[i]+" ");
				map.put(B[i], false);
			}
		}
	}
	
	static void intersection(int A[], int B[]) // Time Complexity : O(m+n)
	{
		int m = A.length;
		int n = B.length;
		int i=0, j=0; 
		Map<Integer, Boolean> map = new HashMap<>();
		while(i<m && j<n)
		{
			if(A[i] == B[j] && !map.containsKey(A[i]))
			{
				    map.put(A[i], false);
					out.print(A[i++]+" ");
			        j++; 
			}
			else if(A[i] < B[j])
				i++;
			else 
				j++;
		}
	}
}