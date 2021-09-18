/*
* T(n) : O(n*logn)
* S(n) : O(n)
*/

import static java.lang.System.*;
import java.util.*;

public class SortArrayInDescendingOrderBasedOnFrequency
{
	static class Util 
	{
		int element;
		int frequency;
		
		Util(int element, int frequency)
		{
			this.element = element;
			this.frequency = frequency;
		}
	}
	
	static void printKMostFrequentElements(int[] A, int n)
	{
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int x : A)
			map.put(x, map.getOrDefault(x, 0)+1);
		/*
		* max heap 
		* put the elements based on the frequency
		*/
		Queue<Util> q = new PriorityQueue<>((a, b)->{
			return b.frequency - a.frequency;
		});
	
		for(Map.Entry<Integer, Integer> m : map.entrySet())
			q.add(new Util(m.getKey(), m.getValue()));

		int i = 0;
		
		while(!q.isEmpty())
		{
		   Util u = q.remove();
		   int ele = u.element;
		   int freq = u.frequency;
		   
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