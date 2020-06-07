/**
* this is the Fast Union(Quick Find) implementation
* Here time complexity for union : O(1)
* time complexity of makeSet() : O(n)
* Time Complexity for find() : O(n)  
* If there are n consecutive find operation 
* then time complexity : O(mn) -> worst case
* total time complexity : O(n) + (mn) : O(mn)
*/

public class DisjointSetSlowFind 
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
			parent_set[i] = i;
		}
	}
	
	int find(int item) // O(n)
	{
		if(parent_set[item] == item)
			return item;
		else
			return find(parent_set[item]);
	}
	
	void union(int set_1, int set_2) // O(1)
	{
		//if both belong from the same set
		if(find(set_1) == find(set_2))
			return; //do nothing
		else
			parent_set[set_2] = set_1; //make 2 as parent of 1
	}
	
	public static void main(String [] args)
	{
		DisjointSetSlowFind d = new DisjointSetSlowFind(8);
		
		d.makeSet();
		
		d.union(0,1);
		d.union(2,3);
		d.union(4,5);
		d.union(6,7);
		d.union(4,6);
		d.union(5,6);
		
		System.out.println(d.find(6));
	}
}