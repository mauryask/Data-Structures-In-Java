/*
* T(n) : O(m * logn)
* Here logn is for single find operation
* for m find operations : m * logn
* S(n) : O(n)
**/
import static java.lang.System.*;
import java.util.*;

public class UnionBySizeWithPathCompression 
{
    static int find(int key, int[] parent)
    {
        if(parent[key] < 0)
          return key;
         
        int temp  = key;

        //Check if parent[temp] is not negative
        while(parent[temp] >= 0)
           temp = parent[temp];

        parent[key] = temp;

        return temp;      
    }

    static void union(int x, int y, int[] parent)
    {
        int parentX = find(x, parent);
        int parentY = find(y, parent);

        out.println(parentX+", "+parentY);

        if(parentX == parentY)
        {
           out.println("Edge causing cycle: ( "+x+", "+y+")");
        }else
        {
            int rankX = Math.abs(parent[parentX]);
            int rankY = Math.abs(parent[parentY]);

            if(rankY > rankX)
            {
                parent[parentX] = parentY;
                parent[parentY] -= rankX;
            }
            else
            {
                parent[parentY] = parentX;
                parent[parentX] -= rankY;
            }
        }
    }
  
    public static void main(String[] args)
	{
        int n = 4;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
	    int edges[][] = {{0,1}, {1,2},{2, 3}, {3, 0}};    
		
		for(int[] edge : edges)
          union(edge[0], edge[1], parent); 
    }
}