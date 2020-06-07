/**
* this is the Fast Union(Quick Find) implementation
* two ways to implement this: "unionByWeight" and "unionByRank"
* both i=of the find functions take O(n+ m*log(n))->(worst case)
* Here time complexity for union : O(1)
* time complexity of makeSet() : O(n)
* Time Complexity for find() : O(logn)  
* If there are n consecutive find operation 
* then time complexity : O(m * logn) -> worst case
* total time complexity : O(n + m * logn)
*/

public class DisjointSetQuickFind 
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
		if(parent_set[item] < 0)
			return item;
		else
			return find(parent_set[item]);
	}
	
	
	// union by weight(union by size)
	// here size will be totla nodes in the tree
	// if 3 nodes it will be stored as : -3
	void unionByWeight(int set_1, int set_2) // // O(n+m*log(n))
	{
		if(find(set_1) == find(set_2))
			return; 
		
		if(parent_set[set_2] < parent_set[set_1])
		{
			parent_set[set_2] += parent_set[set_1];
			parent_set[set_1] = set_2; 
		}
		else //when parent_set[set_2] >= parent_set[set_1] 
		{
			parent_set[set_1]+= parent_set[set_2]; 
			parent_set[set_2] = set_1;
		}
	}
	
	// union by rank(union by by height)
	// here we assume that height of the tree starts with 1
	// tree having one element : height -> 1
	// it will be stored as : -1
	void unionByRank(int set_1, int set_2) // O(n+m*log(n))
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
		DisjointSetQuickFind d = new DisjointSetQuickFind(8);
		
		d.makeSet();
		
		d.unionByRank(0,1);
		d.unionByRank(2,3);
		d.unionByRank(4,5);
		d.unionByRank(6,7);
		d.unionByRank(2,4);
		d.unionByRank(0,6);
		d.unionByRank(0,2);

   	    System.out.print(d.find(7));
	}
}