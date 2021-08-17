// forget the previous implementations
// this is the best implemntaation as of now
// T(n) = O(m*logn) --> with path compression
// T(n) = O(m*n) --> without path compression 

//**************** Union By Rank (Height) ***************

import java.util.*;
import static java.lang.System.*;

public class DisjointSetPathCompression
{
	static int []rank,parent;
	static void makeSet(int n)
	{
		parent = new int[n];
		rank = new int[n];
		for(int i=0; i<n; i++)
			parent[i] = i;
	}
	
	static int find(int x)
	{
		// union without path compression
		/*
		if(parent[x] == x)
			return x;
		return find(parent[x]);
		*/
		// union with path compression
		
		int root =  x;
		
		//Check if the elemnt is the parent itself
		if(parent[root] == root)  
			return root;
		
		while(parent[root] != root)
			root = parent[root];
		parent[x] = root;
		
		return parent[x];
	}
	
	static void union(int x, int y)
	{
	   int xRoot = find(x); // parent of x
	   int yRoot = find(y); // parent of y
	   
	   /* 
	    * if the elements belong to same set
	    * union can not be performed
		*/
	   if(xRoot == yRoot)
		   return;
	   
	   /*
	   * If they belong from different sets
	   * One with the higher rank will be the parsent
	   */
	   if(rank[xRoot] < rank[yRoot])
		   parent[xRoot] = yRoot; 
	   else if(rank[xRoot] > rank[yRoot])
		   parent[yRoot] = xRoot;
	   else
	   {
		   parent[yRoot] = xRoot;
		   rank[xRoot] += 1;
	   }
	}
	
	public static void main(String [] args)
	{
	   	int n = 5;
		makeSet(n);
		union(0,1);
		union(1,2);
		union(2,3);
		union(0,3);
		union(0,4);
		out.println(find(2));
	}
}