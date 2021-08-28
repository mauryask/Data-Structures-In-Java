import static java.lang.System.*;
import java.util.*;
public class MaxAreaHistogram
{
	static int findMaxArea(int height[], int n)
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
			while(!stack.isEmpty() && height[stack.peek()] >= height[i])
				stack.pop();
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