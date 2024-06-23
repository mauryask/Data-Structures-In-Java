/*
* T(n) : O(E * log V)
* S(n) : O(V)
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
        int setX = find(x, parent);
        int setY = find(y, parent);
		
        if(setX == setY)
        {
           out.println("Edge causing cycle: ( "+x+", "+y+")");
        }else
        {
            int rankX = Math.abs(parent[setX]);
            int rankY = Math.abs(parent[setY]);

            if(rankY > rankX)
            {
                parent[setX] = setY;
                parent[setY] -= rankX;
            }
            else
            {
                parent[setY] = setX;
                parent[setX] -= rankY;
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