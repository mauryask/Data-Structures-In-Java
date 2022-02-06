/*
* T(n) : O(n*lok) 
* S(n) : O(k)
*/

import static java.lang.System.*;
import java.util.*;

public class FindKClosestElementToTheGivenKey 
{
	static void printKClosetElements(int[] A, int n, int k,
	int key)
	{
		/*
		* Max Heap 
		* Put the elements on the basis  
		* of difference with the key
		*/
		Queue<Integer> q = new PriorityQueue<>((a, b)->{
			return (int)(Math.abs(b-key) - Math.abs(a-key));
		});

		for(int j=0; j<n; j++)
		{
		   q.add(A[j]);
		   
		   if(q.size() > k)
			   q.remove();
		}
		
		while(!q.isEmpty())
			out.print(q.remove()+" ");
	}
	
	public static void main(String [] args)
	{
		int A[] = {12, 16, 22, 30, 35, 39, 42,45, 48, 50, 53, 55,56,45, 48, 50, 53, 55, 56};
		int n = A.length;
		int k = 4;
		int key = 35;
		
		printKClosetElements(A, n, k, key);
	}
}