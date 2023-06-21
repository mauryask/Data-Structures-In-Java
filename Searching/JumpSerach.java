// Time complexity : O(√n)
// S(n) : O(1)

import static java.lang.System.*;

public class JumpSerach
{
	static int linearSerach(int A[], int i, int j, int target) //O(√n)
	{
		for(int index = i; index<=j; index++)
			if(A[index] == target)
				return index;			
		return -1;	
	}
	
	static int jumpSerach(int A[], int target)
	{
		int n = A.length;
		int jumpSize = (int)Math.sqrt(n); //Optimal jumpSize
		int start = 0;
		int end = jumpSize;
		
		while(A[end] <= target)
		{
			if(A[start] == target)
				return start;
			else if(A[end] == target)
				return end;
			
			start = end;
			end += jumpSize;
		}
		
		return linearSerach(A, start, Math.min(end, n-1), target);
	}
	
	public static void main(String [] args)
	{
		   //for jump serach the array must be already in sorted order
           int A[] = {1,3,4,7,8,9,12,14,48,56,69,70};	
		   int target = 4;
           out.print(jumpSerach(A, target));		   
	}
}