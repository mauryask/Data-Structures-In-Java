/*
* Time complexity  : O(n)
* Space complexity : O(n)
**************************
* The idea id to find the next smaller 
* bar to the left and next smaller bar to the rightSmaller
* of the current bar (rightSmaller - leftSmaler - 1)
* is going to be the width of the rectangle formed
* by the current bar
******
* area of rectangle formed by each bar
* height of bar *  width of rectangle formed by this
*/

import static java.lang.System.*;
import java.util.*;

public class MaxAreaHistogram
{
	static int findMaxArea(int height[], int n)
	{
		// find next smaller bar to the left of each
		int leftSmaller[] = leftSmaller(height, n);
		// find next smaller bar to the right of each
		int rightSmaller[] = rightSmaller(height, n);
		
		int maxArea = Integer.MIN_VALUE;		
		
		for(int i=0; i<n; i++)
		{
			// find width of rectangle
			int width = rightSmaller[i] - leftSmaller[i] -1;
			// find max area
			maxArea = Math.max(maxArea, height[i] * width);
		}	
		
		return maxArea;		
	}
	
	static int[] rightSmaller(int height[], int n)
	{
		int temp[] =  new int[n];
		Stack<Integer> stack = new Stack<>();
        
		for(int i= n-1; i>=0; i--)
		{
			while(!stack.isEmpty() && height[stack.peek()] >= height[i])
				stack.pop();
			// if stack is empty means
			// no such bar to the right of the bar
			// which is smaller than this
			// assume that it will be present at index: n (hypothetically)
			if(stack.isEmpty())
				temp[i] = n;
			else 
				temp[i] = stack.peek();
			stack.push(i);
		}
		
		return temp;		
	}
	
	static int[] leftSmaller(int height[], int n)
	{
		int temp[] =  new int[n];
		Stack<Integer> stack = new Stack<>();
        
		for(int i=0; i<n; i++)
		{
			while(!stack.isEmpty() && height[stack.peek()] >= height[i])
				stack.pop();
			// if stack is empty means
			// no such bar to the left of the bar
			// which is smaller than this
			// assume that it will be present at index: -1 (hypothetically)
			if(stack.isEmpty())
				temp[i] = -1;
			else
				temp[i] = stack.peek();
			stack.push(i);
		}
		return temp;		
	}
		
	public static void main(String [] args)
	{
		int height[] = {6, 2, 5, 4, 5, 1, 6};
		int n = height.length;
		
		out.println(findMaxArea(height, n));
	}
}