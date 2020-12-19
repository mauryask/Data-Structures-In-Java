// Question Number : #5
import java.io.*;
import java.util.stream.*;

public class MaxSubArraySum
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A[] =  Stream.of(br.readLine().split(" "))
		.mapToInt(Integer::parseInt)
		.toArray();
		
		System.out.println(solve(A));
	}
	
	// Time Complexity : O(n)
	// Kadane's algorithm
	static int solve(int A[])
	{
	   int sum = 0, maxSum = A[0], s = 0, start = 0, end = 0;
	   
	   for(int i=0;i<A.length;i++)
	   {
		   sum += A[i];
		   
		   //  dont update indices 
		   //  if currentSum < maxSum
		   // else update
		   
		   if(sum > maxSum)
		   {
			   maxSum = sum;
			   start = s;
			   end = i;
		   }
		   else if(sum < 0) // negative sum is not acceptable
		   {
			   sum = 0;
			   s = i+1;
		   }
	   }
 	    return maxSum;
	}
	
	
	// Time Complexity : O(n^2)
	static int solve2(int A[])
	{
		int n = A.length;
		int sum = 0;
		int max = Integer.MAX_VALUE;
		
		for(int i=0;i<n; i++)
		{
		  sum = A[i];
		  for(int j=i+1; j<n; j++)
		  {
			  if(max<sum)
				  max = sum;
			  sum += A[j];
		  }
		  
		  if(max< sum)
			  max = sum;
		}
		
		return max;
	}
}