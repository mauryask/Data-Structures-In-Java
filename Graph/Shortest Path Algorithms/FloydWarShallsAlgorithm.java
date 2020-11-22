// this algo uses dynamic programming approach
// time complexity  : O(V^3)
// space complexity : O(V^2)

class AllPairShortestPath
{
	void floydWarshall(int G[][], int v_num)
	{
		int i,j,k;			
			for(k=0; k<v_num; k++)
			{
				for(i=0; i<v_num; i++)
				{
					for(j=0; j<v_num; j++)
					{
						// the purpose to use G[i][k] != inf 
						// id to prevent overflow
						// because when you will add something to infinite
						// it is going to be out of range og "int"
						
						if(G[i][k] != inf && G[k][j] != inf && 
						(G[i][k] + G[k][j]) < G[i][j])
							G[i][j] = G[i][k] + G[k][j];
					}
				}
			}
	}
	
	void printDist(int dist[][], int v_num)
	{
		for(int i=0; i<v_num; i++)
		{
			for(int j=0; j<v_num; j++)
			{
				System.out.println(i+" ==> "+j+" = "+dist[i][j]);
			}
			
			System.out.println("\n===============\n");
		}
	}
}

public class FloydWarShallsAlgorithm
{
	static final int inf = Integer.MAX_VALUE;
	
	public static void main(String [] args)
	{
		AllPairShortestPath a = new AllPairShortestPath();
		int v_num = 4;
		//create a n*n matrix : n is number of vertices
		int graph[][] = {
							{0, 5, inf, 10},
							{inf,0 , 3, inf},
							{inf, inf, 0, 1},
							{inf, inf, inf, 0}
		                };
		
		a.floydWarshall(graph,v_num);
		a.printDist(graph, v_num);
	}
}