/*
* T(n) : O(n)
* S(n) : O(n)
*/

import static java.lang.System.*;

public class TrapingRainWater
{
	static int trappedWater(int[] A, int n)
	{
		if(n < 3)
			return 0;
		
		int lMax[] = leftMax(A, n);
		int rMax[] = rightMax(A, n);
		
		int waterSum = 0;
		
		for(int i=0; i<n; i++)
		{
			int min = Math.min(lMax[i], rMax[i]);
			waterSum += min - A[i];
		}
		return waterSum;
	}
	
	static int[] leftMax(int A[], int n)
	{
		int Lmax[]  = new int[n];
		Lmax[0] = A[0];
		
		for(int i=1; i<n; i++)
			Lmax[i] = Math.max(Lmax[i-1], A[i]);
		return Lmax;
	}
	
	static int[] rightMax(int A[], int n)
	{
		int Rmax[]  = new int[n];
		Rmax[n-1] = A[n-1];
		
		for(int i=n-2; i>=0; i--)
			Rmax[i] = Math.max(Rmax[i+1], A[i]);
		return Rmax;
	}
	
	/* =========== Brute Force ============ */
	
	/*
	* T(n) : O(n*n)
	* S(n) : O(1)
	*/
	static int water(int A[], int n)
	{
		if(n < 3)
			return 0;
		
		int sum = 0;
		
		for(int i=1; i<n-1; i++)
		{
			int lh = findLeft(A, i);
			int rh = findRight(A, i);
			
			int min = Math.min(lh, rh);
			
			if(min > A[i])
				sum += min - A[i];
		}
		
		return sum;
	}
	
	
	static int findLeft(int A[], int n)
	{
		int max = Integer.MIN_VALUE;
		for(int i=0; i<=n; i++)
		   max = Math.max(A[i], max);
		
		return max;		
	}
	
	static int findRight(int A[], int n)
	{
		int max = Integer.MIN_VALUE;
				
		for(int i=n; i<A.length; i++)
		   max = Math.max(A[i], max);
		
		return max;
	}
	
	public static void main(String [] args) 
	{
	   int A[] = {0,1,0,2,1,0,1,3,2,1,2,1};
	   int n = A.length;
	   //out.println(trappedWater(A, n));
	   out.println(water(A, n));
	}
}
