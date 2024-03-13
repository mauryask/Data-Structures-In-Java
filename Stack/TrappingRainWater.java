/*
* T(n) : O(n)
* S(n) : O(n)
*************
* If there is no building larger
* than  current to the left then 
* the building itself going to be largest 
* to its left
******
* Similiarly if there is no buildiong to rightMax
* larger than the current building 
* then the building itself going to be largest
* to its right
*****
* The idea is to include the building itself to find 
* largest buildings
** https://www.geeksforgeeks.org/trapping-rain-water/
*/

import static java.lang.System.*;

public class TrappingRainWater
{
	static int trappedWater(int height[], int n)
	{
		/*
		* Water can only be stored if there at
		* least 3 buildings
		*/
		if(n<3)
			return 0;
		
		int[] maxLeft = new int[n];
		int[] maxRight = new int[n];
		
		maxLeft[0] = height[0];
		maxRight[n-1] = height[n-1];
		
		/*
		* Finding max height building to the left and 
		* to the right of each and every building
		* While doing this include the current building height
		* as well (if building height > left highest building)
		* then building height itself will be largest buildings
		* to the left same goes with highest right building
		*/
		
		for(int i=1; i<n; i++)
		{
			//corresponding index at right side
			int j = n-i-1;
			maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
			maxRight[j] = Math.max(maxRight[j+1], height[j]);
		}
				
		int waterSum = 0;
		
		for(int i=0; i<n; i++)
		{
			int minHeight = Math.min(maxLeft[i], maxRight[i]);
		    waterSum += minHeight - height[i];
		}
		
		return waterSum;
	}
	
	/* =========== Brute Force ============ */
	
	/*
	* T(n) : O(n*n)
	* S(n) : O(1)
	*/
	
	static int bruteForce(int A[], int n)
	{
		if(n < 3)
			return 0;
		
		int sum = 0;
		
		for(int i=0; i<n; i++)
		{
			int lMax = findLeft(A, i);
			int rMax = findRight(A, i);
			
			int minHeight = Math.min(lMax, rMax);
		
			sum += minHeight - A[i];
		}
		
		return sum;
	}
	
	
	static int findLeft(int A[], int i)
	{
		int max = A[i];
		for(int j=i-1; j>=0; j--)
		   max = Math.max(A[j], max);
		return max;		
	}
	
	static int findRight(int A[], int i)
	{
		int max = A[i];
				
		for(int j=i+1; j<A.length; j++)
		   max = Math.max(A[j], max);
		return max;
	}
	
	public static void main(String [] args) 
	{
	   int A[] = {1,0,5,2,0,4};
	   int n = A.length;
	   //out.println(trappedWater(A, n));
	   out.println(bruteForce(A, n));
	}
}
