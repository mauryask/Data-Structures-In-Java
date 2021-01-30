// Question Number : #1

// counting all the sub arrays 
// with cumulative sum divisible by k
// Time Complexity  : O(n+k)
// Space Complexity : O(k)

// see the explanation in the notes

import static java.lang.System.*;
import java.util.*;

public class CountSubarraysWithSumDivisibleByK
{
	public static void main(String [] args)
	{   int A[] = {4, 5, 0, -12, -23, 1 };
		int k = 5;
		solve(A, k);
		bruteForce(A,k);
	}
	
	static void solve(int A[], int k)
	{
		 int n = A.length;
		 int remFreq[] = new int[k];
		 int cumSum = 0;
		 int countSub  = 0;
		 Arrays.fill(remFreq, 0);
		 remFreq[0] = 1;
		 
		 for(int i=0;i<n;i++)
		 {
			 cumSum += A[i];
			 // here ((cumSum % k)+k)%k this is used to hanlde 
			 // negative number (it is rule in modular arithmetic)
			 remFreq[((cumSum % k)+k)%k]++; 
		 }
		 
		 // once all the occurance of 
		 // similiar remainders are counted
		 // then for each remFreq we can choose 
		 // any two point to get total sub aray count
		 
		 for(int i=0;i<k;i++)
		 {
			 if(remFreq[i] > 1)
				 countSub += remFreq[i] * (remFreq[i] -1)/2; 
		 }
		 out.println(countSub);
	}
	
	
	// Time Complexity  : O(n^2)
	// Space Complexity : O(1)
	
	static void bruteForce(int A[], int k)
	{
		int n = A.length;
		int count = 0;
		int sum = 0;
		
		for(int i=0; i<n; i++)
		{
			sum = A[i];
			for(int j=i+1; j<n; j++)
			{
				if(sum % k == 0)
					count++;
				sum += A[j];
			}
			
			if(sum %k == 0)
				count++;
		}
		
		out.println("\n"+count);
	}
}