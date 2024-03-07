/*
* T(n) : O(n*logn)
* S(n) : O(n)
*/

import static java.lang.System.*;
import java.util.*;

public class SortArrayInDescendingOrderBasedOnFrequency
{
	static void printKMostFrequentElements(int[] A, int n)
	{
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int x : A)
			map.put(x, map.getOrDefault(x, 0)+1);
		/*
		* max heap 
		* put the elements based on the frequency
		*/
		Queue<Integer> q = new PriorityQueue<>((a, b)->{
			return map.get(b) - map.get(a);
		});
	
		for(Map.Entry<Integer, Integer> m : map.entrySet())
			q.add(m.getKey());

		int i = 0;
		
		while(!q.isEmpty())
		{
		   int ele = q.remove();
		   int freq = map.get(ele);
		   while(freq-->0)
		      A[i++] = ele;
		}
		
		for(int x : A)
			out.print(x+" ");
	}
	
	public static void main(String [] args)
	{
		int A[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
		//{2, 5, 2, 8, 5, 6, 8, 8};
		int n  = A.length;
		printKMostFrequentElements(A , n);
	}
}