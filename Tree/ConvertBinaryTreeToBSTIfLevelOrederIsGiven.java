/*
* T(n) : O(n)
* S(n) : O(n)
*/

import static java.lang.System.*;
import java.util.*;

class Util 
{
	int ele;
	int index;
	
	Util(int ele, int index)
	{
		this.ele = ele;
		this.index = index;
	}
}

public class ConvertBinaryTreeToBSTIfLevelOrederIsGiven 
{
	static int minSwaps(int[] A, int n)
	{
		List<Util> inOrder = new ArrayList<>();
		getInorder(A, inOrder, n, 0);		
		Collections.sort(inOrder, (a,b)->{
			return a.ele - b.ele;
		});
		
		int count = 0;
		int i = 0;

		while(i<n)
		{
			Util util = inOrder.get(i);
			int index = inOrder.get(i).index;
			
			if(index == i)
				i++;
			else
			{
				inOrder.set(i, inOrder.get(index));
				inOrder.set(index, util);
				count++;
			}
		}
		
		return count;
	}
	
	// Converting level order to in order
	static void getInorder(int[] A, List<Util> inOrder, int n, int rootIndex)
	{
		Stack<Integer> stack = new Stack<>();
		int i = 0;
	     
		 while(true)
		 {
			 while(rootIndex < n)
			 {
				 stack.push(rootIndex);
				 rootIndex = 2 * rootIndex + 1;
			 }
			 
			 if(stack.isEmpty())
				 break;
			 rootIndex = stack.pop();
			 inOrder.add(new Util(A[rootIndex] , i++));
			 rootIndex = 2 * rootIndex + 2;
		 }
	}
	
	public static void main(String [] args)
	{
	   int A[] = {5,6,7,8,9,10,11};
       int n = A.length;
       out.println(minSwaps(A, n));	   
	}
}