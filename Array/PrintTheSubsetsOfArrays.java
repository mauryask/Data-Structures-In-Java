// Queation NUmber : #3

// printing all the subsets of the given array

import static java.lang.System.*;
import java.util.*;

public class PrintTheSubsetsOfArrays
{
	public static void main(String [] args)
	{
		int A[] = {2,1,4};
		solve(A);
	}
	
	static void solve(int A[])
	{
		int n = A.length;
		int subset_count = Math.pow(2,n); 

		//convert each number into its binary
		for(int i=0; i<subset_count; i++)
		{
			int temp = i;
		    String rslt = "";
			
			// reprsent the binary equivalent upto n digits (2^n) 
			for(int j=0; j<n; j++)
			{
			   int rem = temp%2;
			   temp = temp/2;
			   if(rem == 1)
				   rslt += A[j]+"";
			}
			
			System.out.print("{"+rslt+"}"+" ");
		}		
	}
}
