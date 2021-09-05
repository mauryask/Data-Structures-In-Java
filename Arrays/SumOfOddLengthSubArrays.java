// Queation Number : #14
// very lovely question

import static java.lang.System.*;

public class SumOfOddLengthSubArrays
{	
	public static void main(String [] args)
	{
		int A[] = {1,4,2,5,3};
		out.println(oddSubArraySum(A));
	}


  // Time Complexity  : O(n)
  // Space Complexity : O(1)
  
   static int oddSubArraySum(int A[])
   {
	   int n = A.length;
	   int sum = 0;
	   
	   // each element is reapeated exactly "given expresion" 
	   // number of times check for it
	   
	   for(int i=0; i<n; i++)
	   {
		   sum += (((i+1) * (n-i) + 1)/2) * A[i];
	   }
	   return sum;
   }


  // Time Complexity  : O(n^3)
  // Space Complexity : O(1)
	static int oddSubArraySum2(int A[])
	{
	   int n   = A.length;
       int cum_sum = 0;
        
        for(int l=1; l<=n; l+=2)
        {
            for(int i=0;i<n-l+1; i++)
            {
                int j = i+l-1;
                int sum = 0;
                if((j-i+1) % 2 != 0)
                {
                    for(int k=i; k<=j;k++)
                        sum += A[k];
                }
                
                cum_sum += sum;
            }
        }
        
        return cum_sum;
	}
}