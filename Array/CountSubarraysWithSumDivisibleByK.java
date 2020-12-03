// Question Number : #1

// countind all the sub arrays 
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
}