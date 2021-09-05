// Queation Number : #6

// Check if there is a pair with sum 
// Equal to given target value
// Return true or false

import java.io.*;
import java.util.stream.*;
import java.util.*;
import static java.lang.System.*;

public class PairsWithGivenSum
{
	public static void main(String [] args) throws IOException
	{                     
		int A[] = new int[]{1,5,7,2,3,6,4,2,5,9,8};
		out.println(solve(A,9));
		out.println(bruteForce(A,9));
		out.println(solve2(A,9));
	}
	
	// Time Complexity  : O(n*log n)
	// Space Complexity : O(1)
	
	static boolean solve(int A[], int num)
	{
		int l = 0;
		int r = A.length -1;
		
		// here in order to apply this method
		// it is necessary to sort the array	
		Arrays.sort(A);
		
		while(l < r)
		{
			int sum = A[l] + A[r];
			if(sum == num)
				return true;
			else if(sum < num)
				l++;
            else 
				r--;				
		}
		return false;
	}
	
	// Time Complexity  : O(n^2)
	// Space Complexity : O(1)
	
	static boolean bruteForce(int A[], int num)
	{
		int n = A.length;
		
		for(int i=0;i<n; i++)
		{
			for(int j=0; j<n && j!=i; j++)
			{
				int sum = A[i] + A[j];
				if(sum == num)
					return true;		
			}
		}
		return false;
	}
	
	// Time Complexity  : O(n)
	// Space Complexity : O(n)
	// Uisng HashSet
	
	static boolean solve2(int A[], int num)
	{
		int n = A.length;
		Set<Integer> set =  new HashSet<>();
		
		for(int i=0;i<n; i++)
		{
			int temp = num - A[i];
		    if(set.contains(temp))
		       return true; 
            set.add(A[i]);		   
		}
		return false;
	}
}