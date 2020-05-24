//https://www.youtube.com/watch?v=5P-RlguTk4Q
package com.pnstech;

public class CheckIfAnArrayIsSoretd {

	public static void main(String[] args) {
		
		int arr[] = {4,5,7,8,9,3,1};
		int brr[] = {4,5,7,8,9,12};
		
		if(recursiveIsSorted(brr, brr.length)) //isSorted(arr / brr)
			System.out.println("Sorted");
		else
			System.out.println("Not Sorted");
	}
	
	//iterative version
	static boolean isSorted(int a[])
	{
		int n = a.length;
		if(n<=1) //if array has one or zero element then it is already sorted
			return true;
		
		for(int i=1; i<n; i++)
		{
			if(a[i] < a[i-1])
				return false;
					
		}
		
		return true; //if the array is sorted (it will come out of the loop)

	}
	
	//recursive version
	
	static boolean recursiveIsSorted(int a[], int n)
	{
		if(n<=1)
			return true;
		
		if(a[n-1] < a[n-2])
			return false;
		
		return recursiveIsSorted(a, n-1);
	}

}
