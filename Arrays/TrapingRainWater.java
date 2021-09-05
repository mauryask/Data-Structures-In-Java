// Queation Number : #17

import static java.lang.System.*;

public class TrapingRainWater
{
	public static void main(String [] args) throws Exception
	{
	   int A[] = {0,1,0,2,1,0,1,3,2,1,2,1};
	   out.println(findTrappedWater2(A));
	}
	
	
	// Time Complexity  : O(n)
	// Space Complexity : O(n)
	// Best approach
	
	static int findTrappedWater(int A[])
	{
		int n = A.length;
		int lMax[] =  new int[n]; // largest bar to the left of each bar
		int rMax[] =  new int[n]; // largest bar to the right of each bar
		
	    int right_max_bar = A[n-1];
		int left_max_bar = A[0];
		int total_water = 0;
		
		for(int i=1; i<n; i++)
		{
			lMax[i] = left_max_bar;
			rMax[i] = right_max_bar;
			
			if(A[i] > left_max_bar)
				left_max_bar = A[i];
			
			if(A[n-i-1] > right_max_bar)
				right_max_bar = A[n-i-1];
		}
		
		for(int i=1;i<n-1; i++)
		{
			int min = Math.min(lMax[i],rMax[i]);
			int net_water = min - A[i];
			if(net_water > 0)
				total_water+= net_water;
		}
		
		return total_water;
	}
	
	// Time Complexity  : O(n^2)
	// Space Complexity : O(1)
	// Brute force approach
	
	static int findTrappedWater2(int A[])
	{
		int n = A.length;
		int total_water = 0;
		
		for(int i=1; i<n-1; i++)
        {
			int lMax = getLeftMax(i,A,n);
			int rMax = getRightMax(i,A,n);
			int min = Math.min(lMax, rMax);
			
			int net_water = min - A[i];
			if(net_water > 0)
				total_water += net_water;
		}
		
		return total_water;
	}
	
	static int getLeftMax(int a, int A[], int n)
	{
		int max = 0;
		for(int i = a-1; i>=0; i--)
		{
			if(max < A[i])
				max = A[i];
		}
		return max;
	}
	
	static int getRightMax(int b, int A[], int n)
	{
		int max = 0;
		for(int i=b+1; i<n; i++)
		{
			if(max < A[i])
				max = A[i];
		}
		return max;
	}
}