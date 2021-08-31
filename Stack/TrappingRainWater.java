/*
* Time complexity: O(n)
* Space complexity: O(n)
****************
** https://www.geeksforgeeks.org/trapping-rain-water/
*/
import static java.lang.System.*;

public class TrappingRainWater
{
	static int totalWater(int height[], int n)
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
		* While doing this include the building height
		* as well (if building height > left highest building)
		* then building height itself will be largest buildings
		* to the left same goes with highest right building
		*/
		
		for(int i=1; i<n; i++)
			maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
		for(int i=n-2; i>=0; i--)
			maxRight[i] = Math.max(maxRight[i+1], height[i]);
		
		int waterSum = 0;
		
		for(int i=0; i<n; i++)
		{
			int minHeight = Math.min(maxLeft[i], maxRight[i]);
		    waterSum += minHeight - height[i];
		}
		
		return waterSum;
	}
	
	public static void main(String [] args)
	{
		int height[] = {1,0,5,2,0,4};
		int n = height.length;
		
		out.println("total water = " + totalWater(height, n) + " units");
	}
}