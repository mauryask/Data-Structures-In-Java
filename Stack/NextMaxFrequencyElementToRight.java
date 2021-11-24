import java.util.*;
import static java.lang.System.*;

public class NextMaxFrequencyElementToRight
{
	static void nextMaxFreq(int []A, int n)
	{
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		int res[] = new int[n];
		
		for(int x: A)
			map.put(x, map.getOrDefault(x, 0)+1);
		
		//out.print(map);
		
		for(int i=n-1; i>=0; i--)
		{
			while(!stack.isEmpty() && map.get(stack.peek())<= map.get(A[i]))
				stack.pop();
			
			if(stack.isEmpty())
				res[i] = -1;
			else if(map.get(stack.peek()) > map.get(A[i]))
				res[i] = stack.peek();
			
			stack.push(A[i]);
 		}
		
		for(int x: res)
			out.print(x+" ");
	}
	 
	public static void main(String [] args)
	{
		int A[]= {1, 1, 1, 2, 2, 2, 2, 11, 3, 3};
		int n = A.length;
		nextMaxFreq(A, n);
	}
}