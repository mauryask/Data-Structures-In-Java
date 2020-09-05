import java.io.*;
import java.util.stream.*;
public class MaxSumSubArray
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
		   if(sum > maxSum)
		   {
			   maxSum = sum;
			   start = s;
			   end = i;
		   }
		   else if(sum < 0)
		   {
			   sum = 0;
			   s = i+1;
		   }
	   }
	   
	   return maxSum;
	}
	
}