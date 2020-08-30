/**
* this is the "UnionByRank with Path Compression" implementation of DisjointSet
* Here time complexity for union : O(1)
* Time complexity of makeSet() : O(n)
* Time Complexity for find() : O(logn)  
* If there are m consecutive find operation 
* Then time complexity : O(m * logn) -> worst case
* Total time complexity : O(n + m * logn)
*/

// here path compression helps to the 
// speedup the future find() operation 


public class DisjointSetPathCompression 
{
	static int parent_set[];
	int n; //number of components
	DisjointSet(int n)
	{
		this.n = n;
		parent_set = new int[n];
	}
	
	void makeSet()
	{
		for(int i=0; i<n; i++)
		{
			parent_set[i] = -1;
		}
	}
	
	int find(int item) // O(n)
	{
		int root = item;
		if(parent_set[root] < 0)
			return root;
		//path compression
		//it gives amortize constant time complexity
		while(parent_set[root] >= 0)
			root = parent_set[root];
		parent_set[item] = root;		
		return parent_set[item];
	}
	
	
   void unionByRank(int set_1, int set_2) 
	{ 	
	   if(find(set_1) == find(set_2))
		   return;
	   if(parent_set[set_2] < parent_set[set_1])
		   parent_set[set_1] = set_2;
	   else
	   {
		   if(parent_set[set_1] == parent_set[set_2])
			   parent_set[set_1]--;
		   parent_set[set_2] = set_1;
	   }		   
	} 
	
	public static void main(String [] args)
	{
		DisjointSetPathCompression d = new DisjointSetPathCompression(8);
		
		d.makeSet();
		
		d.unionByRank(0,1);
		d.unionByRank(2,3);
		d.unionByRank(4,5);
		d.unionByRank(6,7);
		d.unionByRank(0,2);
		d.unionByRank(4,6);
		d.unionByRank(0,4);
			
	for(int i=0; i<8 ; i++)
   	    System.out.print(parent_set[i]+" ");
	
	System.out.println("\n"+d.find(7));
	
	}
}