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
	
	static int solve(int A[])
	{
	   int sum = 0, maxSum = 0, s = 0, start = 0, end = 0;	
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
		for(int i= start ; i<= end; i++)
		System.out.print(A[i]+" ");	
	    System.out.println();
 	    return maxSum;
	}
}