/*
* T(n) : O(n*logk)
* S(n) : O(n)
*/
import static java.lang.System.*;
import java.util.*;

public class FindKMostFrequentlyOcuuringElements 
{
	static void printKMostFrequentElements(int[] A, int n, int k)
	{
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int x : A)
			map.put(x, map.getOrDefault(x, 0)+1);
		/*
		* Min Heap 
		* put the elements based on the frequency
		*/
		
		Queue<Integer> q = new PriorityQueue<>((a, b)->{
			return map.get(a) - map.get(b);
		});
		
		for(Integer key : map.keySet())
		{
			q.add(key);
			
			if(q.size() > k)
				q.remove();
		}
		
		while(!q.isEmpty())
			out.print(q.remove()+" ");
	}
	
	public static void main(String [] args)
	{
		int A[] = {3, 1, 4, 4, 5, 2, 6, 1};
		int n  = A.length;
		int k = 2;
		
		printKMostFrequentElements(A , n, k);
	}
}