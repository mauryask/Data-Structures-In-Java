import java.util.*;
import static java.lang.System.*;

public class FindTreeHeightWithParentArray
{
	// Time complexity: O(n^2)
	// Space complexity: O(n)
	static int getHeight(int parent[], int n)
	{
		Queue<Integer> q = new ArrayDeque<>();
		q.add(0);
		q.add(-1);
		int level = 0;
		
		while(!q.isEmpty())
		{
			int root = q.poll();
			if(root == -1)
			{
				if(!q.isEmpty())
					q.add(-1);
				level++;
				continue;
			}
			
			for(int i=1; i<n;i++)
			{
				if(parent[i] == root)
					q.add(i); //i is child, parent[i] is parent
			}
		}
		
		return level;
	}
	
	// Time complexity: O(n^2)
	// Space complexity: O(1)
	// It will return exact height
    // Not total number of levels
	// The previous heights are not being stored here
	static int getHeight2(int parent[], int n)
	{
		int height = Integer.MIN_VALUE;
		for(int i=0; i<n; i++)
		{
			int j = i;
			int count = 0;
			while(parent[j] != -1)
			{
				j = parent[j];
				count++;
			}
			
			height = Math.max(height, count);
		}
		
		return height;
	}
	
	// Time complexity: O(n)
	// Space complexity: O(n)
	// Best solution
	// gives exact height not level
	// we are storing the previously calculated heights
	static int getHeight3(int parent[], int n)
	{
		int height[] = new int[n];
		Arrays.fill(height, -1);
		int maxHeight = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++)
		{
			int j = i;
			int count = 0;
			
			while(parent[j] != -1) // it is not root
			{
				j = parent[j];
				if(height[j] != -1) // if height is aleady calculated
				{
					count += height[j] +1;
					break;
				}	
				
				count++;
			}
			height[i] = count; // store height
			maxHeight = Math.max(maxHeight, count);
		}
		return maxHeight;
	}
	
	
	public static void main(String [] args)
	{
		int parent[] = {-1,0,1,6,6,0,0,2,7};
		int height = getHeight3(parent, parent.length);
		out.print(height);
	}
}