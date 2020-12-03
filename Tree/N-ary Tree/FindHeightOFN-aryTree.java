// Given a parent array of N-ary tree
// find the height of the tree

import java.util.*; 
import static java.lang.System.*;

public class FindHeightOFN-aryTree
{
	public static void main(String [] args)
	{
		int parent[] = {-1,0,1,6,6,0,0,2,7};
		solve1(parent);
	}

 // Time Complexity  : O(n^2)
 // Space Complexity : O(1)
 
  static void solve1(int A[])
  {
	  int n = A.length;
	  int max = -1;
	  for(int i=0;i<n;i++)
	  {
		  int count = 0;
		  int j = i;
		  while(A[j] != -1)
		  {
			  j = A[j];
			  count++;
		  }
		  if(max < count)
			  max = count;
	  }
	  out.println(max);
  }
 
    // Time Complexity  : O(n)
	// Space Complexity : O(n)
	
	static void solve(int A[])
	{
		int n = A.length;
	    int height[] = new int[n];
		int max = Integer.MIN_VALUE;
		Arrays.fill(height, -1);
		
		for(int i=0;i<n;i++)
		{
			int count = 0;
			int j = i;
			
			while(A[j] != -1)
			{
				j = A[j];
				if(height[j] != -1)
				{
					count += height[j] +1;
					break;
				}
				else
					count++;
			}
			height[i] = count;
			if(max < count)
				max = count;
		}
		
		for(int x : height) out.print(x+" ");
		out.println("\n"+max);
	}
}