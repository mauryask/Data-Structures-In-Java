// Queation Number : #12

import static java.lang.System.*;

public class CountAllTheSubArraysWithSumK
{
	public static void main(String [] args)
	{
		int A[] = {1-1,0};
		int target = 0;
		out.println(subArrayCount(A,target));
	}
	
	static int subArrayCount(int A[], int target)
	{
		int current_sum = 0, count = 0;
		int n = A.length;
		for(int i=0; i<n;i++)
		{
			current_sum = A[i];
			for(int j=i+1; j<n; j++)
			{
				if(current_sum == target)
					count++;
				current_sum += A[j];	
			}
			
			if(current_sum == target)
				count++;
		}
		
		return count;
	}
}