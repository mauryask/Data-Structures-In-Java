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
		if(parent[root] == root)
			return root;
		while(parent[root] != root)
			root = parent[root];
		parent[x] = root;
		return parent[x];
	}
	
	static void union(int x, int y, int ans[])
	{
	   int xRoot = find(x); // parent of x
	   int yRoot = find(y); // parent of y
	   if(xRoot == yRoot)
		   return;
	   
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
		int ans[] = new int[2];
		makeSet(n);
		union(0,1,ans);
		union(1,2,ans);
		union(2,3,ans);
		union(0,3,ans);
		union(0,4,ans);
		out.println(find(2));
	}
}