// Queation NUmber : #11

import static java.lang.System.*;
import java.util.*;

public class FourSumProblem
{
	public static void main(String [] args)
	{
		int A[] = {1,0,-1,0,-2,2};
		int target = 0;
		out.println(solve2(A, target));
	}
	
	
	// Time Complexity : O(n^3)
	
	static boolean solve(int A[], int target)
	{
		int n = A.length;
		int sum = 0;
		Arrays.sort(A);
		
		for(int i=n-1;i>=3;i--)
		{
			for(int j=i-1;j>=2;j--)
			{
				int left = 0;
				int right = j-1;
				
				while(left < right)
				{
					sum = A[left] + A[right] + A[i] +A[j];
					if(sum == target)
					{
						return true;
					}
					else if(sum < target)
						left++;
					else
						right--;
				}
			}
		}
		return false;
	}
	
	// Time Complexity : O(n^4)
	
	static boolean solve2(int A[], int target)
	{
		int n = A.length;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				for(int k=j+1;k<n;k++)
				{
					for(int l=k+1;l<n;l++)
					{
						if(A[i] + A[j] + A[k] + A[l] == target)
							return true;
					}
				}
			}
		}
		return false;
	}
}