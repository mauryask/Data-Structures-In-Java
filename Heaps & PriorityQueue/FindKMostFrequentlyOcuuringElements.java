/*
* T(n) : O(n*logk)
* S(n) : O(n)
*/
import static java.lang.System.*;
import java.util.*;

public class FindKMostFrequentlyOcuuringElements 
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
	
	static void printKMostFrequentElements(int[] A, int n, int k)
	{
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int x : A)
			map.put(x, map.getOrDefault(x, 0)+1);
		/*
		* Min Heap 
		* put the elements based on the frequency
		*/
		Queue<Util> q = new PriorityQueue<>((a, b)->{
			return a.frequency - b.frequency;
		});
		
		int i=0, j=0;
		
		for(Map.Entry<Integer, Integer> m : map.entrySet())
		{
			q.add(new Util(m.getKey(), m.getValue()));
			
			if(q.size() == k+1)
			{
				q.remove();
			}
		}
		
		while(!q.isEmpty())
			out.print(q.remove().element+" ");
	}
	
	public static void main(String [] args)
	{
		int A[] = {3, 1, 4, 4, 5, 2, 6, 1};
		int n  = A.length;
		int k = 2;
		
		printKMostFrequentElements(A , n, k);
	}
}