/* Very Important
*****************
* Time complexity: O(m * n)
* Space complexity: O(n) -> height array
*/

import static java.lang.System.*;
import java.util.*;

class MaxAreaHistogram
{
	static int maxAreaHistogram(int height[], int n)
	{
		int leftSmaller[] = leftSmaller(height, n);
		int rightSmaller[] = rightSmaller(height, n);
		int maxArea = Integer.MIN_VALUE;		
		
		for(int i=0; i<n; i++)
		{
			int width = rightSmaller[i] - leftSmaller[i] -1;
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
			while(!stack.isEmpty() && 
				height[stack.peek()] >= height[i])
				stack.pop();
			if(stack.isEmpty())
				temp[i] = -1;
			else
				temp[i] = stack.peek();
			stack.push(i);
		}
		return temp;		
	}
}

public class MaxAreaInBinaryMatrix
{
	static int maxArea(int A[][], int m, int n)
	{
		int height[] = new int[n];
		int maxArea = Integer.MIN_VALUE;
		
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(A[i][j] == 0)
					height[j] = 0;
				else
					height[j] += A[i][j];	
			}
			
				maxArea = Math.max(maxArea, 
			new MaxAreaHistogram().
			maxAreaHistogram(height, n));	
		}
		
		return maxArea;
	}
	
	public static void main(String [] args)
	{
		int A[][] = {{0, 1, 1, 0},
					 {1, 1, 1, 1},
					 {1, 1, 1, 1},
					 {1, 1, 0, 0}};
		int m = 4;
		int n = 4;
		
		out.println(maxArea(A, m, n));	
	}
}
