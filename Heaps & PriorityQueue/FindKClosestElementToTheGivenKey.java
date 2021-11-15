/*
* T(n) : O(n*lok) 
* S(n) : O(k)
*/

import static java.lang.System.*;
import java.util.*;

public class FindKClosestElementToTheGivenKey 
{
	static class Util
	{
	   int value;
	   int diff;
     
	   Util(int value, int diff)
	   {
		   this.value = value;
		   this.diff = diff;
	   }
	}
	
	static void printKClosetElements(int[] A, int n, int k,
	int key)
	{
		/*
		* Max Heap 
		* Put the elements on the basis  
		* of difference with the key
		*/
		Queue<Util> q = new PriorityQueue<>((a, b)->{
			return b.diff - a.diff;
		});

		for(int j=0; j<n; j++)
		{
		   q.add(new Util(A[j], Math.abs(A[j]-key)));
		   
		   if(q.size() > k)
			   q.remove();
		}
		
		while(!q.isEmpty())
			out.print(q.remove().value+" ");
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