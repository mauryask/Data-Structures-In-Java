/*
* T(n) : O(n*logk)
* S(n) : O(k)
*/

import static java.lang.System.*;
import java.util.*;

public class KClosestPointsToOrigin 
{
	static class Util 
	{
	  int x;
	  int y;
	  int dist;
       
       Util(int x, int y)
	   {
		   this.x =x;
		   this.y = y;
		   dist = (int)Math.sqrt(x*x + y*y);
	   }	   
	}
	
	static void printKclosestPoints(int[][] A, int n, int k)
	{
		/*
		* Max Heap based on distsance from origin
		*/
		Queue<Util> q = new PriorityQueue<>((a, b)->{
			return b.dist - a.dist;
		});
		
		for(int[] x : A)
		{
			q.add(new Util(x[0], x[1]));
			
			if(q.size() == k+1)
				q.remove();
		}
		
		while(!q.isEmpty())
		{
			Util temp = q.remove();
			int x = temp.x;
			int y = temp.y;
			
			out.println("("+x+", "+y+")");
		}
	}
	
	public static void main(String [] args)
	{
		int A[][] = {{3, 3}, {5, -1}, {-2, 4}};
		int n = A.length;
		int k = 2;
		
		printKclosestPoints(A, n, k);
	}
}