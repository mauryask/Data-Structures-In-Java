/*
* T(n) : O(m*n)
* S(n) : O(mn)
*****
* https://leetcode.com/problems/number-of-islands/
*/
import static java.lang.System.*;
import java.util.*;

public class FindNumberOfIslands 
{
	static int countIslands(int[][] sea, int m, int n)
	{
	   int count = 0;
	   boolean visited[][] = new boolean[m][n];

	   for(int i=0; i<m; i++)
	   {
		   for(int j=0; j<n; j++)
		   {
			   if(sea[i][j] == 1 && !visited[i][j])
			   {
				   count++;
				   countUtil(sea, visited, i, j, m, n);
			   }
		   }
	   }
	   
	   return count;
	}
	
	
	static void countUtil(int[][] sea, boolean visited[][], int i, int j, int m, int n)
	{
		if(isValid(sea, i, j, m, n, visited))
		{
			visited[i][j] = true;
			
		    // chek left 
			countUtil(sea, visited, i, j-1, m, n);
			// check up 
			countUtil(sea, visited, i-1, j, m, n);
			// check bottom 
			countUtil(sea, visited, i+1, j, m, n);
			// check right 
			countUtil(sea, visited, i, j+1, m, n);	
		}
	}
	
	static boolean isValid(int sea[][],int i, int j, int m , int n, boolean[][] visited)
	{
		return i >= 0 && i < m && j >= 0 && j<n && sea[i][j]==1 && !visited[i][j]; 
	}
	
	public static void main(String args[])
	{
		int sea[][] = {{1, 1, 0, 0, 0},
					   {1, 1, 0, 0, 0},
					   {0, 0, 1, 0, 0},
					   {0, 0, 0, 1, 1}};
					   
		int m = sea.length;
		int n = sea[0].length;
		
		out.println(countIslands(sea, m , n));
	}
}