// here we will take O(n) buckets
// Time Complextiy: 
/*
* Worst Case : (when the elemnts are of close range in the array)
* then most probably they all will be kept in the same bucket
* ans to sort then it will take : O(n^2) (if insertion sort is used)

* Best Case: It Occurs when the elemnts are uniformly distributes in the buckets
* with neary equal number of elements in each bucket
* Complexity wil be more better if the elemnts in thebucket already sorted  
* Time Complexity : O(n+k) : k -> time o sort all the elements in the bucket
*/

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class BucketSort
{
	static void sort(float arr[], int n)
	{
		List<Float> bucket[]= new LinkedList[n];
		
		for(int i=0; i<n ; i++)
			bucket[i] = new LinkedList<Float>();
		
		for(int i=0; i<n ; i++) //O(n)
		{
			int index = (int) arr[i] * n;
			// for integer values to sort use folowing hash function
			// int index = arr[i] * n/max_value;
			// but one important point: the number of buckets will be (n+1)
			
			bucket[index].add(arr[i]);
		}
		
		//sort each bucket
		for(int i=0; i<n ; i++) 
		{
			Collections.sort(bucket[i]);
		}
		
		//get the sorted array
	
	     int index = 0;
		 for(int i=0; i<n; i++)
		 {
			 while(!bucket[i].isEmpty())
				 arr[index++] = bucket[i].remove(0);
		 }
		
	}
	
	public static void main(String [] args)
	{
		float arr[] = {(float)0.35,(float)0.45, 
		(float)0.84, (float)0.65,(float)0.78,(float)0.98,(float)0.53};
		
		sort(arr, arr.length);
		
		for(float x : arr)
			System.out.print(x+" ");
		
	}
}
