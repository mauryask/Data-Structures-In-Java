// here we will take O(n) buckets
// Time Complextiy: 
/*
* Worst Case : (when the elemnts are of close range in the array)
* then most probably they all will be kept in the same bucket
* ans to sort then it will take : O(n^2) (if insertion sort is used)

* Best Case: It Occurs when the elemnts are uniformly distributes in the buckets
* with neary equal number of elements in each bucket
* Complexity wil be more better if the elemnts in thebucket already sorted  
* Time Complexity : O(n+k) : k -> time to sort all the elements in the bucket
*/

import java.util.*;

public class BucketSort
{
	static void bucketSort(float A[], int n)
	{
		List<Float> bucket[]= new ArrayList[n];
		
		for(int i=0; i<n ; i++)
			bucket[i] = new ArrayList<>();
		
		for(int i=0; i<n ; i++) //O(n)
		{
			int index = (int) A[i] * n;
			// for integer values to sort use folowing hash function
			// int index = arr[i] * n/max_value;
			// but one important point: the number of buckets will be (n+1)			
			bucket[index].add(A[i]);
		}
		
		//Sort each bucket (Generally insertion sort applied here)
		for(int i=0; i<n ; i++) 
		{
			Collections.sort(bucket[i]);
		}
		
		//get the sorted array
	
	     int index = 0;
		 
		 for(int i=0; i<n; i++)
		 {
			 for(int j = 0; j<bucket[i].size(); j++)
				 A[index++] = bucket[i].get(j);
		 }		
	}
	
	public static void main(String [] args)
	{
		float A[] = {0.35f, 0.45f, 0.84f, 0.65f, 0.78f, 0.98f, 0.53f};		
		
		bucketSort(A, A.length);
		
		for(float x : A)
			System.out.print(x+" ");		
	}
}
