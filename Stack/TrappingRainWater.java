/*
* Time complexity: O(n)
* Space complexity: O(n)
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
		*/
		for(int i=1; i<n; i++)
			maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
		for(int i=n-2; i>=0; i--)
			maxRight[i] = Math.max(maxRight[i+1], height[i]);
		
		int waterSum = 0;
		
		for(int i=0; i<n; i++)
		{
			int minHeight = Math.min(maxLeft[i], maxRight[i]);
			
			if(height[i] < minHeight)
				waterSum += minHeight - height[i];
		}
		
		return waterSum;
	}
	
	public static void main(String [] args)
	{
		int height[] = {3,0,0,2,0,4};
		int n = height.length;
		
		out.println(totalWater(height, n));
	}
}